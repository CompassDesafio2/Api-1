package com.rafaelmachado.microservicea.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;

@Mapper(componentModel = "spring")
public interface PostagemMapper 
{
  PostagemMapper INSTANCE = Mappers.getMapper(PostagemMapper.class);

  PostagemDTO paraDTO(Postagem postagem);

  Postagem paraPostagem(PostagemDTO dto);

  AtualizarPostagemDTO AtualizarPostagemParaDTO(PostagemDTO postagemDTO);

  PostagemDTO atualizarParaPostagem(AtualizarPostagemDTO dto);
}