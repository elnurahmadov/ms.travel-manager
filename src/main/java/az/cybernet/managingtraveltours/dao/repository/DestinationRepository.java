package az.cybernet.managingtraveltours.dao.repository;

import az.cybernet.managingtraveltours.dao.entity.DestinationEntity;
import org.springframework.data.repository.CrudRepository;

public interface DestinationRepository extends CrudRepository<DestinationEntity, Long> {
}