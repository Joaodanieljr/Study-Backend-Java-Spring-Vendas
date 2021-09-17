package com.joaodanieljr.exceptions;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(String mesangem) {
        super(mesangem);
    }
}
