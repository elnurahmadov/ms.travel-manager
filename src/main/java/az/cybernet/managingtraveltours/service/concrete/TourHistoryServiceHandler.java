package az.cybernet.managingtraveltours.service.concrete;

import az.cybernet.managingtraveltours.dao.entity.TourEntity;
import az.cybernet.managingtraveltours.dao.repository.TourRepository;
import az.cybernet.managingtraveltours.exception.NotFoundException;
import az.cybernet.managingtraveltours.service.abstraction.TourHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.cybernet.managingtraveltours.exception.ErrorMessage.TOUR_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TourHistoryServiceHandler implements TourHistoryService {
    private final TourRepository tourRepository;

    @Override
    public TourEntity findById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND, id));
    }
}