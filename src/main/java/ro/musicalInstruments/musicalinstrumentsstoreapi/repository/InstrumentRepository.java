package ro.musicalInstruments.musicalinstrumentsstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.musicalInstruments.musicalinstrumentsstoreapi.model.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument,Long> {

    @Query("Select instrument.instrument,instrument.brand from Instrument instrument")
    Instrument findByInstrumentAndBrand(String instrument,String brand);

}
