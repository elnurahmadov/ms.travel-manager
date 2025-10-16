package az.cybernet.managingtraveltours.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;
}
