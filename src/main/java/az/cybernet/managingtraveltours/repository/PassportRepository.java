package az.cybernet.managingtraveltours.repository;

import az.cybernet.managingtraveltours.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
}
