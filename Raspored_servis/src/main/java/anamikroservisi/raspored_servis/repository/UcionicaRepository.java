package anamikroservisi.raspored_servis.repository;


import anamikroservisi.raspored_servis.model.Ucionica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UcionicaRepository extends JpaRepository<Ucionica, Long> {
    Optional<Ucionica> findByOznaka(String oznaka);
}
