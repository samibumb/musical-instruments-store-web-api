package ro.musicalInstruments.musicalinstrumentsstoreapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ro.musicalInstruments.musicalinstrumentsstoreapi.dto.InstrumentDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicalInstrumentsIntegrationTests {

	@Test
	public void createInstrument() {

		InstrumentDto instrumentDto = new InstrumentDto();
		instrumentDto.setInstrument("Drums");
		instrumentDto.setBrand("Tama");
		instrumentDto.setModel("");
	}

}
