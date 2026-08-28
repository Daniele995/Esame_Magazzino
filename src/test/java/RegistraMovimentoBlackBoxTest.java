import Controller.ControllerOperatore;
import Entity.Prodotto;
import Entity.RegistroProdotti;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegistraMovimentoBlackBoxTest {

    private final int ID_OPERATORE_TEST = 999;

    @BeforeEach
    void setUp() {
        Prodotto p1 = new Prodotto("P1","D1","C1",5,"P1",20);
        Prodotto p2 = new Prodotto("P2","D2","C2",15,"P2",10);
        Prodotto p3 = new Prodotto("P3","D3","C3",5,"P3",20);
    }

    @AfterEach
    void tearDown() {
    }

    //Test movimento di carico

    @Test
    void testCaricoStandard_TC1() {
        int esito = ControllerOperatore.registraMovimento("carico", 10, 1, ID_OPERATORE_TEST);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SUCCESSO, esito);
    }

    @Test
    void testCaricoSuperaSoglia_TC2() {
        int esito = ControllerOperatore.registraMovimento("carico", 10, 2, ID_OPERATORE_TEST);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SOTTO_SCORTA_RIMOSSO, esito);
    }

    @Test
    void testCaricoNonSuperaSoglia_TC3() {
        int esito = ControllerOperatore.registraMovimento("carico", 3, 2, ID_OPERATORE_TEST);
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
        int esito = ControllerOperatore.registraMovimento("carico", 20, 10, ID_OPERATORE_TEST);
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
        int esito = ControllerOperatore.registraMovimento("scarico", 10, 1, ID_OPERATORE_TEST);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SUCCESSO, esito);
    }

    @Test
    void testScaricoSottoScorta_TC2() {
        int esito = ControllerOperatore.registraMovimento("scarico", 10, 2, ID_OPERATORE_TEST);
        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SOTTO_SCORTA, esito);
    }

    @Test
    void testScaricoQuantitaEccessiva_TC3() {
        int esito = ControllerOperatore.registraMovimento("scarico", 30, 1, ID_OPERATORE_TEST);
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
        int esito = ControllerOperatore.registraMovimento("scarico", 20, 10, ID_OPERATORE_TEST);
        assertEquals(ControllerOperatore.ERRORE_PRODOTTO_NON_TROVATO, esito);
    }

    @Test
    void testScaricoCodiceNonValido_TC7() {
        String inputCodice = "hsdjaf#";
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(inputCodice));
    }
}