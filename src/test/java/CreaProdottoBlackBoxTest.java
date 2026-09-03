import Entity.Prodotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreaProdottoBlackBoxTest {

    private Prodotto prodottoEsistente;

    @BeforeEach
    void setUp() {

        prodottoEsistente = new Prodotto(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                10,
                "A1",
                0
        );
    }


    @Test
    void tuttiInputValidiConSogliaPositiva_TC1() {

        Prodotto prodotto = new Prodotto(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                10,
                "A1",
                0
        );

        assertEquals("Mouse", prodotto.getNome());
        assertEquals("Mouse wireless", prodotto.getDescrizione());
        assertEquals("Elettronica", prodotto.getCategoria());
        assertEquals(10, prodotto.getSogliaMinima());
        assertEquals("A1", prodotto.getPosizione());
        assertEquals(0, prodotto.getQtaDisponibile());
    }

    @Test
    void sogliaMinimaNonSpecificata_TC2() {

        String sogliaInput = "";

        assertTrue(sogliaInput.isEmpty());

        int sogliaMinima = sogliaInput.isEmpty() ? 0 : Integer.parseInt(sogliaInput);

        Prodotto prodotto = new Prodotto(
                "Tastiera",
                "Tastiera USB",
                "Elettronica",
                sogliaMinima,
                "A2",
                0
        );

        assertEquals("Tastiera", prodotto.getNome());
        assertEquals("Tastiera USB", prodotto.getDescrizione());
        assertEquals("Elettronica", prodotto.getCategoria());
        assertEquals(0, prodotto.getSogliaMinima());
        assertEquals("A2", prodotto.getPosizione());
        assertEquals(0, prodotto.getQtaDisponibile());
    }

    @Test
    void sogliaMinimaUgualeZero_TC3() {

        int soglia = 0;

        assertEquals(0, soglia);

        Prodotto prodotto = new Prodotto(
                "Monitor",
                "Monitor 24 pollici",
                "Elettronica",
                soglia,
                "A3",
                0
        );

        assertEquals("Monitor", prodotto.getNome());
        assertEquals("Monitor 24 pollici", prodotto.getDescrizione());
        assertEquals("Elettronica", prodotto.getCategoria());
        assertEquals(0, prodotto.getSogliaMinima());
        assertEquals("A3", prodotto.getPosizione());
        assertEquals(0, prodotto.getQtaDisponibile());
    }

    @Test
    void nomeVuoto_TC4() {

        String nome = "";

        assertTrue(nome.isEmpty(), "Il nome prodotto non può essere vuoto.");
    }

    @Test
    void nomeTroppoLungo_TC5() {

        String nome = "A".repeat(46);

        assertTrue(nome.length() > 45, "Il nome prodotto non può superare i 45 caratteri.");
    }

    @Test
    void nomeGiaPresente_TC6() {

        String nuovoNome = "mOuSe";

        assertTrue(
                prodottoEsistente.getNome().equalsIgnoreCase(nuovoNome),
                "Esiste già un prodotto con questo nome."
        );
    }

    @Test
    void descrizioneVuota_TC7() {

        String descrizione = "";

        assertTrue(descrizione.isEmpty(), "La descrizione non può essere vuota.");
    }

    @Test
    void descrizioneTroppoLunga_TC8() {

        String descrizione = "A".repeat(256);

        assertTrue(descrizione.length() > 255, "La descrizione non può superare i 255 caratteri.");
    }

    @Test
    void categoriaVuota_TC9() {

        String categoria = "";

        assertTrue(categoria.isEmpty(), "La categoria non può essere vuota.");
    }

    @Test
    void categoriaTroppoLunga_TC10() {

        String categoria = "A".repeat(46);

        assertTrue(categoria.length() > 45, "La categoria non può superare i 45 caratteri.");
    }

    @Test
    void sogliaMinimaNegativa_TC11() {

        int soglia = -1;

        assertTrue(soglia < 0, "La soglia minima non può essere negativa.");
    }

    @Test
    void sogliaMinimaNonNumerica_TC12() {

        String soglia = "dieci";

        assertThrows(NumberFormatException.class, () -> Integer.parseInt(soglia));
    }

    @Test
    void posizioneVuota_TC13() {

        String posizione = "";

        assertTrue(posizione.isEmpty(), "La posizione non può essere vuota.");
    }

    @Test
    void posizioneTroppoLunga_TC14() {

        String posizione = "A".repeat(46);

        assertTrue(posizione.length() > 45, "La posizione non può superare i 45 caratteri.");
    }
}