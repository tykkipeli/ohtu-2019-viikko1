package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2 = new Varasto(-10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
//    @Test
//    public void testiJonkaTuleeAntaaVirhe() {
//        assertEquals(100, varasto.getSaldo(), vertailuTarkkuus);
//    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaEiNegatiivinenTilavuus() {
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }
    

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void NegatiivinenLisaysMahdotonta() {
        varasto.lisaaVarastoon(-10);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void EiVoiLisataLiika() {
        varasto.lisaaVarastoon(15);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
    
     @Test
    public void eiVoiOttaaNegatiivistaMaaraa() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(-2);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
    
     @Test
    public void eiVoiOttaaEnemmanKuinSaldossaOn() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(10);

        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }
    
    @Test
    public void kaksiOsainenKonstruktoriOikeaTilavuus() {
        varasto = new Varasto(10,5);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);     
    }
    
    @Test
    public void kaksiOsainenKonstruktoriOikeaSaldo() {
        varasto = new Varasto(10,5);
        assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);     
    }
    
    @Test
    public void kaksiOsainenKonstruktoriNegatiivinenTilavuus() {
        varasto = new Varasto(-10,5);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);     
    }
    
    @Test
    public void kaksiOsainenKonstruktoriNegatiivinenSaldo() {
        varasto = new Varasto(10,-5);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);     
    }
    
    @Test
    public void kaksiOsainenKonstruktoriLiianSuuriSaldo() {
        varasto = new Varasto(10,15);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);     
    }

}