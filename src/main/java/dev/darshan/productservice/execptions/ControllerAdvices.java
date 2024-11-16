package dev.darshan.productservice.execptions;

import dev.darshan.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {


    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(ArrayIndexOutOfBoundsException notFoundExecption){

        return  new ResponseEntity(new ExceptionDto(
                HttpStatus.NOT_FOUND,notFoundExecption.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}

