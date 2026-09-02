import Controller.ControllerOperatore;
import Database.GestorePersistenza;
import Entity.Prodotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ConsultaElencoProdottiBlackBoxTest {

    private GestorePersistenza gp;

    @BeforeEach
    public void preparaAmbiente() {
        gp = new GestorePersistenza();
    }

    @AfterEach
    public void tearDown() {
        // Pulisco il db
        List<Prodotto> prodotti = gp.cercaTutti(Prodotto.class);
        for (Prodotto p : prodotti) {
            gp.elimina(p.getClass(), (long)p.getId());
        }
    }

    @Test
    public void TuttiInputValidiFiltroNonApplicato() {
        gp.salva(new Prodotto("Biscotti","Biscotti al burro", "alimentari", 3, "A12", 10));
        List<String[]> elenco = ControllerOperatore.getElencoProdotti();
        assertNotNull(elenco, "Errore: l'elenco dei prodotti restituito è null");
        assertFalse(elenco.isEmpty(), "L'elenco non deve essere vuoto per un magazzino con prodotti");
    }

    @Test
    public void TuttiInputValidiFiltroConCorrispondenza() {
        gp.salva(new Prodotto("Biscotti","Biscotti al burro", "alimentari", 3, "A12", 10));
        String categoriaEsistente = "alimentari";
        List<String[]> risultati = ControllerOperatore.getProdottiPerCategoria(categoriaEsistente);
        assertNotNull(risultati, "Il risultato non deve essere null");
        assertFalse(risultati.isEmpty(), "Il risultato non deve essere vuoto per una categoria esistente");
    }

    @Test
    public void MagazzinoVuoto() {
        List<String[]> elenco = ControllerOperatore.getElencoProdotti();
        assertTrue(elenco.isEmpty(), "Il magazzino non è vuoto");
    }

    @Test
    public void FiltroSenzaCorrispondenza() {
        gp.salva(new Prodotto("Biscotti","Biscotti al burro", "alimentari", 3, "A12", 10));
        String categoriaInesistente = "CategoriaInesistente12345";
        List<String[]> risultati = ControllerOperatore.getProdottiPerCategoria(categoriaInesistente);
        assertNotNull(risultati);
        assertTrue(risultati.isEmpty(), "Test fallito è stata trovata corrispondenza per un filtro inesistente");
    }

    @Test
    public void FiltroApplicatoMaNonInserito() {
        gp.salva(new Prodotto("Biscotti","Biscotti al burro", "alimentari", 3, "A12", 10));
        String categoriaVuota = "";
        List<String[]> risultati = ControllerOperatore.getProdottiPerCategoria(categoriaVuota);
        assertNotNull(risultati, "Il risultato non deve essere null");
        assertTrue(risultati.isEmpty(), "Test fallito: la lista deve essere vuota con filtro vuoto");
    }
}