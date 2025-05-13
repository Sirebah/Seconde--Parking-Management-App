package ParkingManag

class Voiture {
    String immatriculation
    String marque
    String proprietaire
    Integer year

    static constraints = {
        immatriculation blank: false, unique: true
        marque blank: false
        proprietaire blank: false
        year blank: false, min: 1986, max: 2030
    }

    String toString() {
        return "${marque} - ${immatriculation}"
    }
}