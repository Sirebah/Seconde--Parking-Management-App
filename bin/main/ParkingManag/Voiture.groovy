package ParkingManag

class Voiture {
    String immatriculation
    String marque
    String proprietaire

    static constraints = {
        immatriculation blank: false, unique: true
        marque blank: false
        proprietaire blank: false
    }

    String toString() {
        return "${marque} - ${immatriculation}"
    }
}