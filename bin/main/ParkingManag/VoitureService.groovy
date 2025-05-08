package ParkingManag

import grails.gorm.services.Service

@Service(Voiture)
interface VoitureService {

    Voiture get(Serializable id)

    List<Voiture> list(Map args)

    Long count()

    void delete(Serializable id)

    Voiture save(Voiture voiture)

}