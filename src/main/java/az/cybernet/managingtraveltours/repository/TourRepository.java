package az.cybernet.managingtraveltours.repository;

import az.cybernet.managingtraveltours.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
