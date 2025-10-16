package az.cybernet.managingtraveltours.mapper;

import az.cybernet.managingtraveltours.dao.entity.GuideEntity;
import az.cybernet.managingtraveltours.model.request.GuideRequest;

import java.util.Date;

public enum GuideMapper {
    GUIDE_MAPPER;

    public GuideEntity buildEntity(GuideRequest request) {
        return GuideEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(new Date())
                .build();
    }
}
