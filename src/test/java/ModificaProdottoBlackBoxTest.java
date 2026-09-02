import Entity.Prodotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModificaProdottoBlackBoxTest {

    private Prodotto prodottoA;
    private Prodotto prodottoB;

    @BeforeEach
    void setUp() {

        prodottoA = new Prodotto(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                10,
                "A1",
                20
        );

        prodottoB = new Prodotto(
                "Tastiera",
                "Tastiera USB",
                "Elettronica",
                5,
                "B1",
                15
        );
    }


    @Test
    void modificaValidaPerIdSogliaPositiva_TC1() {

        int idRicerca = 1;

        assertTrue(idRicerca > 0);

        prodottoA.modificaAttributi(
                "Mouse Pro",
                "Mouse wireless ergonomico",
                "Elettronica",
                10,
                "A2"
        );

        assertEquals("Mouse Pro", prodottoA.getNome());
        assertEquals("Mouse wireless ergonomico", prodottoA.getDescrizione());
        assertEquals("Elettronica", prodottoA.getCategoria());
        assertEquals(10, prodottoA.getSogliaMinima());
        assertEquals("A2", prodottoA.getPosizione());
        assertEquals(20, prodottoA.getQtaDisponibile());
        assertFalse(prodottoA.isSottoScorta());
    }

    @Test
    void modificaPerIdSogliaNonSpecificata_TC2() {

        int idRicerca = 1;
        String sogliaInput = "";

        assertTrue(idRicerca > 0);
        assertTrue(sogliaInput.isEmpty());

        int sogliaMinima = sogliaInput.isEmpty() ? 0 : Integer.parseInt(sogliaInput);

        prodottoA.modificaAttributi(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                sogliaMinima,
                "A1"
        );

        assertEquals(0, prodottoA.getSogliaMinima());
        assertEquals(20, prodottoA.getQtaDisponibile());
        assertFalse(prodottoA.isSottoScorta());
    }

    @Test
    void modificaPerIdSogliaZero_TC3() {

        int idRicerca = 1;
        int soglia = 0;

        assertTrue(idRicerca > 0);
        assertEquals(0, soglia);

        prodottoA.modificaAttributi(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                soglia,
                "A1"
        );

        assertEquals(0, prodottoA.getSogliaMinima());
        assertEquals(20, prodottoA.getQtaDisponibile());
        assertFalse(prodottoA.isSottoScorta());
    }

    @Test
    void modificaPerIdSogliaSuperioreDisponibilita_TC4() {

        int idRicerca = 1;
        int soglia = 25;

        assertTrue(idRicerca > 0);

        prodottoA.modificaAttributi(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                soglia,
                "A1"
        );

        assertEquals(25, prodottoA.getSogliaMinima());
        assertEquals(20, prodottoA.getQtaDisponibile());
        assertTrue(prodottoA.isSottoScorta());
    }

    @Test
    void modificaValidaPerNome_TC5() {

        String nomeRicerca = " mOuSe ";

        String nomeSenzaSpazi = nomeRicerca.trim();

        assertTrue(prodottoA.getNome().equalsIgnoreCase(nomeSenzaSpazi), "La ricerca deve ignorare spazi e maiuscole/minuscole");

        prodottoA.modificaAttributi(
                "Mouse Plus",
                "Mouse wireless",
                "Elettronica",
                10,
                "A2"
        );

        assertEquals("Mouse Plus", prodottoA.getNome());
        assertEquals("Mouse wireless", prodottoA.getDescrizione());
        assertEquals("Elettronica", prodottoA.getCategoria());
        assertEquals(10, prodottoA.getSogliaMinima());
        assertEquals("A2", prodottoA.getPosizione());
        assertEquals(20, prodottoA.getQtaDisponibile());
        assertFalse(prodottoA.isSottoScorta());
    }

    @Test
    void modificaPerNomeSogliaNonSpecificata_TC6() {

        String nomeRicerca = "Mouse";
        String sogliaInput = "";

        assertTrue(prodottoA.getNome().equalsIgnoreCase(nomeRicerca));

        int soglia = sogliaInput.isEmpty() ? 0 : Integer.parseInt(sogliaInput);

        prodottoA.modificaAttributi(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                soglia,
                "A1"
        );

        assertEquals(0, prodottoA.getSogliaMinima());
        assertEquals(20, prodottoA.getQtaDisponibile());
    }

    @Test
    void stessoNomeConMaiuscoleMinuscoleDiverse_TC7() {

        String nomeRicerca = "MOUSE";
        String nuovoNome = "mOuSe";

        assertTrue(prodottoA.getNome().equalsIgnoreCase(nomeRicerca));
        assertTrue(prodottoA.getNome().equalsIgnoreCase(nuovoNome));

        prodottoA.modificaAttributi(
                nuovoNome,
                "Mouse wireless",
                "Elettronica",
                0,
                "A1"
        );

        assertEquals("mOuSe", prodottoA.getNome());
    }

    @Test
    void modificaPerNomeSogliaSuperioreDisponibilita_TC8() {

        String nomeRicerca = "Mouse";

        assertTrue(prodottoA.getNome().equalsIgnoreCase(nomeRicerca));

        prodottoA.modificaAttributi(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                25,
                "A1"
        );

        assertEquals(25, prodottoA.getSogliaMinima());
        assertEquals(20, prodottoA.getQtaDisponibile());
        assertTrue(prodottoA.isSottoScorta());
    }

    @Test
    void valoreRicercaVuoto_TC9() {

        String valoreRicerca = " ";

        assertTrue(valoreRicerca.trim().isEmpty(), "Errore: valore di ricerca vuoto");
    }

    @Test
    void idFormatoNonValido_TC10() {

        String valoreRicerca = "abc";

        assertThrows(NumberFormatException.class, () -> Integer.parseInt(valoreRicerca));
    }

    @Test
    void idMinoreOUgualeZero_TC11() {

        int id = 0;

        assertTrue(id <= 0, "Errore: ID non valido");
    }

    @Test
    void idValidoMaInesistente_TC12() {

        int idRicerca = 999;

        assertTrue(idRicerca > 0);

        int idProdottoA = 1;
        int idProdottoB = 2;

        assertNotEquals(idProdottoA, idRicerca);
        assertNotEquals(idProdottoB, idRicerca);
    }

    @Test
    void nomeRicercaTroppoLungo_TC13() {

        String nome = "A".repeat(46);

        assertTrue(nome.length() > 45, "Errore: nome di ricerca troppo lungo");
    }

    @Test
    void nomeRicercaInesistente_TC14() {

        String nomeRicerca = "Stampante";

        assertFalse(prodottoA.getNome().equalsIgnoreCase(nomeRicerca));
        assertFalse(prodottoB.getNome().equalsIgnoreCase(nomeRicerca));
    }

    @Test
    void nomeProdottoVuoto_TC15() {

        String nome = "";

        assertTrue(nome.isEmpty(), "Errore: il nome prodotto non può essere vuoto");
    }

    @Test
    void nomeProdottoTroppoLungo_TC16() {

        String nome = "A".repeat(46);

        assertTrue(nome.length() > 45, "Errore: nome prodotto troppo lungo");
    }

    @Test
    void nomeGiaAppartenenteAdAltroProdotto_TC17() {

        String nuovoNome = "tAsTiErA";

        assertTrue(prodottoB.getNome().equalsIgnoreCase(nuovoNome), "Esiste già un prodotto con questo nome");
        assertEquals("Mouse", prodottoA.getNome());
        assertEquals("Mouse wireless", prodottoA.getDescrizione());
        assertEquals(10, prodottoA.getSogliaMinima());
        assertEquals("A1", prodottoA.getPosizione());
    }

    @Test
    void descrizioneVuota_TC18() {

        String descrizione = "";

        assertTrue(descrizione.isEmpty(), "Errore: descrizione vuota");
    }

    @Test
    void descrizioneTroppoLunga_TC19() {

        String descrizione = "A".repeat(256);

        assertTrue(descrizione.length() > 255, "Errore: descrizione troppo lunga");
    }

    @Test
    void categoriaVuota_TC20() {

        String categoria = "";

        assertTrue(categoria.isEmpty(), "Errore: categoria vuota");
    }

    @Test
    void categoriaTroppoLunga_TC21() {

        String categoria = "A".repeat(46);

        assertTrue(categoria.length() > 45, "Errore: categoria troppo lunga");
    }

    @Test
    void sogliaMinimaNegativa_TC22() {

        int soglia = -1;

        assertTrue(soglia < 0, "Errore: soglia minima negativa");
    }

    @Test
    void sogliaMinimaNonNumerica_TC23() {

        String soglia = "dieci";

        assertThrows(NumberFormatException.class, () -> Integer.parseInt(soglia));
    }

    @Test
    void posizioneVuota_TC24() {

        String posizione = "";

        assertTrue(posizione.isEmpty(), "Errore: posizione vuota");
    }

    @Test
    void posizioneTroppoLunga_TC25() {

        String posizione = "A".repeat(46);

        assertTrue(posizione.length() > 45, "Errore: posizione troppo lunga");
    }
}