package ro.musicalInstruments.musicalinstrumentsstoreapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.musicalInstruments.musicalinstrumentsstoreapi.model.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument,Long> {

    //used the Java Persistence query language
    @Query("Select instrument.instrument,instrument.brand from Instrument instrument")
    Instrument findByInstrumentAndBrand(String instrument,String brand);

    //used the native Query
    @Query(value = "select * from Instrument where brand like 'Y%'",nativeQuery = true)
    Page<Instrument> findByPartialBrand(Pageable pageable);
}
