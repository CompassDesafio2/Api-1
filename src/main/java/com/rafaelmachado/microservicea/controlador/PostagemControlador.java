package com.rafaelmachado.microservicea.controlador;

import java.util.List;

import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import com.rafaelmachado.microservicea.excecao.ErrorMessage;
import com.rafaelmachado.microservicea.mapper.PostagemMapper;
import com.rafaelmachado.microservicea.servico.PostagemServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://editor.swagger.io")
@RequestMapping( value = "/api/postagens")
public class PostagemControlador
{
  @Autowired
  private PostagemServico postagemServico;


  @Operation(summary = "GET ALL POSTAGEM", description = "Pegar todas as Postagens salvas no banco",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Todas as Postagens foram retornadas!"
                    ),
                    @ApiResponse(responseCode = "404",
                            description = "Nenhuma Postagem foi encontrada",
                            content = @Content(
                                    mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = PostagemDTO.class))
                    ),
            })
  @GetMapping("/todasPostagens")
  public ResponseEntity<List<PostagemDTO>> getTodasPostagens()
  {
    List<PostagemDTO> postagens = postagemServico.buscarTudo();
    if (postagens.isEmpty())
    {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content caso não haja postagens
    }
    return ResponseEntity.ok().body(postagens); // 200 OK
  }


  @Operation(summary = "Informação de Um POST", description = "Pegar as informações de uma Postagem",
  responses = {
          @ApiResponse(responseCode = "200",
                  description = "Postagem encontrada com Sucesso",
                  content = @Content(
                          mediaType = "application/json;charset=UTF-8",
                          schema = @Schema(implementation = PostagemDTO.class))
          ),
  })
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


  @Operation(summary = "Criar Novo Post", description = "CREATE",
  responses = {
          @ApiResponse(responseCode = "201",
                  description = " Novo Post Criado com Sucesso",
                  content = @Content(
                          mediaType = "application/json;charset=UTF-8",
                          schema = @Schema(implementation = PostagemDTO.class))
          ),
  })
  @PostMapping
  public ResponseEntity<PostagemDTO> criarPostagem(@RequestBody PostagemDTO dto)
  {
    Postagem postagemCriada = postagemServico.criarPostagem(PostagemMapper.paraPostagem(dto));
    return ResponseEntity.status(HttpStatus.CREATED).body(PostagemMapper.paraDTO(postagemCriada)); // 201 Created
  }


  @Operation(summary = "Atualizar Postagem", description = "Atualizar todas as informações de uma Postagem através da ID informada",
            responses = {
                    @ApiResponse(responseCode = "204",
                            description = "Atualização feita com sucesso",
                            content = @Content(
                                    mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = PostagemDTO.class))
                    ),
                    @ApiResponse(responseCode = "404",
                            description = "Post Não Encontrado",
                            content = @Content(
                                    mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class))
                    ),

            })
  @PutMapping("/{id}")
  public ResponseEntity<PostagemDTO> atualizarPostagem(@PathVariable Long id, @RequestBody PostagemDTO postagemDTO)
  {
    PostagemDTO postagemAtualizada = postagemServico.atualizarPostagem(id, postagemDTO); //possível erro
    if (postagemAtualizada == null)
    {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found caso a postagem não seja encontrada
    }
    return ResponseEntity.status(HttpStatus.OK).body(postagemAtualizada); // 200 OK
  }
     

  @Operation(summary = "Deletar POSTAGEM", description = "Deletar uma Postagem através da ID informada",
            responses = {
                    @ApiResponse(responseCode = "204",
                            description = "Postagem Deletada Com Sucesso",
                            content = @Content(
                                    mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = PostagemDTO.class))
                    ),
                    @ApiResponse(responseCode = "404",
                            description = "Post Não Encontrado",
                            content = @Content(
                                    mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class))
                    ),
            })
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deletarPostagemPorId(@PathVariable Long id)
  {
    postagemServico.deletarPorId(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content para deleção bem-sucedida
  }
}