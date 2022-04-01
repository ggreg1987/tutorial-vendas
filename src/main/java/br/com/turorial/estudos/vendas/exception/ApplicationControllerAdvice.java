package br.com.turorial.estudos.vendas.exception;

import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handdleRegraNotFoundException(RegraNotFoundException ex) {
        String message = ex.getMessage();
        return new ApiErrors(message);
    }
}
