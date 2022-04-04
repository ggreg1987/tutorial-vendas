package br.com.turorial.estudos.vendas.exception;

import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handdleRegraNotFoundException(RegraNotFoundException ex) {
        String message = ex.getMessage();
        return new ApiErrors(message);
    }

    @ExceptionHandler(RegraBadRequestException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handdleRegraBadRequestException(RegraBadRequestException ex) {
        String message = ex.getMessage();
        return new ApiErrors(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex) {
        ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .collect(Collectors.toList());
    }
}
