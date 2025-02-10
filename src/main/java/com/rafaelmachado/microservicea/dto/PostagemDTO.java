package com.rafaelmachado.microservicea.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostagemDTO implements Serializable
{
  private String id;
  private String idUsuario;
  private String titulo;
  private String corpoTexto;

  public PostagemDTO() 
  {

  }

  public PostagemDTO(String id, String idUsuario, String titulo, String corpoTexto) 
  {
    this.idUsuario = idUsuario;
    this.titulo = titulo;
    this.corpoTexto = corpoTexto;
  }

  public String getId() 
  {
    return id;
  }

  public void setId(String id) 
  {
    this.id = id;
  }

  public String getIdUsuario() 
  {
    return idUsuario;
  }

  public void setIdUsuario(String idUsuario) 
  {
    this.idUsuario = idUsuario;
  }

  public String getTitulo() 
  {
    return titulo;
  }

  public void setTitulo(String titulo) 
  {
    this.titulo = titulo;
  }

  public String getCorpoTexto() 
  {
    return corpoTexto;
  }

  public void setCorpoTexto(String corpoTexto) 
  {
    this.corpoTexto = corpoTexto;
  }
}