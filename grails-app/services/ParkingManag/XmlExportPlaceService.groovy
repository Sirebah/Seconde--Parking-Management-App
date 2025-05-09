package ParkingManag

import groovy.xml.MarkupBuilder


class XmlExportPlaceService {

    def exportOnexmlPlace(long id){
        def place = PlaceDeParking.get(id)
        if(!place) return "<error>not place found</error>"

        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.parkingPlace{
            "${'id'}"(place.id)
            "${'numero'}"(place.numero)
            "${'estOccupee'}"(place.estOccupee)
        }
        return writer.toString()
    }
}