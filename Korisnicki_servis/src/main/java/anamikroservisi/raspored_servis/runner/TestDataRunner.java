package anamikroservisi.raspored_servis.runner;

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

    @Override
    public void run(String... args) throws Exception {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Generišete ključ
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded()); // Dobićete Base64 kodiran ključ
        System.out.println("JWT Secret: " + base64Key);

    }
}
