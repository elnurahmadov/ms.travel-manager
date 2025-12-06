package az.cybernet.managingtraveltours.service;

import az.cybernet.managingtraveltours.aspect.LogExecutionTime;
import az.cybernet.managingtraveltours.dao.repository.TourRepository;
import az.cybernet.managingtraveltours.model.criteria.PageCriteria;
import az.cybernet.managingtraveltours.model.request.AddTravelerRequest;
import az.cybernet.managingtraveltours.model.request.CreateTourRequest;
import az.cybernet.managingtraveltours.model.response.PageableResponse;
import az.cybernet.managingtraveltours.model.response.TourDetailsResponse;
import az.cybernet.managingtraveltours.model.response.TourResponse;
import az.cybernet.managingtraveltours.service.abstraction.TourHistoryService;
import az.cybernet.managingtraveltours.service.abstraction.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static az.cybernet.managingtraveltours.mapper.PageableMapper.PAGEABLE_MAPPER;
import static az.cybernet.managingtraveltours.mapper.TourMapper.TOUR_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourServiceHandler implements TourService {
    private final TourRepository tourRepository;
    private final TourHistoryService tourHistoryService;

    @Override
    public void createTour(CreateTourRequest tourRequest) {
        log.info("ActionLog.createTour.start - {}", tourRequest);
        var tour = TOUR_MAPPER.buildTourEntity(tourRequest);
        tourRepository.save(tour);
        log.info("ActionLog.createTour.end");
    }

    @Override
    public PageableResponse<TourResponse> getTours(PageCriteria pageCriteria) {
        log.info("ActionLog.getTours.start - {}", pageCriteria);
        var tours = tourRepository.findAll(PAGEABLE_MAPPER.toPageable(pageCriteria));
        var pageableTourResponse = PAGEABLE_MAPPER.toPageableResponse(tours, TOUR_MAPPER::toTourResponse);
        log.info("ActionLog.getTours.end - {}", pageableTourResponse);
        return pageableTourResponse;
    }

    @Override
    public TourDetailsResponse getTour(Long id) {
        log.info("ActionLog.getTour.start - {}", id);
        var tour = tourRepository.findWithDestinationsAndTravelersById(id).orElseThrow();
        var tourResponse = TOUR_MAPPER.toTourDetailsResponse(tour);
        log.info("ActionLog.getTour.end - {}", tourResponse);
        return tourResponse;
    }

    @Override
    @LogExecutionTime
    public void addTraveler(Long id, AddTravelerRequest travelerRequest) {
        log.info("ActionLog.addTraveler.start - {} & {}", id, travelerRequest);
        var tour = tourHistoryService.findById(id);
        TOUR_MAPPER.addNewTraveler(tour, travelerRequest);
        tourRepository.save(tour);
        log.info("ActionLog.addTraveler.end");
    }
}
