package anamikroservisi.raspored_servis.mapper;

import anamikroservisi.raspored_servis.dto.UcionicaDto;
import anamikroservisi.raspored_servis.model.Ucionica;
import org.springframework.stereotype.Component;

@Component
public class UcionicaMapper {

    public Ucionica ucionicaDtoToUcionica(UcionicaDto ucionicaDto) {
        Ucionica ucionica = new Ucionica();
        ucionica.setOznaka(ucionicaDto.getOznaka());
        ucionica.setPrisustvoRacunara(ucionicaDto.getPrisustvoRacunara());
        ucionica.setBrojMesta(ucionicaDto.getBrojMesta());
        return ucionica;
    }

    public UcionicaDto ucionicaToUcionicaDto(Ucionica ucionica) {
        UcionicaDto ucionicaDto = new UcionicaDto();
        ucionicaDto.setOznaka(ucionica.getOznaka());
        ucionicaDto.setPrisustvoRacunara(ucionica.getPrisustvoRacunara());
        ucionicaDto.setBrojMesta(ucionica.getBrojMesta());
        return ucionicaDto;
    }
}
