package com.rafaelmachado.microservicea.entidade;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostagemTest {

    @Test
    public void getId() {
        Postagem postagem = new Postagem();
        postagem.setId("123");
        assertEquals("123", postagem.getId());
    }

    @Test
    public void setId() {
        Postagem postagem = new Postagem();
        postagem.setId("123");
        assertEquals("123", postagem.getId());
    }

    @Test
    public void getUserId() {
        Postagem postagem = new Postagem();
        postagem.setUserId("456");
        assertEquals("456", postagem.getUserId());
    }

    @Test
    public void setUserId() {
        Postagem postagem = new Postagem();
        postagem.setUserId("456");
        assertEquals("456", postagem.getUserId());
    }

    @Test
    public void getTitle() {
        Postagem postagem = new Postagem();
        postagem.setTitle("Test Title");
        assertEquals("Test Title", postagem.getTitle());
    }

    @Test
    public void setTitle() {
        Postagem postagem = new Postagem();
        postagem.setTitle("Test Title");
        assertEquals("Test Title", postagem.getTitle());
    }

    @Test
    public void getBody() {
        Postagem postagem = new Postagem();
        postagem.setBody("Test Body");
        assertEquals("Test Body", postagem.getBody());
    }

    @Test
    public void setBody() {
        Postagem postagem = new Postagem();
        postagem.setBody("Test Body");
        assertEquals("Test Body", postagem.getBody());
    }

    @Test
    public void testHashCode() {
        Postagem postagem1 = new Postagem("123", "456", "Title", "Body");
        Postagem postagem2 = new Postagem("123", "789", "Other Title", "Other Body");
        assertEquals(postagem1.hashCode(), postagem2.hashCode());
    }

    @Test
    public void testEquals_sameObject() {
        Postagem postagem = new Postagem("123", "456", "Title", "Body");
        assertTrue(postagem.equals(postagem));
    }

    @Test
    public void testEquals_equalObjects() {
        Postagem postagem1 = new Postagem("123", "456", "Title", "Body");
        Postagem postagem2 = new Postagem("123", "789", "Other Title", "Other Body");
        assertTrue(postagem1.equals(postagem2));
    }

    @Test
    public void testEquals_differentObjects() {
        Postagem postagem1 = new Postagem("123", "456", "Title", "Body");
        Postagem postagem2 = new Postagem("789", "456", "Title", "Body");
        assertFalse(postagem1.equals(postagem2));
    }

    @Test
    public void testEquals_nullObject() {
        Postagem postagem = new Postagem("123", "456", "Title", "Body");
        assertFalse(postagem.equals(null));
    }

    @Test
    public void testEquals_differentClass() {
        Postagem postagem = new Postagem("123", "456", "Title", "Body");
        String other = "Not a Postagem";
        assertFalse(postagem.equals(other));
    }
}
