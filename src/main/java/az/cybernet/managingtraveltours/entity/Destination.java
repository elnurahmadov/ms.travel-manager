package az.cybernet.managingtraveltours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "destinations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String description;
    private Date visitDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;
}
