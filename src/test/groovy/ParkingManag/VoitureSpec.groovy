package ParkingManag

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class VoitureSpec extends Specification implements DomainUnitTest<Voiture> {

     void "test domain constraints"() {
        when:
        Voiture domain = new Voiture()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
