package az.cybernet.managingtraveltours.service.abstraction;

import az.cybernet.managingtraveltours.model.request.PassportRequest;

public interface PassportService {
    void savePassport(PassportRequest request);
}
