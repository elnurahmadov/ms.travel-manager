package az.cybernet.managingtraveltours.dao.repository;

import az.cybernet.managingtraveltours.dao.entity.TourEntity;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<TourEntity, Long> {
    TourEntity getById(Long id);
}
