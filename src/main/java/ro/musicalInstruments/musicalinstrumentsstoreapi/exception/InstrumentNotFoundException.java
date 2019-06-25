package ro.musicalInstruments.musicalinstrumentsstoreapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InstrumentNotFoundException extends Exception {

    public InstrumentNotFoundException(String message){
        super(message);
    }
}
