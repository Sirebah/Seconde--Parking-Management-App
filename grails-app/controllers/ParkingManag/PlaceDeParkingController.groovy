package ParkingManag

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PlaceDeParkingController {

    PlaceDeParkingService placeDeParkingService
    XmlExportPlaceService xmlExportPlaceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond placeDeParkingService.list(params), model:[placeDeParkingCount: placeDeParkingService.count()]
    }

    def show(Long id) {
        respond placeDeParkingService.get(id)
    }

    def create() {
        respond new PlaceDeParking(params)
    }

    def save(PlaceDeParking placeDeParking) {
        if (placeDeParking == null) {
            notFound()
            return
        }

        try {
            placeDeParkingService.save(placeDeParking)
        } catch (ValidationException e) {
            respond placeDeParking.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'placeDeParking.label', default: 'PlaceDeParking'), placeDeParking.id])
                redirect placeDeParking
            }
            '*' { respond placeDeParking, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond placeDeParkingService.get(id)
    }

    def update(PlaceDeParking placeDeParking) {
        if (placeDeParking == null) {
            notFound()
            return
        }

        try {
            placeDeParkingService.save(placeDeParking)
        } catch (ValidationException e) {
            respond placeDeParking.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'placeDeParking.label', default: 'PlaceDeParking'), placeDeParking.id])
                redirect placeDeParking
            }
            '*'{ respond placeDeParking, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        placeDeParkingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'placeDeParking.label', default: 'PlaceDeParking'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'placeDeParking.label', default: 'PlaceDeParking'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    def exportXml(Long id){

        def xmlContent = xmlExportPlaceService.exportOnexmlPlace(id)

        response.contentType = "application/xml"
        response.setHeader("content-disposition", "attachement; filename=reservation-${id}.xml")
        render xmlContent

    }


}
