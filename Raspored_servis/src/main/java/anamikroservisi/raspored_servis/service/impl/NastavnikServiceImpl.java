package anamikroservisi.raspored_servis.service.impl;

import anamikroservisi.raspored_servis.dto.NastavnikDto;
import anamikroservisi.raspored_servis.exception.NotFoundException;
import anamikroservisi.raspored_servis.mapper.NastavnikMapper;
import anamikroservisi.raspored_servis.model.Nastavnik;
import anamikroservisi.raspored_servis.repository.NastavnikRepository;
import anamikroservisi.raspored_servis.service.NastavnikService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class NastavnikServiceImpl implements NastavnikService {

    private NastavnikRepository nastavnikRepository;
    private NastavnikMapper nastavnikMapper;

    public NastavnikServiceImpl(NastavnikRepository nastavnikRepository, NastavnikMapper nastavnikMapper) {
        this.nastavnikRepository = nastavnikRepository;
        this.nastavnikMapper = nastavnikMapper;
    }

    @Override
    public NastavnikDto addNastavnik(NastavnikDto nastavnikDto) {

        Nastavnik nastavnik = nastavnikMapper.nastavnikDtoToNastavnik(nastavnikDto);
        nastavnikRepository.save(nastavnik);
        return nastavnikDto;
    }

    @Override
    public NastavnikDto getNastavnikByNameAndSurname(String ime, String prezime) {
        if (nastavnikRepository.findByImeAndPrezime(ime, prezime).isPresent()){
            Nastavnik nastavnik = nastavnikRepository.findByImeAndPrezime(ime, prezime).get();
            return nastavnikMapper.nastavnikToNastavnikDto(nastavnik);
        }else{
            throw new NotFoundException(String.format("Nastavnik sa imenom : %s i prezimenom: %s nije pronadjen.", ime, prezime));
        }
    }


}
