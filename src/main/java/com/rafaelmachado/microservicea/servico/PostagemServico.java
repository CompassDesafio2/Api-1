package com.rafaelmachado.microservicea.servico;

import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import com.rafaelmachado.microservicea.feing.PostagemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
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
          .orElseThrow(() -> new RuntimeException("Postagem não encontrada!"));
  }

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

//  exception do buscarPostagemPorId
  public PostagemDTO atualizarPostagem(Long id, PostagemDTO postagemDTO)
  {
    PostagemDTO postagemAtualizada = postagemClient.buscarPostagemPorId(id)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada!"));

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
      throw new RuntimeException("Erro ao deletar postagem!");
    }
  }
}