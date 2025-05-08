package ParkingManag

import groovy.xml.MarkupBuilder


class XmlExportVoitureService {
         def exportSingleCarToxml(Long id){
         def car = Voiture.get(id)
         if(!car) return "<error>Car not found</error>"


        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.voiture{
            mkp.yieldUnescaped"""
                <id>${car.id}</id>
                <immatriculation>${car.immatriculation}</immatriculation>
                <marque>${car.marque}</marque>
                <proprietaire>${car.proprietaire}</proprietaire>
            """
        }

             return writer.toString()


    }


}