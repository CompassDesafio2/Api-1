package com.rafaelmachado.microservicea.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;


//@Mapper(componentModel = "spring")
//public interface PostagemMapper {
//  PostagemDTO paraDTO(Postagem postagem);
//  Postagem paraPostagem(PostagemDTO dto);
//}

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostagemMapper {

  public static Postagem paraPostagem(PostagemDTO dto) {
    return new ModelMapper().map(dto, Postagem.class);
  }

  public static PostagemDTO paraDTO(Postagem client) {
    return new ModelMapper().map(client, PostagemDTO.class);
  }

}