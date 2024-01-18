package anamikroservisi.raspored_servis.service.impl;

import anamikroservisi.raspored_servis.dto.TerminDto;
import anamikroservisi.raspored_servis.mapper.TerminMapper;
import anamikroservisi.raspored_servis.model.Termin;
import anamikroservisi.raspored_servis.repository.TerminRepository;
import anamikroservisi.raspored_servis.service.TerminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TerminServiceImpl implements TerminService {

    private TerminMapper terminMapper;
    private TerminRepository terminRepository;

    public TerminServiceImpl(TerminMapper terminMapper, TerminRepository terminRepository) {
        this.terminMapper = terminMapper;
        this.terminRepository = terminRepository;
    }

    @Override
    public TerminDto addTermin(TerminDto terminDto) {
        Termin termin = terminMapper.terminDtoToTermin(terminDto);
        terminRepository.save(termin);
        return terminDto;
    }

    @Override
    public void deleteTermin(Long id) {
        Termin termin = terminRepository.findById(id).orElse(null);
        terminRepository.delete(termin);
    }

    @Override
    public List<TerminDto> getTerminByDan(String dan) {
        List<Termin> termini = terminRepository.findByDanUNedelji(dan);
        return terminMapper.terminiToTerminiDto(termini);
    }


}
