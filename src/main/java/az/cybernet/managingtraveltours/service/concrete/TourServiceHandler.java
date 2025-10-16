package az.cybernet.managingtraveltours.service.concrete;

import az.cybernet.managingtraveltours.dao.repository.TourRepository;
import az.cybernet.managingtraveltours.model.request.TourRequest;
import az.cybernet.managingtraveltours.service.abstraction.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static az.cybernet.managingtraveltours.mapper.TourMapper.TOUR_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourServiceHandler implements TourService {
    private final TourRepository tourRepository;

    @Override
    public void addTour(TourRequest request) {
        log.info("ActionLog.addTour.start");
        tourRepository.save(TOUR_MAPPER.buildEntity(request));
        log.info("ActionLog.addTour.end");
    }
}
