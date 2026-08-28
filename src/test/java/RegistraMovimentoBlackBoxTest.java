import Controller.ControllerOperatore;
import Database.GestorePersistenza;
import Entity.Operatore;
import Entity.Prodotto;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegistraMovimentoBlackBoxTest {
    @BeforeEach
    void setUp(){

        Prodotto prodotto = new Prodotto(999,"NomeProdotto","DescrizioneProdotto","Categoria",50,"Posizione",50);
        Operatore operatore = new Operatore("Nome","Cognome","e@mail.com");

    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void testCaricoValido() {
        int esito = ControllerOperatore.registraMovimento("carico", 10, 999, 999);

        assertEquals(ControllerOperatore.MOVIMENTO_REGISTRATO_SUCCESSO, esito);
    }

    @Test
    void testScaricoInvalidoPerQuantita() {
        int esito = ControllerOperatore.registraMovimento("scarico", 100, 999, 999);

        assertEquals(ControllerOperatore.ERRORE_QUANTITA_INSUFFICIENTE, esito);
    }

    @Test
    void testProdottoInesistente() {
        int esito = ControllerOperatore.registraMovimento("carico", 10, -5, 999);

        assertEquals(-2, esito);
    }
}
