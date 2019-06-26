package ro.musicalInstruments.musicalinstrumentsstoreapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.musicalInstruments.musicalinstrumentsstoreapi.dto.InstrumentDto;
import ro.musicalInstruments.musicalinstrumentsstoreapi.exception.InstrumentNotFoundException;
import ro.musicalInstruments.musicalinstrumentsstoreapi.model.Instrument;
import ro.musicalInstruments.musicalinstrumentsstoreapi.service.InstrumentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/instruments/")
@CrossOrigin
public class InstrumentController {

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @PostMapping("createInstrument")
    public ResponseEntity<Instrument> createInstrument(@RequestBody @Valid InstrumentDto instrumentDto){

        Instrument instrument = instrumentService.createInstrument(instrumentDto);

        return new ResponseEntity<>(instrument, HttpStatus.CREATED);
    }

    @GetMapping("getAllInstruments")
    public ResponseEntity<Page<Instrument>> getAllInstruments(Pageable pageable){

        Page<Instrument> response= instrumentService.getAllInstruments(pageable);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Instrument> getById(@PathVariable("id") Long id) throws InstrumentNotFoundException {

        Instrument instrument =instrumentService.getInstrumentById(id);

        return new ResponseEntity<>(instrument,HttpStatus.OK);
    }

    @PutMapping("updateById/{id}")
    public ResponseEntity updateInstrument(@RequestBody @Valid InstrumentDto instrumentDto,@PathVariable("id") Long id) throws InstrumentNotFoundException {

        instrumentService.updateInstrument(id,instrumentDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){

        instrumentService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getByInstrumentAndBrand/{instrument}/{brand}")
    public ResponseEntity<Instrument> findByInstrumentAndBrand(@PathVariable("instrument") String instrument,@PathVariable("brand") String brand){

        Instrument response = instrumentService.findByInstrumentAndBrand(instrument,brand);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping(value = "getAllFirstCharY")
    public ResponseEntity<Page<Instrument>> getFirstCharY(Pageable pageable){

       Page<Instrument> response = instrumentService.findByPartialName(pageable);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
