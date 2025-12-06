package az.cybernet.managingtraveltours.service.abstraction;

import az.cybernet.managingtraveltours.dao.entity.TourEntity;

public interface TourHistoryService {
    TourEntity findById(Long id);
}