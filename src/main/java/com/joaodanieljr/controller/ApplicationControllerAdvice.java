package com.joaodanieljr.controller;

import com.joaodanieljr.exceptions.ApiErrors;
import com.joaodanieljr.exceptions.PedidoNaoEncontradoException;
import com.joaodanieljr.exceptions.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioException exception){
        String mensagemErro = exception.getMessage();
        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlePedidoNaoEncontrado(PedidoNaoEncontradoException exception){
        String mensagemErro = exception.getMessage();
        return new ApiErrors(mensagemErro);
    }
}
