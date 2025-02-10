package com.rafaelmachado.microservicea.excecao;

public class ErroDeletarExcecao extends RuntimeException 
  {
    public ErroDeletarExcecao(String message) 
    {
        super(message);
    }
  }