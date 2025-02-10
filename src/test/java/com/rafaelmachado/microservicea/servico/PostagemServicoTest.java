package com.rafaelmachado.microservicea.servico;

import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import com.rafaelmachado.microservicea.feing.PostagemClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PostagemServicoTest {

    @InjectMocks
    private PostagemServico postagemServico;

    @Mock
    private PostagemClient postagemClient;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buscarTudo() {
        // Arrange
        List<PostagemDTO> mockPostagens = Arrays.asList(
                new PostagemDTO("1", "10", "Title1", "Body1"),
                new PostagemDTO("2", "20", "Title2", "Body2")
        );
        when(postagemClient.buscarTudo()).thenReturn(mockPostagens);

        // Act
        List<PostagemDTO> result = postagemServico.buscarTudo();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(postagemClient, times(1)).buscarTudo();
    }

    @Test(expected = RuntimeException.class)
    public void buscarTudoComErro() {
        // Arrange
        when(postagemClient.buscarTudo()).thenReturn(null);

        // Act
        postagemServico.buscarTudo();
    }

    @Test
    public void buscarPostagemPorId() {
        // Arrange
        PostagemDTO mockPostagem = new PostagemDTO("1", "10", "Title1", "Body1");
        when(postagemClient.buscarPostagemPorId(1L)).thenReturn(Optional.of(mockPostagem));

        // Act
        PostagemDTO result = postagemServico.buscarPostagemPorId(1L);

        // Assert
        assertNotNull(result);
        assertEquals("1", result.getId());
        verify(postagemClient, times(1)).buscarPostagemPorId(1L);
    }

    @Test(expected = RuntimeException.class)
    public void buscarPostagemPorIdComErro() {
        // Arrange
        when(postagemClient.buscarPostagemPorId(1L)).thenReturn(Optional.empty());

        // Act
        postagemServico.buscarPostagemPorId(1L);
    }

    @Test
    public void criarPostagem() {
        // Arrange
        Postagem mockPostagem = new Postagem("1", "10", "Title1", "Body1");
        when(postagemClient.criarPostagem(any(Postagem.class))).thenReturn(mockPostagem);

        // Act
        Postagem result = postagemServico.criarPostagem(mockPostagem);

        // Assert
        assertNotNull(result);
        assertEquals("1", result.getId());
        verify(postagemClient, times(1)).criarPostagem(mockPostagem);
    }

    @Test(expected = RuntimeException.class)
    public void criarPostagemComErro() {
        // Arrange
        Postagem mockPostagem = new Postagem("1", "10", "Title1", "Body1");
        when(postagemClient.criarPostagem(any(Postagem.class))).thenThrow(new RuntimeException("Erro"));

        // Act
        postagemServico.criarPostagem(mockPostagem);
    }

    @Test
    public void atualizarPostagem() {
        // Arrange
        PostagemDTO mockPostagem = new PostagemDTO("1", "10", "Updated Title", "Updated Body");
        when(postagemClient.buscarPostagemPorId(1L)).thenReturn(Optional.of(mockPostagem));
        when(postagemClient.atualizarPostagem(eq(1L), any(PostagemDTO.class))).thenReturn(mockPostagem);

        // Act
        PostagemDTO result = postagemServico.atualizarPostagem(1L, mockPostagem);

        // Assert
        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
        verify(postagemClient, times(1)).buscarPostagemPorId(1L);
        verify(postagemClient, times(1)).atualizarPostagem(eq(1L), any(PostagemDTO.class));
    }

    @Test(expected = RuntimeException.class)
    public void atualizarPostagemComErro() {
        // Arrange
        PostagemDTO mockPostagem = new PostagemDTO("1", "10", "Title1", "Body1");
        when(postagemClient.buscarPostagemPorId(1L)).thenReturn(Optional.empty());

        // Act
        postagemServico.atualizarPostagem(1L, mockPostagem);
    }

    @Test
    public void deletarPorId() {
        // Arrange
        PostagemDTO mockPostagem = new PostagemDTO("1", "10", "Title1", "Body1");
        when(postagemClient.buscarPostagemPorId(1L)).thenReturn(Optional.of(mockPostagem));

        // Act
        postagemServico.deletarPorId(1L);

        // Assert
        verify(postagemClient, times(1)).buscarPostagemPorId(1L);
        verify(postagemClient, times(1)).deletarPorId(1L);
    }

    @Test(expected = RuntimeException.class)
    public void deletarPorIdComErro() {
        // Arrange
        when(postagemClient.buscarPostagemPorId(1L)).thenReturn(Optional.empty());

        // Act
        postagemServico.deletarPorId(1L);
    }
}
