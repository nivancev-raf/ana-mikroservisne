package anamikroservisi.raspored_servis.controller;

import anamikroservisi.raspored_servis.dto.*;
import anamikroservisi.raspored_servis.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/raspored")
public class RasporedController {

    private NastavnikService nastavnikService;
    private PredmetService predmetService;
    private TerminService terminService;
    private UcionicaService ucionicaService;
    private GrupaService grupaService;

    public RasporedController(NastavnikService nastavnikService, PredmetService predmetService, TerminService terminService, UcionicaService ucionicaService, GrupaService grupaService) {
        this.nastavnikService = nastavnikService;
        this.predmetService = predmetService;
        this.terminService = terminService;
        this.ucionicaService = ucionicaService;
        this.grupaService = grupaService;
    }

    // NASTAVNIK:

    @PostMapping("/nastavnik")
    public ResponseEntity<NastavnikDto> addNastavnik(@RequestBody NastavnikDto nastavnikDto) {
        return new ResponseEntity<>(nastavnikService.addNastavnik(nastavnikDto), HttpStatus.CREATED);
    }

    // pretraga nastavnika po imenu i prezimenu
    @GetMapping("/nastavnik/{ime}/{prezime}")
    public ResponseEntity<NastavnikDto> getNastavnik(@PathVariable String ime, @PathVariable String prezime) {
        return new ResponseEntity<>(nastavnikService.getNastavnikByNameAndSurname(ime, prezime), HttpStatus.OK);
    }

    // PREDMET:

    @PostMapping("/predmet")
    public ResponseEntity<PredmetDto> addPredmet(@RequestBody PredmetDto predmetDto) {
        return new ResponseEntity<>(predmetService.addPredmet(predmetDto), HttpStatus.CREATED);
    }

    // pretraga predmeta po nazivu
    @GetMapping("/predmet/{naziv}")
    public ResponseEntity<PredmetDto> getPredmet(@PathVariable String naziv) {
        return new ResponseEntity<>(predmetService.getPredmetByNaziv(naziv), HttpStatus.OK);
    }

    // GRUPE:

    @PostMapping("/grupa")
    public ResponseEntity<GrupaDto> addGrupa(@RequestBody GrupaDto grupaDto) {
        return new ResponseEntity<>(grupaService.addGrupa(grupaDto), HttpStatus.CREATED);
    }

    // pretraga grupe po oznaci
    @GetMapping("/grupa/{oznaka}")
    public ResponseEntity<GrupaDto> getGrupa(@PathVariable String oznaka) {
        return new ResponseEntity<>(grupaService.getGrupaByOznaka(oznaka), HttpStatus.OK);
    }

    // UCIONICE:

    @PostMapping("/ucionica")
    public ResponseEntity<UcionicaDto> addUcionica(@RequestBody UcionicaDto ucionicaDto) {
        return new ResponseEntity<>(ucionicaService.addUcionica(ucionicaDto), HttpStatus.CREATED);
    }

    // pretraga ucionice po oznaci
    @GetMapping("/ucionica/{oznaka}")
    public ResponseEntity<UcionicaDto> getUcionica(@PathVariable String oznaka) {
        return new ResponseEntity<>(ucionicaService.getUcionicaByOznaka(oznaka), HttpStatus.OK);
    }

    // TERMINI:


    @PostMapping("/termin")
    public ResponseEntity<TerminDto> addTermin(@RequestBody TerminDto terminDto) {
        return new ResponseEntity<>(terminService.addTermin(terminDto), HttpStatus.CREATED);
    }

    //brisanje termina po id-u
    @DeleteMapping("/termin/{id}")
    public ResponseEntity<Void> deleteTermin(@PathVariable Long id) {
        terminService.deleteTermin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // pretraga termina po danu u nedelji, vraca listu termina
    @GetMapping("/termin/{dan}")
    public ResponseEntity<List<TerminDto>> getTermini(@PathVariable String dan) {
        return new ResponseEntity<>(terminService.getTerminByDan(dan), HttpStatus.OK);
    }


}