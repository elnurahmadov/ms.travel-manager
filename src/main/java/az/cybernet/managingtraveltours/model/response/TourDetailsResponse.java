package az.cybernet.managingtraveltours.model.response;

import az.cybernet.managingtraveltours.model.dto.DestinationDto;
import az.cybernet.managingtraveltours.model.dto.TravelerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourDetailsResponse {
    private String name;
    private BigDecimal price;
    private String description;
    private LocalDate endDate;
    private LocalDate startDate;
    private List<TravelerDto> travelers;
    private List<DestinationDto> destinations;
}