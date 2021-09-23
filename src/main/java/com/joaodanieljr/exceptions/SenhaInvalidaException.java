package com.joaodanieljr.exceptions;

public class SenhaInvalidaException extends RuntimeException {

    public SenhaInvalidaException() {
        super("Senha Invalida");
    }
}
