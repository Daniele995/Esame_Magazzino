package Entity;

import Database.GestorePersistenza;

import java.util.ArrayList;
import java.util.List;

public class RegistroReport {

    private GestorePersistenza gestorePersistenza;


    public RegistroReport() {gestorePersistenza = new GestorePersistenza();}


    public List<String[]> consultaElencoProdotti() {
        List<String[]> elencoProdotti = new ArrayList<>();

        // Recupero la lista dei prodotti
        List<Prodotto> listaProdotti = gestorePersistenza.cercaTutti(Prodotto.class); // Nodo 1 CFG

        if (listaProdotti != null) {   //Nodo 2
            for (Prodotto p : listaProdotti) { //Nodo 3
                // Array di stringhe con i campi da mostrare nella tabella
                String[] riga = {String.valueOf(p.getId()),
                        p.getNome(),
                        p.getDescrizione(),
                        p.getCategoria(),
                        String.valueOf(p.getSogliaMinima()),
                        p.getPosizione(),
                        String.valueOf(p.getQtaDisponibile())
                };
                elencoProdotti.add(riga); //Nodo 4
            }
        }

        return elencoProdotti; //Nodo 5
    }
}
