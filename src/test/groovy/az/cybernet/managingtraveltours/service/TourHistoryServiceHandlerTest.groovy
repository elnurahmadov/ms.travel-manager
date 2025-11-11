package az.cybernet.managingtraveltours.service

import az.cybernet.managingtraveltours.dao.repository.TourRepository
import az.cybernet.managingtraveltours.service.abstraction.TourHistoryService
import spock.lang.Specification

class TourHistoryServiceHandlerTest extends Specification {
    TourHistoryService tourHistoryService
    TourRepository tourRepository

    def setup() {
        tourRepository = Mock()
        tourHistoryService = new TourHistoryServiceHandler(tourRepository)
    }
}
