package anamikroservisi.raspored_servis.service;

import anamikroservisi.raspored_servis.dto.TerminDto;

import java.util.List;

public interface TerminService {
    TerminDto addTermin(TerminDto terminDto);
    void deleteTermin(Long id);
    List<TerminDto> getTerminByDan(String dan);
}
