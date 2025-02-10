package com.rafaelmachado.microservicea.mapper;

import com.rafaelmachado.microservicea.dto.PostagemDTO;
import com.rafaelmachado.microservicea.entidade.Postagem;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostagemMapperTest {

    @Test
    public void paraPostagem() {
        // Arrange
        PostagemDTO dto = new PostagemDTO("1", "10", "Test Title", "Test Body");

        // Act
        Postagem postagem = PostagemMapper.paraPostagem(dto);

        // Assert
        assertNotNull(postagem);
        assertEquals("1", postagem.getId());
        assertEquals("10", postagem.getUserId());
        assertEquals("Test Title", postagem.getTitle());
        assertEquals("Test Body", postagem.getBody());
    }

    @Test
    public void paraDTO() {
        // Arrange
        Postagem postagem = new Postagem("1", "10", "Test Title", "Test Body");

        // Act
        PostagemDTO dto = PostagemMapper.paraDTO(postagem);

        // Assert
        assertNotNull(dto);
        assertEquals("1", dto.getId());
        assertEquals("10", dto.getUserId());
        assertEquals("Test Title", dto.getTitle());
        assertEquals("Test Body", dto.getBody());
    }
}
