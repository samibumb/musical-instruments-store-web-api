package ro.musicalInstruments.musicalinstrumentsstoreapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.musicalInstruments.musicalinstrumentsstoreapi.dto.InstrumentDto;
import ro.musicalInstruments.musicalinstrumentsstoreapi.exception.InstrumentNotFoundException;
import ro.musicalInstruments.musicalinstrumentsstoreapi.model.Instrument;
import ro.musicalInstruments.musicalinstrumentsstoreapi.repository.InstrumentRepository;

@Service
public class InstrumentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstrumentService.class);

    private final InstrumentRepository instrumentRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository, ObjectMapper objectMapper) {
        this.instrumentRepository = instrumentRepository;
        this.objectMapper = objectMapper;
    }

    public Instrument createInstrument(InstrumentDto instrumentDto){
        LOGGER.info("Creating instrument {}",instrumentDto);

        Instrument instrument=objectMapper.convertValue(instrumentDto,Instrument.class);

       return instrumentRepository.save(instrument);
    }

    public Page<Instrument> getAllInstruments(Pageable pageable){

       return instrumentRepository.findAll(pageable);
    }

    public Instrument getInstrumentById(Long id) throws InstrumentNotFoundException {

        return instrumentRepository.findById(id).orElseThrow(()->new InstrumentNotFoundException("Instrument "+id+" not found."));
    }

    public void updateInstrument(Long id , InstrumentDto instrumentDto) throws InstrumentNotFoundException {
        Instrument instrument = getInstrumentById(id);

        BeanUtils.copyProperties(instrumentDto,instrument);

        instrumentRepository.save(instrument);
    }

    public void deleteById(Long id){

        instrumentRepository.deleteById(id);
    }
}
