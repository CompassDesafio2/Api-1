package com.rafaelmachado.microservicea.entidade;

import java.io.Serializable;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Postagem implements Serializable
{
  private static final long serialVersionUID = 1L;

  private Long idUsuario;
  private Long id;
  private String titulo;
  private String corpoTexto;

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