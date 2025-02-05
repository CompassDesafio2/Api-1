package com.compass.feing;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.compass.dto.PostagemDTO;
import com.compass.entidade.Postagem;

//FeignClient
public interface PostagemClient 
{
  @GetMapping(/*caminho*/)
  List<PostagemDTO> buscarTudo();

  @GetMapping(/*caminho*/)
  Optional<PostagemDTO> buscarPostagemPorId(@PathVariable Long id);

  @PostMapping(/*caminho*/)
  Postagem criarPostagem(Postagem postagem);

  @PutMapping(/*caminho*/)
  PostagemDTO atualizarPostagem(@PathVariable Long id, @RequestBody PostagemDTO postagemDTO);

  @DeleteMapping(/*caminho*/)
  void deletarPorId(@PathVariable Long id);
}