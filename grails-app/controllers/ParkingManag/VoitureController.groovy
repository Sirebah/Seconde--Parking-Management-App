package ParkingManag

import grails.validation.ValidationException
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

//import parkingmanag.VoitureImportService


import static org.springframework.http.HttpStatus.*

class VoitureController {

    XmlExportVoitureService xmlExportVoitureService
    //VoitureImportService voitureImportService
    ImportXmlVoitureService importXmlVoitureService

    VoitureService voitureService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond voitureService.list(params), model:[voitureCount: voitureService.count()]
    }

    def show(Long id) {
        respond voitureService.get(id)
    }

    def create() {
        respond new Voiture(params)
    }

    def save(Voiture voiture) {
        if (voiture == null) {
            notFound()
            return
        }

        try {
            voitureService.save(voiture)
        } catch (ValidationException e) {
            respond voiture.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'voiture.label', default: 'Voiture'), voiture.id])
                redirect voiture
            }
            '*' { respond voiture, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond voitureService.get(id)
    }

    def update(Voiture voiture) {
        if (voiture == null) {
            notFound()
            return
        }

        try {
            voitureService.save(voiture)
        } catch (ValidationException e) {
            respond voiture.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'voiture.label', default: 'Voiture'), voiture.id])
                redirect voiture
            }
            '*'{ respond voiture, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        voitureService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'voiture.label', default: 'Voiture'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'voiture.label', default: 'Voiture'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }


    def exportXml(Long id){

        def xmlContent = xmlExportVoitureService.exportSingleCarToxml(id)
        response.contentType = "application/xml"
        response.setHeader("Content-disposition","attachement; filename=parkingCar-${id}.xml")
        render xmlContent
    }

    def importFromXml() {
        // Vérifier que la requête est bien multipart
        if (!(request instanceof MultipartHttpServletRequest)) {
            flash.message = "Aucun fichier reçu (la requête n'est pas de type multipart)."
            respond new Voiture(), view: 'create'
            return
        }

        // Cast en MultipartHttpServletRequest pour accéder à getFile()
        MultipartHttpServletRequest multiReq = (MultipartHttpServletRequest) request
        MultipartFile xmlFile = multiReq.getFile('xmlFile')

        try {
            Voiture voiture = importXmlVoitureService.importFromXml(xmlFile)
            // Renvoie vers le formulaire create.gsp prérempli
            respond voiture, view: 'create'
        } catch (IllegalArgumentException e) {
            flash.message = "Erreur d’import XML : ${e.message}"
            respond new Voiture(), view: 'create'
        }
    }





}
