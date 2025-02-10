package com.rafaelmachado.microservicea.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostagemDTOTest {

    @Test
    public void getId() {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setId("123");
        assertEquals("123", postagemDTO.getId());
    }

    @Test
    public void setId() {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setId("123");
        assertEquals("123", postagemDTO.getId());
    }

    @Test
    public void getUserId() {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setUserId("456");
        assertEquals("456", postagemDTO.getUserId());
    }

    @Test
    public void setUserId() {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setUserId("456");
        assertEquals("456", postagemDTO.getUserId());
    }

    @Test
    public void getTitle() {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setTitle("Test Title");
        assertEquals("Test Title", postagemDTO.getTitle());
    }

    @Test
    public void setTitle() {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setTitle("Test Title");
        assertEquals("Test Title", postagemDTO.getTitle());
    }

    @Test
    public void getBody() {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setBody("Test Body");
        assertEquals("Test Body", postagemDTO.getBody());
    }

    @Test
    public void setBody() {
        PostagemDTO postagemDTO = new PostagemDTO();
        postagemDTO.setBody("Test Body");
        assertEquals("Test Body", postagemDTO.getBody());
    }
}
