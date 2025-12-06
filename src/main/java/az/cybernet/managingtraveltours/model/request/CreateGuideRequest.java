package az.cybernet.managingtraveltours.model.request;

import az.cybernet.managingtraveltours.model.dto.PassportDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGuideRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private PassportDto passport;
}