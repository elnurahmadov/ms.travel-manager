package az.cybernet.managingtraveltours.mapper;

import az.cybernet.managingtraveltours.dao.entity.PassportEntity;
import az.cybernet.managingtraveltours.model.dto.PassportDto;

public enum PassportMapper {
    PASSPORT_MAPPER;

    public PassportEntity buildPassportEntity(PassportDto passport) {
        return PassportEntity.builder()
                .passportNumber(passport.getPassportNumber())
                .country(passport.getCountry())
                .expiryDate(passport.getExpiryDate())
                .issueDate(passport.getIssueDate())
                .build();
    }
}