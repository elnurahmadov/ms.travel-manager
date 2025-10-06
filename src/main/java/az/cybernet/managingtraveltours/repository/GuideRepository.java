package az.cybernet.managingtraveltours.repository;

import az.cybernet.managingtraveltours.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
}
