package com.rafaelmachado.microservicea.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostagemDTO implements Serializable
{
  private String id;
  private String userId;
  private String tittle;
  private String body;

  public PostagemDTO() 
  {

  }

  public PostagemDTO(String id, String userId, String tittle, String body) 
  {
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
}