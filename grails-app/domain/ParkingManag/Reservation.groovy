package ParkingManag

import java.time.LocalDateTime

class Reservation {
    Voiture voiture
    PlaceDeParking place
    LocalDateTime dateEntree = LocalDateTime.now()
    LocalDateTime dateSortie

    static constraints = {
        voiture nullable: false
        place nullable: false
        dateSortie nullable: true
    }

    String toString() {
        return "${voiture} -> ${place} du ${dateEntree}"
    }
}
