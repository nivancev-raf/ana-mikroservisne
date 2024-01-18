package anamikroservisi.raspored_servis.mapper;

import anamikroservisi.raspored_servis.dto.PredmetDto;
import anamikroservisi.raspored_servis.model.Predmet;
import org.springframework.stereotype.Component;

@Component
public class PredmetMapper {

    public Predmet predmetDtoToPredmet(PredmetDto predmetDto) {
        Predmet predmet = new Predmet();
        predmet.setNaziv(predmetDto.getNaziv());
        predmet.setStudijskiProgram(predmetDto.getStudijskiProgram());
        predmet.setBrojESPB(predmetDto.getBrojESPB());
        return predmet;
    }

    public PredmetDto predmetToPredmetDto(Predmet predmet) {
        PredmetDto predmetDto = new PredmetDto();
        predmetDto.setNaziv(predmet.getNaziv());
        predmetDto.setStudijskiProgram(predmet.getStudijskiProgram());
        predmetDto.setBrojESPB(predmet.getBrojESPB());
        return predmetDto;
    }
}
