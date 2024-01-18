package anamikroservisi.raspored_servis.mapper;

import anamikroservisi.raspored_servis.dto.NastavnikDto;
import anamikroservisi.raspored_servis.model.Nastavnik;
import org.springframework.stereotype.Component;

@Component
public class NastavnikMapper {

    // nastavnikDtoToNastavnik
    public Nastavnik nastavnikDtoToNastavnik(NastavnikDto nastavnikDto) {
        Nastavnik nastavnik = new Nastavnik();
        nastavnik.setIme(nastavnikDto.getIme());
        nastavnik.setPrezime(nastavnikDto.getPrezime());
        nastavnik.setZvanje(nastavnikDto.getZvanje());
        nastavnik.setImejlAdresa(nastavnikDto.getEmail());
        return nastavnik;

    }

    // nastavnikToNastavnikDto
    public NastavnikDto nastavnikToNastavnikDto(Nastavnik nastavnik) {
        NastavnikDto nastavnikDto = new NastavnikDto();
        nastavnikDto.setIme(nastavnik.getIme());
        nastavnikDto.setPrezime(nastavnik.getPrezime());
        nastavnikDto.setZvanje(nastavnik.getZvanje());
        nastavnikDto.setEmail(nastavnik.getImejlAdresa());
        return nastavnikDto;
    }

}
