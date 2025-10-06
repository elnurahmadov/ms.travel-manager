package az.cybernet.managingtraveltours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tours")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Destination> destinations;

    @ManyToMany
    @JoinTable(
            name = "tour_guides",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "guide_id")
    )
    private List<Guide> guides;

    @ManyToMany
    @JoinTable(
            name = "tour_travelers",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "traveler_id")
    )
    private List<Traveler> travelers;
}
