package anamikroservisi.raspored_servis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pocetak;
    private String kraj;
    private String danUNedelji;
    private String tipNastave;

    @ManyToOne(cascade = CascadeType.ALL) // (cascade = CascadeType.ALL) znaci da ako je termin obrisan, da se brisu i grupe koje su vezane za taj termin
    private Grupa grupa;
    // vise grupa moze da ima isti termin, ali ne i isti termin za vise grupa

}