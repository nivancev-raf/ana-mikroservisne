package anamikroservisi.korisnicki_servis.runner;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

//    private AdminRepository adminRepository;
//    private RoleRepository roleRepository;
//
//    public TestDataRunner(AdminRepository adminRepository, RoleRepository roleRepository) {
//        this.adminRepository = adminRepository;
//        this.roleRepository = roleRepository;
//    }

    @Override
    public void run(String... args) throws Exception {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Generišete ključ
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded()); // Dobićete Base64 kodiran ključ
        System.out.println("JWT Secret: " + base64Key);

//        User user = new User();
//        // insert admin
//        user.setUsername("admin");
//        user.setPassword("admin"); // Šifra treba da bude enkriptovana
//        user.setEmail("softverskekomponente@raf.rs");
//        user.setFirstName("Petar");
//        user.setLastName("Petrovic");
//        user.setDateOfBirth("1970-01-01");
//        user.setRole("ROLE_ADMIN");
//        Admin admin = new Admin();
//        admin.setUser(user); // Setujemo ugnježdenog korisnika
//
//        // Dodavanje ostalih potrebnih polja za Admina ako ih ima
//        // admin.setOtherField("OtherValue");
//
//        adminRepository.save(admin);
//
//        // manager
//        User user2 = new User();
//        user2.setUsername("manager");
//        user2.setPassword("manager"); // Šifra treba da bude enkriptovana
//        user2.setEmail("manager@gmail.com");
//        user2.setFirstName("Marko");
//        user2.setLastName("Markovic");
//        user2.setDateOfBirth("1970-01-01");
//        user2.setRole("ROLE_MANAGER");
//        Manager manager = new Manager();
//        manager.setDateOfHiring("2020-01-01");
//        manager.setGymName("Gym1");
//        manager.setUser(user2); // Setujemo ugnježdenog korisnika
//        roleRepository.save(manager);
//
//        // manager 2
//        User user3 = new User();
//        user3.setUsername("manager2");
//        user3.setPassword("manager2"); // Šifra treba da bude enkriptovana
//        user3.setEmail("manager2@gmail.com");
//        user3.setFirstName("Nikola");
//        user3.setLastName("Nikolic");
//        user3.setDateOfBirth("1970-01-01");
//        user3.setRole("ROLE_MANAGER");
//        Manager manager2 = new Manager();
//        manager2.setDateOfHiring("2020-01-01");
//        manager2.setGymName("Gym2");
//        manager2.setUser(user3); // Setujemo ugnježdenog korisnika
//        roleRepository.save(manager2);
//
//        // manager 3
//        User user4 = new User();
//        user4.setUsername("manager3");
//        user4.setPassword("manager3"); // Šifra treba da bude enkriptovana
//        user4.setEmail("manager3@gmail.com");
//        user4.setFirstName("Milan");
//        user4.setLastName("Milanovic");
//        user4.setDateOfBirth("1970-01-01");
//        user4.setRole("ROLE_MANAGER");
//        Manager manager3 = new Manager();
//        manager3.setDateOfHiring("2020-01-01");
//        manager3.setGymName("Gym3");
//        manager3.setUser(user4); // Setujemo ugnježdenog korisnika
//        roleRepository.save(manager3);



    }
}
