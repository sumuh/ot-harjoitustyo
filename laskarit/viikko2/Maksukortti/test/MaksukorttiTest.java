/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class MaksukorttiTest {
    
    Maksukortti kortti;
    
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        setUp();
        String vastaus = kortti.toString();
        assertEquals("Kortilla on rahaa 10.0 euroa", vastaus);
        
    }
    
    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        setUp();
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }
    
    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        setUp();
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        setUp();
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        // nyt kortin saldo on 2
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }  
    
    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi() {
        setUp();
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        // nyt kortin saldo on 2.5
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 2.5 euroa", kortti.toString());
    }  
    
    @Test
    public void kortilleVoiLadataRahaa() {
        setUp();
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }

    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        setUp();
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    
    @Test
    public void negatiivisenSummanLataaminenEiMuutaSaldoa() {
        setUp();
        kortti.lataaRahaa(-10);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    @Test
    public void kortillaVoiOstaaEdullisenKunArvoaHinnanVerran() {
        Maksukortti k = new Maksukortti(2.5);
        k.syoEdullisesti();
        assertEquals("Kortilla on rahaa 0.0 euroa", k.toString());
    }
    
    @Test
    public void kortillaVoiOstaaMaukkaanKunArvoaHinnanVerran() {
        Maksukortti k = new Maksukortti(4.0);
        k.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 0.0 euroa", k.toString());
    }
}
