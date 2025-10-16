package az.cybernet.managingtraveltours.mapper;

import az.cybernet.managingtraveltours.dao.entity.TourEntity;
import az.cybernet.managingtraveltours.model.request.TourRequest;

import java.util.Date;

public enum TourMapper {
    TOUR_MAPPER;

    public TourEntity buildEntity(TourRequest request) {
        return TourEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .createdAt(new Date())
                .build();
    }
}
