package Entity;

import Database.GestorePersistenza;

import java.util.ArrayList;
import java.util.List;

public class RegistroProdotti {

    private GestorePersistenza gestorePersistenza;

    public RegistroProdotti() {
        gestorePersistenza = new GestorePersistenza();
    }

    public List<String[]> cercaProdottiPerCategoria(String categoriaCercata) {
        List<String[]> elencoFiltrato = new ArrayList<>();
        // Recupero tutti i prodotti
        List<Prodotto> listaProdotti = gestorePersistenza.cercaTutti(Prodotto.class);

        if (listaProdotti != null) {
            for (Prodotto p : listaProdotti) {

                if (p.getCategoria() != null && p.getCategoria().equals(categoriaCercata)) {
                    String[] riga = {
                            String.valueOf(p.getId()),
                            p.getNome(),
                            p.getDescrizione(),
                            p.getCategoria(),
                            String.valueOf(p.getSogliaMinima()),
                            p.getPosizione(),
                            String.valueOf(p.getQtaDisponibile())
                    };
                    elencoFiltrato.add(riga);
                }
            }
        }
        return elencoFiltrato;
    }

    public Prodotto ricercaProdotto(int idProdotto){
        List<Prodotto> prodotti = gestorePersistenza.cercaTutti(Prodotto.class);
        for (Prodotto p: prodotti){
            if(p.getId() == idProdotto){
                return p;
            }
        }
        return null;
    }
}
