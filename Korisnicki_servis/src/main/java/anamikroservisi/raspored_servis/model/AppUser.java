package anamikroservisi.raspored_servis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class AppUser {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    private Long id;
    private String username;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER) // (fetch = FetchType.EAGER) - da bi se odmah ucitale uloge
    private List<Role> roles;
    // jedan korisnik može imati više uloga, a jedna uloga može pripadati više korisnicima


}


