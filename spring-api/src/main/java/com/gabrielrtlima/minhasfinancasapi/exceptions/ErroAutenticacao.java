package com.gabrielrtlima.minhasfinancasapi.exceptions;

public class ErroAutenticacao extends RuntimeException{

    public ErroAutenticacao(String mensagem) {
        super(mensagem);
    }
}
