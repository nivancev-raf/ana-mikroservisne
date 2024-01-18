package anamikroservisi.raspored_servis.mapper;

import anamikroservisi.raspored_servis.dto.GrupaDto;
import anamikroservisi.raspored_servis.model.Grupa;
import org.springframework.stereotype.Component;

@Component
public class GrupaMapper {

    public Grupa grupaDtoToGrupa(GrupaDto grupaDto) {
        Grupa grupa = new Grupa();
        grupa.setOznaka(grupaDto.getOznaka());
        return grupa;
    }

    public GrupaDto grupaToGrupaDto(Grupa grupa) {
        GrupaDto grupaDto = new GrupaDto();
        grupaDto.setOznaka(grupa.getOznaka());
        return grupaDto;
    }
}
