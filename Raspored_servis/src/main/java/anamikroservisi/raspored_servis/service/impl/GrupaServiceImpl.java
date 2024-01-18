package anamikroservisi.raspored_servis.service.impl;

import anamikroservisi.raspored_servis.dto.GrupaDto;
import anamikroservisi.raspored_servis.exception.NotFoundException;
import anamikroservisi.raspored_servis.mapper.GrupaMapper;
import anamikroservisi.raspored_servis.model.Grupa;
import anamikroservisi.raspored_servis.repository.GrupaRepository;
import anamikroservisi.raspored_servis.service.GrupaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GrupaServiceImpl implements GrupaService {

    private GrupaMapper grupaMapper;
    private GrupaRepository grupaRepository;

    public GrupaServiceImpl(GrupaMapper grupaMapper, GrupaRepository grupaRepository) {
        this.grupaMapper = grupaMapper;
        this.grupaRepository = grupaRepository;
    }

    @Override
    public GrupaDto addGrupa(GrupaDto grupaDto) {
        Grupa grupa =  grupaMapper.grupaDtoToGrupa(grupaDto);
        grupaRepository.save(grupa);
        return grupaMapper.grupaToGrupaDto(grupa);
    }

    @Override
    public GrupaDto getGrupaByOznaka(String oznaka) {
        if (grupaRepository.findByOznaka(oznaka).isPresent()){
            Grupa grupa = grupaRepository.findByOznaka(oznaka).get();
            return grupaMapper.grupaToGrupaDto(grupa);
        }else{
            throw new NotFoundException(String.format("Grupa sa oznakom : %s nije pronadjena", oznaka));
        }
    }
}
