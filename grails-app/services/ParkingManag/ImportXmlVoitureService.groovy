package ParkingManag

import groovy.xml.XmlParser
import groovy.util.slurpersupport.GPathResult
import org.springframework.web.multipart.MultipartFile
import grails.gorm.transactions.Transactional

@Transactional
class ImportXmlVoitureService {


    Voiture importFromXml(MultipartFile xmlFile) {
        if (xmlFile == null || xmlFile.empty) {
            throw new IllegalArgumentException("Le fichier XML est vide ou manquant.")
        }

        def root
        try {
            // XmlParser parse l’InputStream en un Node
            root = new XmlParser().parse(xmlFile.inputStream)
        } catch (Exception e) {
            throw new IllegalArgumentException("Erreur de parsing XML : ${e.message}", e)
        }

        // Extraction des valeurs : XmlParser renvoie des listes de Node
        String immatriculation = root.immatriculation?.text()?.trim()
        String marque         = root.marque?.text()?.trim()
        String proprietaire   = root.proprietaire?.text()?.trim()
        String yearText       = root.year?.text()?.trim()

        if (!immatriculation || !marque || !proprietaire || !yearText) {
            throw new IllegalArgumentException(
                    "XML invalide : éléments manquants (immatriculation, marque, proprietaire, year)."
            )
        }

        Integer year
        try {
            year = yearText.toInteger()
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Le champ <year> n’est pas un entier valide.")
        }

        // Création et validation GORM
        Voiture voiture = new Voiture(
                immatriculation: immatriculation,
                marque: marque,
                proprietaire: proprietaire,
                year: year
        )
        if (!voiture.validate()) {
            String errs = voiture.errors.allErrors*.defaultMessage.join('; ')
            throw new IllegalArgumentException("Contraintes violées : ${errs}")
        }

        return voiture
    }
}
