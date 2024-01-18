package anamikroservisi.raspored_servis.service;

import anamikroservisi.raspored_servis.dto.GrupaDto;

public interface GrupaService {

    GrupaDto addGrupa(GrupaDto grupaDto);

    GrupaDto getGrupaByOznaka(String oznaka);

}
