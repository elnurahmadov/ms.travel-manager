package az.cybernet.managingtraveltours.service.concrete;

import az.cybernet.managingtraveltours.dao.entity.TourEntity;
import az.cybernet.managingtraveltours.dao.repository.DestinationRepository;
import az.cybernet.managingtraveltours.dao.repository.TourRepository;
import az.cybernet.managingtraveltours.model.request.DestinationRequest;
import az.cybernet.managingtraveltours.service.abstraction.DestinationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static az.cybernet.managingtraveltours.mapper.DestinationMapper.DESTINATION_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class DestinationServiceHandler implements DestinationService {
    private final DestinationRepository destinationRepository;
    private final TourRepository  tourRepository;

    @Override
    public void addDestination(DestinationRequest request) {
        log.info("ActionLog.addDestination.start");
        TourEntity tourEntity = tourRepository.getById(request.getTourId());
        destinationRepository.save(DESTINATION_MAPPER.buildEntity(request, tourEntity));
        log.info("ActionLog.addDestination.end");
    }
}
