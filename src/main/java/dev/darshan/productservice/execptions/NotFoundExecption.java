package dev.darshan.productservice.execptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundExecption extends Exception{

    public NotFoundExecption(String message) {
        super(message);
    }
}
