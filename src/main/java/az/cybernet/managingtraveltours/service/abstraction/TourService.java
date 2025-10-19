package az.cybernet.managingtraveltours.service.abstraction;

import az.cybernet.managingtraveltours.model.criteria.PageCriteria;
import az.cybernet.managingtraveltours.model.request.AddTravelerRequest;
import az.cybernet.managingtraveltours.model.request.CreateTourRequest;
import az.cybernet.managingtraveltours.model.response.PageableResponse;
import az.cybernet.managingtraveltours.model.response.TourDetailsResponse;
import az.cybernet.managingtraveltours.model.response.TourResponse;

public interface TourService {
    void createTour(CreateTourRequest tourRequest);

    PageableResponse<TourResponse> getTours(PageCriteria pageCriteria);

    TourDetailsResponse getTour(Long id);

    void addTraveler(Long id, AddTravelerRequest travelerRequest);
}
