package com.compass.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.dto.PostagemDTO;
import com.compass.servico.PostagemServico;

@RestController
@CrossOrigin(origins = "https://editor.swagger.io")
@RequestMapping("/api/postagens")
public class PostagemControlador 
{
  @Autowired 
  private PostagemServico postagemServico;

  @GetMapping("/todasPostagens")
  public ResponseEntity<List<PostagemDTO>> getTodasPostagens()
  {
    List<PostagemDTO> postagens = postagemServico.buscarTudo();
    if (postagens.isEmpty()) 
    {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content caso não haja postagens
    }
    return ResponseEntity.ok(postagens); // 200 OK
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<PostagemDTO> getBuscaPostagemPorId(@PathVariable Long id)
  {
    PostagemDTO postagem = postagemServico.buscarPostagemPorId(id);
    if (postagem == null) 
    {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found caso a postagem não exista
    }
    return ResponseEntity.ok(postagem); // 200 OK
  }
/*
  @PostMapping
  public ResponseEntity<PostagemDTO> criarPostagem(@RequestBody PostagemDTO dto)
  {
    PostagemDTO postagemCriada = postagemServico.criarPostagem(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(postagemCriada); // 201 Created
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<PostagemDTO> atualizarPostagem(@PathVariable Long id, @RequestBody PostagemDTO dto) 
  {
    PostagemDTO postagemAtualizada = postagemServico.atualizarPostagem(id, dto);
    if (postagemAtualizada == null) 
    {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found caso a postagem não seja encontrada
    }
    return ResponseEntity.status(HttpStatus.OK).body(postagemAtualizada); // 200 OK
  }
     */

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deletarPostagemPorId(@PathVariable Long id) 
  {
    postagemServico.deletarPorId(id); 
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content para deleção bem-sucedida
  }
  
}