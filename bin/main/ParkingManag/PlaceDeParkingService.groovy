package ParkingManag

import grails.gorm.services.Service

@Service(PlaceDeParking)
interface PlaceDeParkingService {

    PlaceDeParking get(Serializable id)

    List<PlaceDeParking> list(Map args)

    Long count()

    void delete(Serializable id)

    PlaceDeParking save(PlaceDeParking placeDeParking)

}