package com.rafaelmachado.microservicea.entidade;

import java.io.Serializable;

public class Postagem implements Serializable
{
  private static final long serialVersionUID = 1L;

  private String id;
  private String userId;
  private String tittle;
  private String body;

  public Postagem() 
  {

  }

  public Postagem(String id, String userId, String tittle, String body) 
  {
    this.id = id;
    this.userId = userId;
    this.tittle = tittle;
    this.body = body;
  }

  public String getId() 
  {
    return id;
  }

  public void setId(String id) 
  {
    this.id = id;
  }

  public String getUserId() 
  {
    return userId;
  }

  public void setUserId(String userId) 
  {
    this.userId = userId;
  }

  public String getTittle() 
  {
    return tittle;
  }

  public void setTittle(String tittle) 
  {
    this.tittle = tittle;
  }

  public String getBody() 
  {
    return body;
  }

  public void setBody(String body) 
  {
    this.body = body;
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