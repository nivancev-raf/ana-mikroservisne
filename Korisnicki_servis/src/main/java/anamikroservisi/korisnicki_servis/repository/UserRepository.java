package anamikroservisi.korisnicki_servis.repository;

import anamikroservisi.korisnicki_servis.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    Optional<AppUser> findByUsername(String username);

    Optional<AppUser> findById (Long id);


}