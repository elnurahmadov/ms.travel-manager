package az.cybernet.managingtraveltours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "travelers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Traveler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(mappedBy = "travelers")
    private List<Tour> tours;
}
