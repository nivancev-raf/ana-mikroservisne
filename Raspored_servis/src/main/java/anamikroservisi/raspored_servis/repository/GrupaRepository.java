package anamikroservisi.raspored_servis.repository;


import anamikroservisi.raspored_servis.model.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Long> {
    Optional<Grupa> findByOznaka(String oznaka);
}
