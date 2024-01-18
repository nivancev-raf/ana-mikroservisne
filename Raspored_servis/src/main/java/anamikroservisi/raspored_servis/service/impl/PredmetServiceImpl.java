package anamikroservisi.raspored_servis.service.impl;

import anamikroservisi.raspored_servis.dto.PredmetDto;
import anamikroservisi.raspored_servis.exception.NotFoundException;
import anamikroservisi.raspored_servis.mapper.PredmetMapper;
import anamikroservisi.raspored_servis.model.Predmet;
import anamikroservisi.raspored_servis.repository.PredmetRepository;
import anamikroservisi.raspored_servis.service.PredmetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PredmetServiceImpl implements PredmetService {

    private PredmetRepository predmetRepository;
    private PredmetMapper predmetMapper;

    public PredmetServiceImpl(PredmetRepository predmetRepository, PredmetMapper predmetMapper) {
        this.predmetRepository = predmetRepository;
        this.predmetMapper = predmetMapper;
    }

    @Override
    public PredmetDto addPredmet(PredmetDto predmetDto) {
        Predmet predmet = predmetMapper.predmetDtoToPredmet(predmetDto);
        predmetRepository.save(predmet);
        return predmetDto;
    }

    @Override
    public PredmetDto getPredmetByNaziv(String naziv) {
        if (predmetRepository.findByNaziv(naziv).isPresent()){
            Predmet predmet = predmetRepository.findByNaziv(naziv).get();
            return predmetMapper.predmetToPredmetDto(predmet);
        }else{
            throw new NotFoundException(String.format("Predmet sa nazivom : %s nije pronadjen", naziv));
        }
    }
}
