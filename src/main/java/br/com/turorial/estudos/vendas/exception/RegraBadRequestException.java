package br.com.turorial.estudos.vendas.exception;

public class RegraBadRequestException extends RuntimeException {
    
    public RegraBadRequestException(String message) {
        super(message);
    }
}
