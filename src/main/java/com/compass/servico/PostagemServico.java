package com.compass.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.compass.dto.PostagemDTO;
import com.compass.entidade.Postagem;
import com.compass.feing.PostagemClient;

public class PostagemServico 
{
  @Autowired
  private PostagemClient postagemClient;


  //criar exception personalizada 
  public List<PostagemDTO> buscarTudo()
  {
    List<PostagemDTO> postagem = postagemClient.buscarTudo();

    if (postagem == null || postagem.isEmpty())
    {
      throw new RuntimeException("Nenhuma postagem encontrada!");
    }
    return postagem;
  }

  //criar exception personalizada
  public PostagemDTO buscarPostagemPorId(Long id)
  {
    Optional<PostagemDTO> postagem = postagemClient.buscarPostagemPorId(id);
    return postagem
          .orElseThrow(()-> new RuntimeException("Postagem não encontrada!"));
  }

  //GET COMENTARIOS da POSTAGEM

  //criar exception personalizada
  public Postagem criarPostagem(Postagem postagem)
  {
    try
    {
      return postagemClient.criarPostagem(postagem);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Erro ao criar postagem!");
    }
  }

   //exception do buscarPostagemPorId
  public PostagemDTO atualizarPostagem(Long id, PostagemDTO postagemDTO)
  {
    PostagemDTO postagemAtualizada = postagemClient.buscarPostagemPorId(id)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada!"));
    
    postagemAtualizada.getIdUsuario();
    postagemAtualizada.getId();
    postagemAtualizada.setTitulo(postagemDTO.getTitulo());
    postagemAtualizada.setCorpoTexto(postagemDTO.getCorpoTexto());

    try
    {
      return postagemClient.atualizarPostagem(id, postagemAtualizada);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Erro ao atualizar a postagem!");
    }
  }

  public void deletarPorId(Long id) 
  {
    postagemClient.buscarPostagemPorId(id)
        .orElseThrow(() -> new RuntimeException("Postagem não encontrada!"));

    try 
    {
      postagemClient.deletarPorId(id);
    } 
    catch (Exception e) 
    {
      throw new RuntimeException("Erro ao deletar postagem");
    }
  }
}