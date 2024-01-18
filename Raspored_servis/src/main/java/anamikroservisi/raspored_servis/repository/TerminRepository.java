package anamikroservisi.raspored_servis.repository;


import anamikroservisi.raspored_servis.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {
    List<Termin> findByDanUNedelji(String danUNedelji);

    // Add other search methods as needed
}
