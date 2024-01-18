package anamikroservisi.raspored_servis.service;

import anamikroservisi.raspored_servis.dto.UcionicaDto;

public interface UcionicaService {

    UcionicaDto addUcionica(UcionicaDto ucionicaDto);
    UcionicaDto getUcionicaByOznaka(String oznaka);
}
