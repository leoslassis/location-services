package br.com.challenge.locationservices.repository;

import br.com.challenge.locationservices.repository.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationJpaRepository extends JpaRepository<LocationEntity, Long> {

   Optional<LocationEntity> findByPostalCode(String postalCode);
}
