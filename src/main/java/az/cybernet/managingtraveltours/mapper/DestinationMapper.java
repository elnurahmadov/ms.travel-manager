package az.cybernet.managingtraveltours.mapper;

import az.cybernet.managingtraveltours.dao.entity.DestinationEntity;
import az.cybernet.managingtraveltours.dao.entity.TourEntity;
import az.cybernet.managingtraveltours.model.request.DestinationRequest;

import java.util.Date;

public enum DestinationMapper {
    DESTINATION_MAPPER;

    public DestinationEntity buildEntity(DestinationRequest request, TourEntity tourEntity) {
        return DestinationEntity.builder()
                .location(request.getLocation())
                .description(request.getDescription())
                .visitDate(request.getVisitDate())
                .tourEntity(tourEntity)
                .createdAt(new Date())
                .build();
    }
}
