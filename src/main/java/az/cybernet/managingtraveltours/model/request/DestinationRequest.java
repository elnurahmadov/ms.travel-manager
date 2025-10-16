package az.cybernet.managingtraveltours.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationRequest {
    private String location;
    private String description;
    private Date visitDate;
    private Long tourId;
}
