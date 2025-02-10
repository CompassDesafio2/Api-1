package com.rafaelmachado.microservicea.excecao;

public class ErroCriacaoExcecao extends RuntimeException 
  {
    public ErroCriacaoExcecao(String message) 
    {
        super(message);
    }
  }