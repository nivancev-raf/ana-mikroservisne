package anamikroservisi.raspored_servis.service;

import anamikroservisi.raspored_servis.dto.NastavnikDto;

public interface NastavnikService {

    NastavnikDto addNastavnik(NastavnikDto nastavnikDto);
    NastavnikDto getNastavnikByNameAndSurname(String ime, String prezime);
}
