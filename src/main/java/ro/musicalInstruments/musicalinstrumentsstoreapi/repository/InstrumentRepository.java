package ro.musicalInstruments.musicalinstrumentsstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.musicalInstruments.musicalinstrumentsstoreapi.model.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument,Long> {


}
