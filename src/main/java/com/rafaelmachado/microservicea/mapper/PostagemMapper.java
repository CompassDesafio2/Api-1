package com.rafaelmachado.microservicea.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostagemMapper 
{
  public static Postagem paraPostagem(PostagemDTO dto) 
  {
    return new ModelMapper().map(dto, Postagem.class);
  }

  public static PostagemDTO paraDTO(Postagem client) 
  {
    return new ModelMapper().map(client, PostagemDTO.class);
  }
}