package az.cybernet.managingtraveltours.repository;

import az.cybernet.managingtraveltours.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
