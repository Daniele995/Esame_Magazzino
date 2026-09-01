import Entity.RegistroReport;
import Entity.Prodotto;
import Database.GestorePersistenza;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultaElencoProdottiWhiteBoxTest {

    private RegistroReport report;
    private GestorePersistenza gestorePersistenza;

    @BeforeEach
    public void setUp() {
        report = new RegistroReport();
        gestorePersistenza = new GestorePersistenza();
    }

    @AfterEach
    public void tearDown() {
        // Pulisco il db
        List<Prodotto> prodotti = gestorePersistenza.cercaTutti(Prodotto.class);
        for (Prodotto prod : prodotti) {
            gestorePersistenza.elimina(Prodotto.class, (long) prod.getId());
        }
    }

    @Test
    public void testCammino1_ListaNull() {
        List<String[]> risultato = report.consultaElencoProdotti();
        assertNotNull(risultato);
        assertTrue(risultato.isEmpty());
    }

    @Test
    public void testCammino2_ListaVuota() {
        List<String[]> risultato = report.consultaElencoProdotti();
        assertNotNull(risultato);
        assertTrue(risultato.isEmpty());
    }

    @Test
    public void testCammino3_ConElementi() {
        Prodotto p = new Prodotto("Biscotti", "Biscotti al burro", "alimentari", 3, "A12", 10);
        gestorePersistenza.salva(p);

        List<String[]> risultato = report.consultaElencoProdotti();
        assertNotNull(risultato);
        assertFalse(risultato.isEmpty());
        assertEquals(7, risultato.get(0).length);

    }
}
