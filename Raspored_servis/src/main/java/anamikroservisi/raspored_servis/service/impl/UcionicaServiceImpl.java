package anamikroservisi.raspored_servis.service.impl;

import anamikroservisi.raspored_servis.dto.UcionicaDto;
import anamikroservisi.raspored_servis.exception.NotFoundException;
import anamikroservisi.raspored_servis.mapper.UcionicaMapper;
import anamikroservisi.raspored_servis.model.Ucionica;
import anamikroservisi.raspored_servis.repository.UcionicaRepository;
import anamikroservisi.raspored_servis.service.UcionicaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UcionicaServiceImpl implements UcionicaService{

    private UcionicaMapper ucionicaMapper;
    private UcionicaRepository ucionicaRepository;

    public UcionicaServiceImpl(UcionicaMapper ucionicaMapper, UcionicaRepository ucionicaRepository) {
        this.ucionicaMapper = ucionicaMapper;
        this.ucionicaRepository = ucionicaRepository;
    }

    @Override
    public UcionicaDto addUcionica(UcionicaDto ucionicaDto) {
        Ucionica ucionica = ucionicaMapper.ucionicaDtoToUcionica(ucionicaDto);
        ucionicaRepository.save(ucionica);
        return ucionicaDto;
    }

    @Override
    public UcionicaDto getUcionicaByOznaka(String oznaka) {
        if (ucionicaRepository.findByOznaka(oznaka).isPresent()){
            Ucionica ucionica = ucionicaRepository.findByOznaka(oznaka).get();
            return ucionicaMapper.ucionicaToUcionicaDto(ucionica);
        }else{
            throw new NotFoundException(String.format("Ucionica sa oznakom : %s nije pronadjena", oznaka));
        }
    }
}
