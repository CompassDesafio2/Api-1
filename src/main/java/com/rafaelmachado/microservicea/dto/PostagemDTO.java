package com.rafaelmachado.microservicea.dto;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostagemDTO implements Serializable
{
  private Long idUsuario;
  private Long id;
  private String titulo;
  private String corpoTexto;
}