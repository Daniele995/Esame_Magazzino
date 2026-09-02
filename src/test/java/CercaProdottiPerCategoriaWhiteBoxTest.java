import Entity.RegistroProdotti;
import Entity.Prodotto;
import Database.GestorePersistenza;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CercaProdottiPerCategoriaWhiteBoxTest {

    private RegistroProdotti registro;
    private GestorePersistenza gestorePersistenza;

    @BeforeEach
    public void setUp() {
        registro = new RegistroProdotti();
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
    public void testCammino2_ListaVuota() {
        List<String[]> risultato = registro.cercaProdottiPerCategoria("alimentari");
        assertNotNull(risultato);
        assertTrue(risultato.isEmpty());
    }

    @Test
    public void testCammino3_CategoriaProdottoNull() {
        Prodotto p = new Prodotto("ProdottoCatNull", "Descrizione", null, 3, "A12", 10);
        gestorePersistenza.salva(p);

        List<String[]> risultato = registro.cercaProdottiPerCategoria("alimentari");
        assertNotNull(risultato);
        assertTrue(risultato.isEmpty());

    }

    @Test
    public void testCammino4_CategoriaDiversa() {
        Prodotto p = new Prodotto("Computer", "Descrizione", "elettronica", 1, "B1", 5);
        gestorePersistenza.salva(p);

        List<String[]> risultato = registro.cercaProdottiPerCategoria("alimentari");
        assertNotNull(risultato);
        assertTrue(risultato.isEmpty());

    }

    @Test
    public void testCammino5_CategoriaCorrispondente() {
        Prodotto p = new Prodotto("Biscotti", "Descrizione", "alimentari", 3, "A12", 10);
        gestorePersistenza.salva(p);

        List<String[]> risultato = registro.cercaProdottiPerCategoria("alimentari");
        assertNotNull(risultato);
        assertFalse(risultato.isEmpty());
        assertEquals(1, risultato.size());
        assertEquals("alimentari", risultato.get(0)[3]);

    }
}
