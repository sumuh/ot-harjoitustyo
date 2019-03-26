/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Susanna Muhli
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    @Test
    public void kassaAlussaOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullistenKateisostoToimiiTasarahalla() {
        assertEquals(0, kassa.syoEdullisesti(240));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullistenKateisostoToimiiKunSaaVaihtorahaa() {
        assertEquals(60, kassa.syoEdullisesti(300));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullistenKateisostoToimiiKunEiTarpeeksiRahaa() {
        assertEquals(100, kassa.syoEdullisesti(100));
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaidenKateisostoToimiiTasaRahalla() {
        assertEquals(0, kassa.syoMaukkaasti(400));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaidenKateisostoToimiiKunSaaVaihtorahaa() {
        assertEquals(100, kassa.syoMaukkaasti(500));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaidenKateisostoToimiiKunEiTarpeeksiRahaa() {
        assertEquals(100, kassa.syoMaukkaasti(100));
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullistenKorttiostoToimiiTasarahalla() {
        kortti = new Maksukortti(240);
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullistenKorttiostoToimiiKunKortillaYlimaaraista() {
        kortti = new Maksukortti(1000);
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(760, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullistenKorttiostoEiToimiKunRahaaEiTarpeeksi() {
        kortti = new Maksukortti(10);
        assertFalse(kassa.syoEdullisesti(kortti));
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(10, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaidenKorttiostoToimiiTasarahalla() {
        kortti = new Maksukortti(400);
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaidenKorttiostoToimiiKunKortillaYlimaaraista() {
        kortti = new Maksukortti(1000);
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(600, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaidenKorttiostoEiToimiKunRahaaEiTarpeeksi() {
        kortti = new Maksukortti(300);
        assertFalse(kassa.syoMaukkaasti(kortti));
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(300, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausToimiiKunEiLadataMitaan() {
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, 0);
        assertEquals(0, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausToimiiKunLadataanRahaa() {
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(1000, kortti.saldo());
        assertEquals(101000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleEiVoiLadataNegatiivista() {
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(0, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    

    
}
