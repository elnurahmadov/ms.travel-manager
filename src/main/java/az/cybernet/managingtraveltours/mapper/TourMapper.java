package az.cybernet.managingtraveltours.mapper;

import az.cybernet.managingtraveltours.dao.entity.TourEntity;
import az.cybernet.managingtraveltours.model.request.AddTravelerRequest;
import az.cybernet.managingtraveltours.model.request.CreateTourRequest;
import az.cybernet.managingtraveltours.model.response.TourDetailsResponse;
import az.cybernet.managingtraveltours.model.response.TourResponse;

import java.util.List;
import java.util.Set;

import static az.cybernet.managingtraveltours.mapper.DestinationMapper.DESTINATION_MAPPER;
import static az.cybernet.managingtraveltours.mapper.TravelerMapper.TRAVELER_MAPPER;

public enum TourMapper {
    TOUR_MAPPER;

    public TourEntity buildTourEntity(CreateTourRequest tourRequest) {
        var tourEntity = TourEntity.builder()
                .name(tourRequest.getName())
                .price(tourRequest.getPrice())
                .endDate(tourRequest.getEndDate())
                .startDate(tourRequest.getStartDate())
                .description(tourRequest.getDescription())
                .build();
        var destinations = DESTINATION_MAPPER.buildDestinations(tourRequest.getDestinations(), tourEntity);
        tourEntity.setDestinations(destinations);
        return tourEntity;
    }

    public TourResponse toTourResponse(TourEntity tourEntity) {
        return TourResponse.builder()
                .id(tourEntity.getId())
                .name(tourEntity.getName())
                .price(tourEntity.getPrice())
                .build();
    }

    public TourDetailsResponse toTourDetailsResponse(TourEntity tourEntity) {
        return TourDetailsResponse.builder()
                .name(tourEntity.getName())
                .price(tourEntity.getPrice())
                .description(tourEntity.getDescription())
                .endDate(tourEntity.getEndDate())
                .startDate(tourEntity.getStartDate())
                .travelers(TRAVELER_MAPPER.toTravelerDtoList(tourEntity.getTravelers()))
                .destinations(DESTINATION_MAPPER.toDestinationList(tourEntity.getDestinations()))
                .build();
    }

    public void addNewTraveler(TourEntity tour, AddTravelerRequest travelerRequest) {
        var traveler = TRAVELER_MAPPER.buildTravelerEntity(travelerRequest);
        tour.setTravelers(Set.of(traveler));
        traveler.setTours(List.of(tour));
    }
}