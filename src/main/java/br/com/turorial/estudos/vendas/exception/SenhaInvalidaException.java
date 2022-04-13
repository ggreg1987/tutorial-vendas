package br.com.turorial.estudos.vendas.exception;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException(String message) {
        super("Senha inválida");
    }
}
