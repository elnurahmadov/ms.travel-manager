package az.cybernet.managingtraveltours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "guides")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    @OneToOne(mappedBy = "guide", cascade = CascadeType.ALL)
    private Passport passport;

    @ManyToMany(mappedBy = "guides")
    private List<Tour> tours;
}

