package anamikroservisi.raspored_servis.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TerminDto {
    private String pocetak;
    private String kraj;
    private String danUNedelji;
    private String tipNastave; // e.g., "predavanje", "vežbe", "demonstracije"
    private GrupaDto grupa;

}
