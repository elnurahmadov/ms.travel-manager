package az.cybernet.managingtraveltours.service.abstraction;

import az.cybernet.managingtraveltours.model.request.TourRequest;

public interface TourService {
    void addTour(TourRequest request);
}
