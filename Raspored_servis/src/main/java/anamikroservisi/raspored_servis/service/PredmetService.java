package anamikroservisi.raspored_servis.service;

import anamikroservisi.raspored_servis.dto.PredmetDto;

public interface PredmetService {

    PredmetDto addPredmet(PredmetDto predmetDto);
    PredmetDto getPredmetByNaziv(String naziv);
}
