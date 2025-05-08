package ParkingManag

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PlaceDeParkingServiceSpec extends Specification {

    PlaceDeParkingService placeDeParkingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PlaceDeParking(...).save(flush: true, failOnError: true)
        //new PlaceDeParking(...).save(flush: true, failOnError: true)
        //PlaceDeParking placeDeParking = new PlaceDeParking(...).save(flush: true, failOnError: true)
        //new PlaceDeParking(...).save(flush: true, failOnError: true)
        //new PlaceDeParking(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //placeDeParking.id
    }

    void "test get"() {
        setupData()

        expect:
        placeDeParkingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PlaceDeParking> placeDeParkingList = placeDeParkingService.list(max: 2, offset: 2)

        then:
        placeDeParkingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        placeDeParkingService.count() == 5
    }

    void "test delete"() {
        Long placeDeParkingId = setupData()

        expect:
        placeDeParkingService.count() == 5

        when:
        placeDeParkingService.delete(placeDeParkingId)
        sessionFactory.currentSession.flush()

        then:
        placeDeParkingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PlaceDeParking placeDeParking = new PlaceDeParking()
        placeDeParkingService.save(placeDeParking)

        then:
        placeDeParking.id != null
    }
}
