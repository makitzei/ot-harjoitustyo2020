package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa!=null);
    }
    
    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);
    }
    
    @Test
    public void konstruktoriAsettaaAlkusaldonOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void konstruktoriAsettaaEdullisetNollaan() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void konstruktoriAsettaaMaukkaatNollaan() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenLounasKasvattaaSaldoaOikein() {
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassanSaldoEiMuutuKunRahatEiRiitaEdulliseen() {
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukasLounasKasvattaaSaldoaOikein() {
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassanSaldoEiMuutuKunRahatEiRiitaMaukkaaseen() {
        kassa.syoMaukkaasti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullinenLounasVaihtorahaOikein() {
        assertEquals(60, kassa.syoEdullisesti(300));
    }
    
    @Test
    public void rahatTakaisinKunRahatEiRiitaEdulliseen() {
        assertEquals(200,kassa.syoEdullisesti(200));
    }
    
    @Test
    public void maukasLounasVaihtorahaOikein() {
        assertEquals(100, kassa.syoMaukkaasti(500));
    }
    
    @Test
    public void rahatTakaisinKunRahatEiRiitaMaukkaaseen() {
        assertEquals(300,kassa.syoMaukkaasti(300));
    }
    
    @Test
    public void edullinenLounasLisataanMyytyihin() {
        kassa.syoEdullisesti(300);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullisetMyydytEiKasvaKunRahaEiRiita() {
        kassa.syoEdullisesti(200);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasLounasLisataanMyytyihin() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukkaatMyydytEiKasvaKunRahaEiRiita() {
        kassa.syoMaukkaasti(200);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    //Maksukortin käyttöön liittyvät testit
    @Test
    public void edullinenLounasKortillaPalauttaaTrue() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }
    
    public void edullinenLounasKortillaPalauttaaFalseKunRahaaLiianVahan() {
        kassa.syoEdullisesti(kortti); //kortin saldo nyt 260
        kassa.syoEdullisesti(kortti); //kortin saldo nyt 20
        assertEquals(false, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void edullinenLounasVahentaaMaksukortinSaldoaOikein() {
        kassa.syoEdullisesti(kortti);
        assertEquals(260, kortti.saldo());
    }
    
    @Test
    public void edullinenLounasEiVahennaKortiltaKunRahaaLiianVahan() {
        kassa.syoEdullisesti(kortti); //saldo 260
        kassa.syoEdullisesti(kortti); //saldo 20
        kassa.syoEdullisesti(kortti); //saldon ei pitäisi muuttua
        assertEquals(20, kortti.saldo());
    }
    
    @Test
    public void edullinenLounasKortillaLisaaMyytyjenMaaraa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullinenLounasKortillaEiLisaaMyytyjaKunRahaEiRiita() {
        kassa.syoEdullisesti(kortti); // 1 kpl
        kassa.syoEdullisesti(kortti); // 2 kpl
        kassa.syoEdullisesti(kortti); // 2 kpl
        kassa.syoEdullisesti(kortti); // 2 kpl
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasLounasKortillaPalauttaaTrue() {
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    
    public void maukasLounasKortillaPalauttaaFalseKunRahaaLiianVahan() {
        kassa.syoMaukkaasti(kortti); //kortin saldo nyt 100
        assertFalse(kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void maukasLounasVahentaaMaksukortinSaldoaOikein() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void maukasLounasEiVahennaKortiltaKunRahaaLiianVahan() {
        kassa.syoMaukkaasti(kortti); //saldo 100
        kassa.syoMaukkaasti(kortti); //saldon ei pitäisi muuttua
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void maukasLounasKortillaLisaaMyytyjenMaaraa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maukasLounasKortillaEiLisaaMyytyjaKunRahaEiRiita() {
        kassa.syoMaukkaasti(kortti); // 1 kpl
        kassa.syoMaukkaasti(kortti); // 1 kpl
        kassa.syoMaukkaasti(kortti); // 1 kpl
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortinLataaminenKasvattaaKortinSaldoa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void kortinLataaminenKasvattaaKassanSaldoa() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLataaminenNegatiivisellaEiKasvataKassanSaldoa() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
}
