package com.silasgreen.songr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    @Test
    public void testConstructor() {

        Album sil = new Album("Come", "Lester Landiz", 100, 240, "www.seezu.com");
        assertEquals(false, sil.getImageUrl().isEmpty());
        assertEquals(true, sil.getArtist().startsWith("L"));
        assertEquals(true, sil.getTitle().matches("Come"));
    }

    @Test
    public void testGetters() {
        Album sil = new Album("Gorriezyx", "Harrisa Loomens", 10, 360, "www.wanderland.com");

        assertEquals(false, sil.getArtist().isEmpty());
        assertEquals("Harrisa Loomens", sil.getArtist());
        assertEquals(10, sil.getSongCount());
        assertEquals(360, sil.getLengthInSeconds());
        assertEquals("www.wanderland.com", sil.getImageUrl());
    }

    @Test
    public void testSetters() {
        Album sil = new Album("Gorriezyx", "Harrisa Loomens", 10, 360, "www.wanderland.com");

        sil.setArtist("Tirsty");
        sil.setTitle("whao");
        sil.setSongCount(2);
        sil.setLengthInSeconds(200000);
        sil.setImageUrl("www.goog.com");

        System.out.println(sil.getArtist());

        assertEquals("Tirsty", sil.getArtist());
        assertEquals("whao", sil.getTitle());
        assertEquals(2, sil.getSongCount());
        assertEquals(200000, sil.getLengthInSeconds());
        assertEquals("www.goog.com", sil.getImageUrl());
    }
}