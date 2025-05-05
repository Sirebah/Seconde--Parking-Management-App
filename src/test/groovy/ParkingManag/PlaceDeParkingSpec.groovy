package ParkingManag

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PlaceDeParkingSpec extends Specification implements DomainUnitTest<PlaceDeParking> {

     void "test domain constraints"() {
        when:
        PlaceDeParking domain = new PlaceDeParking()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
