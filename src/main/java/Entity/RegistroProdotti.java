package Entity;

import Database.GestorePersistenza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public boolean validaDati(String nome) {

        Map<String, Object> campi = new HashMap<>();
        campi.put("nome", nome);

        List<Prodotto> prodotti =
                gestorePersistenza.cercaPerCampi(
                        Prodotto.class,
                        campi
                );

        return prodotti.isEmpty();
    }

    public boolean creaProdotto(
            String nome,
            String descrizione,
            String categoria,
            int sogliaMinima,
            String posizione) {

        int qtaDisponibile = 0;

        Prodotto prodotto = new Prodotto(
                nome,
                descrizione,
                categoria,
                sogliaMinima,
                posizione,
                qtaDisponibile
        );

        return gestorePersistenza.salva(prodotto);
    }

}
