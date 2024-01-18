package anamikroservisi.raspored_servis.repository;


import anamikroservisi.raspored_servis.model.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Long> {
    Optional<Predmet> findByNaziv(String naziv);
}
