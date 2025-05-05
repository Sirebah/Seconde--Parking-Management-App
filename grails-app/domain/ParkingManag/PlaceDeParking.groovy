package ParkingManag

class PlaceDeParking {
    String numero
    Boolean estOccupee = false

    static constraints = {
        numero blank: false, unique: true
        estOccupee nullable: false
    }

    String toString() {
        return "Place ${numero} - ${estOccupee ? 'Occupée' : 'Libre'}"
    }
}