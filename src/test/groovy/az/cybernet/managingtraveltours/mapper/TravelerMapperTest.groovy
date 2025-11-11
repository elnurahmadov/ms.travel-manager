package az.cybernet.managingtraveltours.mapper

import az.cybernet.managingtraveltours.dao.entity.TravelerEntity
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

import static az.cybernet.managingtraveltours.mapper.TravelerMapper.TRAVELER_MAPPER

class TravelerMapperTest extends Specification {
    EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    def "TestToTravelerDtoList"() {
        given:
        def travelerEntity = random.nextObject(TravelerEntity)

        when:
        def actual = TRAVELER_MAPPER.toTravelerDtoList(Set.of(travelerEntity))

        then:
        actual[0].email == travelerEntity.email
        actual[0].lastName == travelerEntity.lastName
        actual[0].firstName == travelerEntity.firstName
    }
}
