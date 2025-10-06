package az.cybernet.managingtraveltours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "passports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private Date issueDate;
    private Date expiryDate;
    private String country;

    @OneToOne
    @JoinColumn(name = "guide_id", unique = true)
    private Guide guide;
}
