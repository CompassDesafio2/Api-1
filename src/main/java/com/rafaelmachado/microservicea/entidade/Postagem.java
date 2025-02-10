package com.rafaelmachado.microservicea.entidade;

import java.io.Serializable;

public class Postagem implements Serializable
{
  private static final long serialVersionUID = 1L;

  private String id;
  private String idUsuario;
  private String titulo;
  private String corpoTexto;

  public Postagem() 
  {

  }

  public Postagem(String id, String idUsuario, String titulo, String corpoTexto) 
  {
    this.id = id;
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

  @Override
  public int hashCode() 
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) 
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Postagem other = (Postagem) obj;
    if (id == null) 
    {
      if (other.id != null)
        return false;
    } 
    else if (!id.equals(other.id))
      return false;
    return true;
  }  
}