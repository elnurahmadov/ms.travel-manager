package az.cybernet.managingtraveltours.mapper;

import az.cybernet.managingtraveltours.dao.entity.GuideEntity;
import az.cybernet.managingtraveltours.dao.entity.TourEntity;
import az.cybernet.managingtraveltours.model.request.CreateGuideRequest;
import az.cybernet.managingtraveltours.model.response.GuideResponse;

import static az.cybernet.managingtraveltours.mapper.PassportMapper.PASSPORT_MAPPER;

public enum GuideMapper {
    GUIDE_MAPPER;

    public GuideEntity buildGuideEntity(CreateGuideRequest guideRequest) {
        var passport = PASSPORT_MAPPER.buildPassportEntity(guideRequest.getPassport());
        var guide = GuideEntity.builder()
                .name(guideRequest.getName())
                .email(guideRequest.getEmail())
                .phoneNumber(guideRequest.getPhoneNumber())
                .build();
        guide.setPassport(passport);
        passport.setGuide(guide);
        return guide;
    }

    public GuideResponse toGuideResponse(GuideEntity guideEntity) {
        return GuideResponse.builder()
                .id(guideEntity.getId())
                .name(guideEntity.getName())
                .email(guideEntity.getEmail())
                .phoneNumber(guideEntity.getPhoneNumber())
                .build();
    }

    public void addNewTour(GuideEntity guide, TourEntity tour) {
        guide.getTours().add(tour);
    }
}