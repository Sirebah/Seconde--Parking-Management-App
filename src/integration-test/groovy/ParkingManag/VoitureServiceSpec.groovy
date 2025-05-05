package ParkingManag

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VoitureServiceSpec extends Specification {

    VoitureService voitureService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Voiture(...).save(flush: true, failOnError: true)
        //new Voiture(...).save(flush: true, failOnError: true)
        //Voiture voiture = new Voiture(...).save(flush: true, failOnError: true)
        //new Voiture(...).save(flush: true, failOnError: true)
        //new Voiture(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //voiture.id
    }

    void "test get"() {
        setupData()

        expect:
        voitureService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Voiture> voitureList = voitureService.list(max: 2, offset: 2)

        then:
        voitureList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        voitureService.count() == 5
    }

    void "test delete"() {
        Long voitureId = setupData()

        expect:
        voitureService.count() == 5

        when:
        voitureService.delete(voitureId)
        sessionFactory.currentSession.flush()

        then:
        voitureService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Voiture voiture = new Voiture()
        voitureService.save(voiture)

        then:
        voiture.id != null
    }
}
