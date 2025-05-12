package ParkingManag

import java.time.LocalDateTime

class Reservation {
    Voiture voiture
    PlaceDeParking place
    LocalDateTime dateEntree = LocalDateTime.now()


    static constraints = {
        voiture nullable: false
        place nullable: false

    }

    String toString() {
        return "${voiture} -> ${place} du ${dateEntree}"
    }
}
