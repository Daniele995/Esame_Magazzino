import Controller.ControllerOperatore;
import Database.GestorePersistenza;
import Entity.Movimento;
import Entity.Operatore;
import Entity.Prodotto;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RegistraMovimentoBlackBoxTest {

    private GestorePersistenza gp;
    private Prodotto prodottoStandard;
    private Prodotto prodottoSottoScorta;
    private Operatore operatoreTest;

    @BeforeEach
    void setUp() {
        gp = new GestorePersistenza();

        operatoreTest = new Operatore("Nome", "Cognome", "e@mail.com");
        gp.salva(operatoreTest);

        prodottoStandard = new Prodotto("P1", "D1", "C1", 5, "P1", 20);
        gp.salva(prodottoStandard);

        prodottoSottoScorta = new Prodotto("P2", "D2", "C2", 10, "P2", 5);
        gp.salva(prodottoSottoScorta);
    }

    @AfterEach
    void tearDown() {
        List<Movimento> movimenti = gp.cercaTutti(Movimento.class);
        for (Movimento m : movimenti) {
            gp.elimina(m.getClass(),(long)m.getMovimento_id());
        }
        gp.elimina(prodottoStandard.getClass(),(long)prodottoStandard.getId());
        gp.elimina(prodottoSottoScorta.getClass(),(long)prodottoSottoScorta.getId());
        gp.elimina(operatoreTest.getClass(),(long)operatoreTest.getId());
    }

    //Test movimento di carico

    @Test
    void testCaricoStandard_TC1() {
        int idProd = prodottoStandard.getId();
        int idOp = operatoreTest.getId();
        int esito = ControllerOperatore.registraMovimento("carico", 10, idProd, idOp);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SUCCESSO, esito);
    }

    @Test
    void testCaricoSuperaSoglia_TC2() {
        int idProd = prodottoSottoScorta.getId();
        int idOp = operatoreTest.getId();
        int esito = ControllerOperatore.registraMovimento("carico", 10, idProd, idOp);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SOTTO_SCORTA_RIMOSSO, esito);
    }

    @Test
    void testCaricoNonSuperaSoglia_TC3() {
        int idProd = prodottoSottoScorta.getId();
        int idOp = operatoreTest.getId();
        int esito = ControllerOperatore.registraMovimento("carico", 3, idProd, idOp);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SOTTO_SCORTA, esito);
    }

    @Test
    void testCaricoQuantitaNegativa_TC4() {
        int quantita = -10;
        assertTrue(quantita <= 0, "Errore: quantità negativa");
    }

    @Test
    void testCaricoQuantitaNonNumerica_TC5() {
        String inputQuantita = "dieci";
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(inputQuantita));
    }

    @Test
    void testCaricoProdottoInesistente_TC6() {
        int idOp = operatoreTest.getId();
        int esito = ControllerOperatore.registraMovimento("carico", 20, 10, idOp);
        assertEquals(ControllerOperatore.ERRORE_PRODOTTO_NON_TROVATO, esito);
    }

    @Test
    void testCaricoCodiceNonValido_TC7() {
        String inputCodice = "hsdjaf#";
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(inputCodice));
    }

    //Test movimento di scarico

    @Test
    void testScaricoStandard_TC1() {
        int idProd = prodottoStandard.getId();
        int idOp = operatoreTest.getId();
        int esito = ControllerOperatore.registraMovimento("scarico", 10, idProd, idOp);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SUCCESSO, esito);
    }

    @Test
    void testScaricoSottoScorta_TC2() {
        int idProd = prodottoSottoScorta.getId();
        int idOp = operatoreTest.getId();
        int esito = ControllerOperatore.registraMovimento("scarico", 4, idProd, idOp);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SOTTO_SCORTA, esito);
    }

    @Test
    void testScaricoQuantitaEccessiva_TC3() {
        int idProd = prodottoStandard.getId();
        int idOp = operatoreTest.getId();
        int esito = ControllerOperatore.registraMovimento("scarico", 30, idProd,idOp);
        assertEquals(ControllerOperatore.ERRORE_QUANTITA_INSUFFICIENTE, esito);
    }

    @Test
    void testScaricoQuantitaNegativa_TC4() {
        int quantita = -10;
        assertTrue(quantita <= 0, "Errore: quantità negativa");
    }

    @Test
    void testScaricoQuantitaNonNumerica_TC5() {
        String inputQuantita = "dieci";
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(inputQuantita));
    }

    @Test
    void testScaricoProdottoInesistente_TC6() {
        int idOp = operatoreTest.getId();
        int esito = ControllerOperatore.registraMovimento("scarico", 20, 10, idOp);
        assertEquals(ControllerOperatore.ERRORE_PRODOTTO_NON_TROVATO, esito);
    }

    @Test
    void testScaricoCodiceNonValido_TC7() {
        String inputCodice = "hsdjaf#";
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(inputCodice));
    }
}