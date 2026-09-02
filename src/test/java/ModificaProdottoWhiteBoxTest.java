import Database.GestorePersistenza;
import Entity.*;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class ModificaProdottoWhiteBoxTest {

    private GestorePersistenza gestorePersistenza;
    private RegistroProdotti registroProdotti;
    private Prodotto prodottoTest;

    @BeforeEach
    void setUp() {

        gestorePersistenza = new GestorePersistenza();
        registroProdotti = new RegistroProdotti();

        prodottoTest = new Prodotto(
                "Mouse",
                "Mouse wireless",
                "Elettronica",
                10,
                "A1",
                20
        );

        gestorePersistenza.salva(prodottoTest);
    }

    @AfterEach
    void tearDown() {gestorePersistenza.elimina(prodottoTest.getClass(), (long) prodottoTest.getId());}

    @Test
    void testProdottoInesistente_TC1() {
        boolean esito = registroProdotti.modificaProdotto(
                999,
                "Mouse Pro",
                "Mouse aggiornato",
                "Elettronica",
                10,
                "A2"
        );
        assertFalse(esito);
    }

    @Test
    void testModificaProdottoRiuscita_TC2() {
        boolean esito = registroProdotti.modificaProdotto(
                prodottoTest.getId(),
                "Mouse Pro",
                "Mouse wireless aggiornato",
                "Elettronica",
                10,
                "A2"
        );

        assertTrue(esito);

        Prodotto prodottoModificato = registroProdotti.ricercaProdotto(prodottoTest.getId());

        assertNotNull(prodottoModificato);
        assertEquals("Mouse Pro", prodottoModificato.getNome());
        assertEquals("Mouse wireless aggiornato", prodottoModificato.getDescrizione());
        assertEquals("Elettronica", prodottoModificato.getCategoria());
        assertEquals(10, prodottoModificato.getSogliaMinima());
        assertEquals("A2", prodottoModificato.getPosizione());
        assertEquals(20, prodottoModificato.getQtaDisponibile());
    }

    @Test
    void testErroreDuranteAggiornamento_TC3() throws Exception {
        GestorePersistenza gestoreConErrore =
                new GestorePersistenza() {

                    @Override
                    public <T> T aggiorna(T oggetto) {throw new RuntimeException("Errore simulato durante l'aggiornamento");}
                };

        Field campoGestorePersistenza = RegistroProdotti.class.getDeclaredField("gestorePersistenza");

        campoGestorePersistenza.setAccessible(true);

        campoGestorePersistenza.set(registroProdotti, gestoreConErrore);

        boolean esito = registroProdotti.modificaProdotto(
                prodottoTest.getId(),
                "Mouse Pro",
                "Mouse wireless aggiornato",
                "Elettronica",
                10,
                "A2"
        );

        assertFalse(esito);

        RegistroProdotti registroVerifica = new RegistroProdotti();

        Prodotto prodottoDopoErrore = registroVerifica.ricercaProdotto(prodottoTest.getId());

        assertNotNull(prodottoDopoErrore);

        assertEquals("Mouse", prodottoDopoErrore.getNome());

        assertEquals("Mouse wireless", prodottoDopoErrore.getDescrizione());

        assertEquals("A1", prodottoDopoErrore.getPosizione());
    }
}
