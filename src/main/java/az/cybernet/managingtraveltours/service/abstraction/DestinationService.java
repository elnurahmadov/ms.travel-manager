package az.cybernet.managingtraveltours.service.abstraction;

import az.cybernet.managingtraveltours.model.request.DestinationRequest;

public interface DestinationService {
    void addDestination(DestinationRequest request);
}
