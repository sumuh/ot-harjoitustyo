package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoPalauttaaOikeanSaldon() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(90);
        assertEquals("saldo: 1.0", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinKunRahaaTarpeeksi() {
        assertTrue(kortti.otaRahaa(5));
        assertEquals("saldo: 0.5", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuKunRahaaEiTarpeeksi() {
        assertFalse(kortti.otaRahaa(100));
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    
}
