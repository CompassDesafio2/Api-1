package com.rafaelmachado.microservicea.excecao;

public class ErroBuscaExcecao extends RuntimeException 
{
  public ErroBuscaExcecao(String message) 
  {
      super(message);
  }
}