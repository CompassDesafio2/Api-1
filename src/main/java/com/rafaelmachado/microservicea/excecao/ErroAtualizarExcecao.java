package com.rafaelmachado.microservicea.excecao;

public class ErroAtualizarExcecao extends RuntimeException 
  {
    public ErroAtualizarExcecao(String message) 
    {
        super(message);
    }
  }