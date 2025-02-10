package com.rafaelmachado.microservicea.controlador;

import java.util.List;

import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import com.rafaelmachado.microservicea.mapper.PostagemMapper;
import com.rafaelmachado.microservicea.servico.PostagemServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://editor.swagger.io")
@RequestMapping(value = "/api/postagens")
public class PostagemControlador {
  @Autowired
  private PostagemServico postagemServico;

  @GetMapping("/todasPostagens")
  public ResponseEntity<List<PostagemDTO>> getTodasPostagens() {
    List<PostagemDTO> postagens = postagemServico.buscarTudo();
    if (postagens.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content caso não haja postagens
    }
    return ResponseEntity.ok().body(postagens); // 200 OK
  }

  @GetMapping("/{id}")
  public ResponseEntity<PostagemDTO> getBuscaPostagemPorId(@PathVariable String id) {
    PostagemDTO postagem = postagemServico.buscarPostagemPorId(id);
    if (postagem == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found caso a postagem não exista
    }
    return ResponseEntity.ok(postagem); // 200 OK
  }

  @PostMapping
  public ResponseEntity<PostagemDTO> criarPostagem(@RequestBody PostagemDTO dto) {
    Postagem postagemCriada = postagemServico.criarPostagem(PostagemMapper.paraPostagem(dto));
    return ResponseEntity.status(HttpStatus.CREATED).body(PostagemMapper.paraDTO(postagemCriada)); // 201 Created
  }

  @PutMapping("/{id}")
  public ResponseEntity<PostagemDTO> atualizarPostagem(@PathVariable String id, @RequestBody PostagemDTO postagemDTO) {
    PostagemDTO postagemAtualizada = postagemServico.atualizarPostagem(id, postagemDTO); // possível erro
    if (postagemAtualizada == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found caso a postagem não seja encontrada
    }
    return ResponseEntity.status(HttpStatus.OK).body(postagemAtualizada); // 200 OK
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deletarPostagemPorId(@PathVariable String id) {
    postagemServico.deletarPorId(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content para deleção bem-sucedida
  }
}