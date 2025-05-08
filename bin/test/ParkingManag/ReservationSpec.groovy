package ParkingManag

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ReservationSpec extends Specification implements DomainUnitTest<Reservation> {

     void "test domain constraints"() {
        when:
        Reservation domain = new Reservation()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
