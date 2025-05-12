package ParkingManag

import groovy.xml.MarkupBuilder


class XmlExportVoitureService {
         def exportSingleCarToxml(Long id){
         def car = Voiture.get(id)
         if(!car) return "<error>Car not found</error>"


        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.voiture{
            "${'id'}"(car.id)
            "${'immatriculation'}"(car.immatriculation)
            "${'marque'}"(car.marque)
            "${'proprietaire'}"(car.proprietaire)


        }

             return writer.toString()


    }


}