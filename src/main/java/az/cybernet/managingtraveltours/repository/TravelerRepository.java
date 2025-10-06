package az.cybernet.managingtraveltours.repository;

import az.cybernet.managingtraveltours.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepository extends JpaRepository<Traveler, Long> {
}
