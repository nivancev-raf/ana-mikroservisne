package anamikroservisi.raspored_servis.repository;


import anamikroservisi.raspored_servis.model.Nastavnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NastavnikRepository extends JpaRepository<Nastavnik, Long> {
    Optional<Nastavnik> findByImeAndPrezime(String ime, String prezime);
}
