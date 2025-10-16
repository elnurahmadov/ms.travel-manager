package az.cybernet.managingtraveltours.mapper;

import az.cybernet.managingtraveltours.dao.entity.GuideEntity;
import az.cybernet.managingtraveltours.dao.entity.PassportEntity;
import az.cybernet.managingtraveltours.model.request.PassportRequest;

import java.util.Date;

public enum PassportMapper {
    PASSPORT_MAPPER;

    public PassportEntity buildEntity(PassportRequest request, GuideEntity guideEntity) {
        return PassportEntity.builder()
                .guideEntity(guideEntity)
                .passportNumber(request.getPassportNumber())
                .issueDate(request.getIssueDate())
                .expiryDate(request.getExpiryDate())
                .country(request.getCountry())
                .createdAt(new Date())
                .build();
    }
}
