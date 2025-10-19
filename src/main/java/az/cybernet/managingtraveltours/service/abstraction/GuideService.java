package az.cybernet.managingtraveltours.service.abstraction;

import az.cybernet.managingtraveltours.model.criteria.PageCriteria;
import az.cybernet.managingtraveltours.model.request.CreateGuideRequest;
import az.cybernet.managingtraveltours.model.response.GuideResponse;
import az.cybernet.managingtraveltours.model.response.PageableResponse;

public interface GuideService {
    void createGuide(CreateGuideRequest guideRequest);

    void assignTour(Long id, Long tourId);

    PageableResponse<GuideResponse> getGuides(PageCriteria pageCriteria);
}
