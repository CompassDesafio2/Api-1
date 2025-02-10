package com.rafaelmachado.microservicea.feing;

import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@FeignClient(name = "apiB",
        url = "http://localhost:8081/")
public interface PostagemClient 
{
  @GetMapping("/posts")
  List<PostagemDTO> buscarTudo();

  @GetMapping("/posts/{id}")
  Optional<PostagemDTO> buscarPostagemPorId(@PathVariable("id") Long id);

  @PostMapping("/posts")
  Postagem criarPostagem(@RequestBody Postagem postagem);

  @PutMapping("/posts/{id}")
  PostagemDTO atualizarPostagem(@PathVariable("id") Long id, @RequestBody PostagemDTO postagemDTO);

  @DeleteMapping("/posts/{id}")
  void deletarPorId(@PathVariable("id") Long id);
}