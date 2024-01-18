package anamikroservisi.raspored_servis.mapper;

import anamikroservisi.raspored_servis.dto.TerminDto;
import anamikroservisi.raspored_servis.model.Termin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TerminMapper {
    private GrupaMapper grupaMapper;

    public TerminMapper(GrupaMapper grupaMapper) {
        this.grupaMapper = grupaMapper;
    }

    public Termin terminDtoToTermin(TerminDto terminDto) {
        Termin termin = new Termin();
        termin.setPocetak(terminDto.getPocetak());
        termin.setKraj(terminDto.getKraj());
        termin.setDanUNedelji(terminDto.getDanUNedelji());
        termin.setTipNastave(terminDto.getTipNastave());
        termin.setGrupa(grupaMapper.grupaDtoToGrupa(terminDto.getGrupa()));
        return termin;
    }

    public TerminDto terminToTerminDto(Termin termin) {
        TerminDto terminDto = new TerminDto();
        terminDto.setPocetak(termin.getPocetak());
        terminDto.setKraj(termin.getKraj());
        terminDto.setDanUNedelji(termin.getDanUNedelji());
        terminDto.setTipNastave(termin.getTipNastave());
        terminDto.setGrupa(grupaMapper.grupaToGrupaDto(termin.getGrupa()));
        return terminDto;
    }

    // terminiToTerminiDto
    public List<TerminDto> terminiToTerminiDto(List<Termin> termini){
        List<TerminDto> terminiDto = new ArrayList<>();
        for (Termin termin : termini) {
            terminiDto.add(terminToTerminDto(termin));
        }
        return terminiDto;
    }

}
