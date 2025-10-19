package az.cybernet.managingtraveltours.service.concrete;

import az.cybernet.managingtraveltours.dao.entity.GuideEntity;
import az.cybernet.managingtraveltours.dao.entity.TourEntity;
import az.cybernet.managingtraveltours.dao.repository.GuideRepository;
import az.cybernet.managingtraveltours.exception.ConflictException;
import az.cybernet.managingtraveltours.exception.NotFoundException;
import az.cybernet.managingtraveltours.model.criteria.PageCriteria;
import az.cybernet.managingtraveltours.model.request.CreateGuideRequest;
import az.cybernet.managingtraveltours.model.response.GuideResponse;
import az.cybernet.managingtraveltours.model.response.PageableResponse;
import az.cybernet.managingtraveltours.service.abstraction.GuideService;
import az.cybernet.managingtraveltours.service.abstraction.TourHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static az.cybernet.managingtraveltours.exception.ErrorMessage.GUIDE_NOT_FOUND;
import static az.cybernet.managingtraveltours.exception.ErrorMessage.TOUR_DATE_CONFLICT;
import static az.cybernet.managingtraveltours.mapper.GuideMapper.GUIDE_MAPPER;
import static az.cybernet.managingtraveltours.mapper.PageableMapper.PAGEABLE_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuideServiceHandler implements GuideService {
    private final GuideRepository guideRepository;
    private final TourHistoryService tourHistoryService;

    @Override
    public void createGuide(CreateGuideRequest guideRequest) {
        log.info("ActionLog.createGuide.start - {}", guideRequest);
        var guide = GUIDE_MAPPER.buildGuideEntity(guideRequest);
        guideRepository.save(guide);
        log.info("ActionLog.createGuide.end");
    }

    @Override
    public void assignTour(Long id, Long tourId) {
        log.info("ActionLog.assignTour.start - {} & {}", id, tourId);
        var tour = tourHistoryService.findById(tourId);
        var guide = guideRepository.findWithToursById(id)
                .orElseThrow(() -> new NotFoundException(GUIDE_NOT_FOUND, id));

        ensureGuideAvailability(guide, tour);

        GUIDE_MAPPER.addNewTour(guide, tour);
        guideRepository.save(guide);
        log.info("ActionLog.assignTour.end");
    }

    @Override
    public PageableResponse<GuideResponse> getGuides(PageCriteria pageCriteria) {
        log.info("ActionLog.getGuides.start - {}", pageCriteria);
        var guides = guideRepository.findAll(PAGEABLE_MAPPER.toPageable(pageCriteria));
        var pageableGuideResponse = PAGEABLE_MAPPER.toPageableResponse(guides, GUIDE_MAPPER::toGuideResponse);
        log.info("ActionLog.getGuides.end - {}", pageableGuideResponse);
        return pageableGuideResponse;
    }

    private void ensureGuideAvailability(GuideEntity guide, TourEntity tour) {
        var startDate = tour.getStartDate();
        var endDate = tour.getEndDate();
        var dateConflict = guide.getTours().stream()
                .anyMatch(it -> startDate.isBefore(it.getEndDate()) && endDate.isAfter(it.getStartDate()));

        if (dateConflict) {
            throw new ConflictException(TOUR_DATE_CONFLICT, startDate, endDate);
        }
    }
}