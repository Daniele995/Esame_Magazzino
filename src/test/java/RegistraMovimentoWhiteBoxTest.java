import Database.GestorePersistenza;
import Entity.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.List;

public class RegistraMovimentoWhiteBoxTest {

    private GestorePersistenza gestorePersistenza;
    private RegistroMovimenti registroMovimenti;
    private Operatore operatoreTest;
    private Responsabile responsabileTest;
    private Prodotto prodottoNormale;
    private Prodotto prodottoSottoScorta;

    @BeforeEach
    void setUp() {
        gestorePersistenza = new GestorePersistenza();
        registroMovimenti = new RegistroMovimenti();

        operatoreTest = new Operatore("Ettore", "Opera", "e@mail.com");
        gestorePersistenza.salva(operatoreTest);

        responsabileTest = new Responsabile("Respo", "Stabile", "Re@mail.com");
        gestorePersistenza.salva(responsabileTest);

        prodottoNormale = new Prodotto("P1", "D1", "C1", 10, "P1", 20);
        gestorePersistenza.salva(prodottoNormale);

        prodottoSottoScorta = new Prodotto("P2", "D2", "C2", 10, "P2", 5);
        gestorePersistenza.salva(prodottoSottoScorta);
    }

    @AfterEach
    void tearDown() {
        for (Notifica n : gestorePersistenza.cercaTutti(Notifica.class)) { gestorePersistenza.elimina(n.getClass(),(long)n.getId()); }
        for (Movimento m : gestorePersistenza.cercaTutti(Movimento.class)) { gestorePersistenza.elimina(m.getClass(),(long)m.getMovimento_id()); }

        gestorePersistenza.elimina(prodottoNormale.getClass(),(long)prodottoNormale.getId());
        gestorePersistenza.elimina(prodottoSottoScorta.getClass(),(long)prodottoSottoScorta.getId());
        gestorePersistenza.elimina(operatoreTest.getClass(),(long) operatoreTest.getId());
        gestorePersistenza.elimina(responsabileTest.getClass(),(long)responsabileTest.getId());
    }

    @Test
    void testCaricoRipristinoScorta_TC1() {
        registroMovimenti.registraMovimento(prodottoSottoScorta, "carico", 10, new Date(), operatoreTest.getId());

        assertEquals(15, prodottoSottoScorta.getQtaDisponibile());
        assertFalse(prodottoSottoScorta.isSottoScorta());
    }

    @Test
    void testCaricoRestaSottoScorta_TC2(){
        registroMovimenti.registraMovimento(prodottoSottoScorta, "carico", 1, new Date(), operatoreTest.getId());

        assertEquals(6,prodottoSottoScorta.getQtaDisponibile());
        assertTrue(prodottoSottoScorta.isSottoScorta());
    }

    @Test
    void testScaricoStandard_TC3() {
        registroMovimenti.registraMovimento(prodottoNormale, "scarico", 5, new Date(), operatoreTest.getId());

        assertEquals(15, prodottoNormale.getQtaDisponibile());
        assertFalse(prodottoNormale.isSottoScorta());

        List<Movimento> movimenti = gestorePersistenza.cercaTutti(Movimento.class);
        assertEquals(1, movimenti.size());
    }

    @Test
    void testScaricoSottoScorta_TC4() {
        registroMovimenti.registraMovimento(prodottoNormale, "scarico", 15, new Date(), operatoreTest.getId());

        assertEquals(5, prodottoNormale.getQtaDisponibile());
        assertTrue(prodottoNormale.isSottoScorta());

        List<Notifica> notifiche = gestorePersistenza.cercaTutti(Notifica.class);
        assertEquals(1, notifiche.size());
    }

    @Test
    void testScaricoSottoScortaSenzaResponsabili_TC5() {

        gestorePersistenza.elimina(responsabileTest.getClass(),(long)responsabileTest.getId());

        registroMovimenti.registraMovimento(prodottoNormale, "scarico", 15, new Date(), operatoreTest.getId());

        assertEquals(5, prodottoNormale.getQtaDisponibile());
        assertTrue(prodottoNormale.isSottoScorta());

        List<Notifica> notifiche = gestorePersistenza.cercaTutti(Notifica.class);
        assertEquals(0, notifiche.size());

        List<Movimento> movimenti = gestorePersistenza.cercaTutti(Movimento.class);
        assertEquals(1, movimenti.size());
    }

}