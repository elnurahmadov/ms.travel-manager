package az.cybernet.managingtraveltours.dao.repository;

import az.cybernet.managingtraveltours.dao.entity.TravelerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepository extends JpaRepository<TravelerEntity, Long> {
}
