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
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(90);
        assertEquals("saldo: 1.0", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeKunOnTarpeeksiRahaa() {
        kortti.lataaRahaa(90);
        kortti.otaRahaa(40);
        assertEquals("saldo: 0.60", kortti.toString());
    }
    
    @Test
    public void saldoEiVaheneKunEiOleTarpeeksiRahaa() {
        kortti.otaRahaa(40);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void palauttaaTrueKunRahatRiittavat() {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void palauttaaFalseKunRahatEivatRiita() {
        assertEquals(false, kortti.otaRahaa(15));
    }
    
}
