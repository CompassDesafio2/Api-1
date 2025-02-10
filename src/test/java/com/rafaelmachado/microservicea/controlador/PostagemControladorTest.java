package com.rafaelmachado.microservicea.controlador;

import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import com.rafaelmachado.microservicea.mapper.PostagemMapper;
import com.rafaelmachado.microservicea.servico.PostagemServico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(PostagemControlador.class)
public class PostagemControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostagemServico postagemServico;

    @InjectMocks
    private PostagemControlador postagemControlador;

    private PostagemDTO postagemDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks do Mockito
        postagemDTO = new PostagemDTO("1", "10", "Title", "Body");
    }

    @Test
    public void getTodasPostagens_retornaLista() throws Exception {
        when(postagemServico.buscarTudo()).thenReturn(Arrays.asList(postagemDTO));

        mockMvc.perform(get("/api/postagens/todasPostagens"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].userId").value("10"))
                .andExpect(jsonPath("$[0].title").value("Title"))
                .andExpect(jsonPath("$[0].body").value("Body"));

        verify(postagemServico, times(1)).buscarTudo();
    }

    @Test
    public void getTodasPostagens_retornaNoContent() throws Exception {
        when(postagemServico.buscarTudo()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/postagens/todasPostagens"))
                .andExpect(status().isNoContent());

        verify(postagemServico, times(1)).buscarTudo();
    }

    @Test
    public void getBuscaPostagemPorId_retornaPostagem() throws Exception {
        when(postagemServico.buscarPostagemPorId(1L)).thenReturn(postagemDTO);

        mockMvc.perform(get("/api/postagens/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.userId").value("10"))
                .andExpect(jsonPath("$.title").value("Title"))
                .andExpect(jsonPath("$.body").value("Body"));

        verify(postagemServico, times(1)).buscarPostagemPorId(1L);
    }

    @Test
    public void getBuscaPostagemPorId_retornaNotFound() throws Exception {
        when(postagemServico.buscarPostagemPorId(1L)).thenReturn(null);

        mockMvc.perform(get("/api/postagens/1"))
                .andExpect(status().isNotFound());

        verify(postagemServico, times(1)).buscarPostagemPorId(1L);
    }

    @Test
    public void criarPostagem_retornaCriado() throws Exception {
        Postagem postagemCriada = PostagemMapper.paraPostagem(postagemDTO);
        when(postagemServico.criarPostagem(any())).thenReturn(postagemCriada);

        mockMvc.perform(post("/api/postagens")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"userId\":\"10\",\"title\":\"Title\",\"body\":\"Body\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.userId").value("10"))
                .andExpect(jsonPath("$.title").value("Title"))
                .andExpect(jsonPath("$.body").value("Body"));

        verify(postagemServico, times(1)).criarPostagem(any());
    }

    @Test
    public void atualizarPostagem_retornaAtualizado() throws Exception {
        when(postagemServico.atualizarPostagem(eq(1L), any())).thenReturn(postagemDTO);

        mockMvc.perform(put("/api/postagens/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"userId\":\"10\",\"title\":\"Updated Title\",\"body\":\"Updated Body\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.title").value("Updated Title"))
                .andExpect(jsonPath("$.body").value("Updated Body"));

        verify(postagemServico, times(1)).atualizarPostagem(eq(1L), any());
    }

    @Test
    public void atualizarPostagem_retornaNotFound() throws Exception {
        when(postagemServico.atualizarPostagem(eq(1L), any())).thenReturn(null);

        mockMvc.perform(put("/api/postagens/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"userId\":\"10\",\"title\":\"Updated Title\",\"body\":\"Updated Body\"}"))
                .andExpect(status().isNotFound());

        verify(postagemServico, times(1)).atualizarPostagem(eq(1L), any());
    }

    @Test
    public void deletarPostagemPorId_retornaNoContent() throws Exception {
        doNothing().when(postagemServico).deletarPorId(1L);

        mockMvc.perform(delete("/api/postagens/1"))
                .andExpect(status().isNoContent());

        verify(postagemServico, times(1)).deletarPorId(1L);
    }
}
