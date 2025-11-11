package az.cybernet.managingtraveltours.mapper

import az.cybernet.managingtraveltours.dao.entity.DestinationEntity
import az.cybernet.managingtraveltours.dao.entity.TourEntity
import az.cybernet.managingtraveltours.dao.entity.TravelerEntity
import az.cybernet.managingtraveltours.model.request.AddTravelerRequest
import az.cybernet.managingtraveltours.model.request.CreateTourRequest
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

import static az.cybernet.managingtraveltours.mapper.TourMapper.TOUR_MAPPER

class TourMapperTest extends Specification {
    EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    def "TestBuildTourEntity"() {
        given:
        def request = random.nextObject(CreateTourRequest)

        when:
        def actual = TOUR_MAPPER.buildTourEntity(request)

        then:
        actual.name == request.name
        actual.price == request.price
        actual.endDate == request.endDate
        actual.startDate == request.startDate
        actual.description == request.description
        actual.guides == null
        actual.travelers == null
        verifyAll(actual.destinations[0]) {
            location == request.destinations[0].location
            description == request.destinations[0].description
            visitDate == request.destinations[0].visitDate
        }
    }

    def "TestToTourResponse"() {
        given:
        def tourEntity = random.nextObject(TourEntity)

        when:
        def actual = TOUR_MAPPER.toTourResponse(tourEntity)

        then:
        actual.id == tourEntity.id
        actual.name == tourEntity.name
        actual.price == tourEntity.price
    }

    def "TestToTourDetailsResponse"() {
        given:
        def tourEntity = random.nextObject(TourEntity)
        def travelerEntity = random.nextObject(TravelerEntity)
        def destinationEntity = random.nextObject(DestinationEntity)

        tourEntity.travelers = Set.of(travelerEntity)
        tourEntity.destinations = [destinationEntity]
        when:
        def actual = TOUR_MAPPER.toTourDetailsResponse(tourEntity)

        then:
        actual.name == tourEntity.name
        actual.price == tourEntity.price
        actual.description == tourEntity.description
        actual.endDate == tourEntity.endDate
        actual.startDate == tourEntity.startDate

        actual.travelers.size() == 1
        verifyAll(actual.travelers[0]) {
            firstName == travelerEntity.firstName
            lastName == travelerEntity.lastName
            email == travelerEntity.email
        }

        actual.destinations.size() == 1
        verifyAll(actual.destinations[0]) {
            location == destinationEntity.location
            description == destinationEntity.description
            visitDate == destinationEntity.visitDate
        }
    }

    def "TestAddNewTraveler"() {
        given:
        def tourEntity = random.nextObject(TourEntity)

        tourEntity.travelers = []
        def travelerRequest = random.nextObject(AddTravelerRequest)

        when:
        TOUR_MAPPER.addNewTraveler(tourEntity, travelerRequest)

        then:
        verifyAll(tourEntity.travelers[0]) {
            firstName == travelerRequest.firstName
            lastName == travelerRequest.lastName
            email == travelerRequest.email
            tours[0] == tourEntity
        }
    }
}
