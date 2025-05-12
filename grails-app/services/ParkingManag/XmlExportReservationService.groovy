package ParkingManag

import groovy.transform.CompileStatic
import groovy.xml.MarkupBuilder


class XmlExportReservationService {

    def exportSingleReservation(Long id){
        def reservation = Reservation.get(id)

        if(!reservation) return "<error> error reservation not found <error/>"


        def writer = new StringWriter()

        def xml = new MarkupBuilder(writer)

        xml.reservation{
           voiture{
               "${'id'}"(reservation.voiture.id)
               "${'marque'}"(reservation.voiture.marque)
               "${'proprietaire'}"(reservation.voiture.proprietaire)

           }

            place{
                "${'id'}"(reservation.place.id)
                "${'numero'}"(reservation.place.numero)
                "${'estOccupee'}"(reservation.place.estOccupee)
            }
            "${'dateEntree'}"(reservation.dateEntree)

        }

        writer.toString()

    }



}