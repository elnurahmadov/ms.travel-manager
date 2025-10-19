package az.cybernet.managingtraveltours.dao.repository;

import az.cybernet.managingtraveltours.dao.entity.TravelerEntity;
import org.springframework.data.repository.CrudRepository;

public interface TravelerRepository extends CrudRepository<TravelerEntity, Long> {
}