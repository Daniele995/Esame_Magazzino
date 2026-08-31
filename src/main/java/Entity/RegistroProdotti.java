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
            if(p.getId() == idProdotto){return p;}
        }
        return null;
    }

    public Prodotto ricercaProdotto(String nomeProdotto) {
        List<Prodotto> prodotti = gestorePersistenza.cercaTutti(Prodotto.class);
        for (Prodotto p : prodotti) {
            if (p.getNome().equalsIgnoreCase(nomeProdotto)) {return p;}
        }
        return null;
    }

    public boolean validaDati(String nome) {
        List<Prodotto> prodotti = gestorePersistenza.cercaTutti(Prodotto.class);
        for (Prodotto p : prodotti) {
            if (p.getNome().equalsIgnoreCase(nome)) {return false;}
        }
        return true;
    }

    public boolean creaProdotto(
            String nome,
            String descrizione,
            String categoria,
            int sogliaMinima,
            String posizione) {

        Prodotto prodotto = new Prodotto(
                nome,
                descrizione,
                categoria,
                sogliaMinima,
                posizione,
                0
        );

        return gestorePersistenza.salva(prodotto);
    }

    public boolean validaNomeModifica(int idProdotto, String nome) {
        List<Prodotto> prodotti = gestorePersistenza.cercaTutti(Prodotto.class);
        for (Prodotto p : prodotti) {
            if (p.getNome().equalsIgnoreCase(nome) && p.getId() != idProdotto) {return false;}
        }
        return true;
    }

    public boolean modificaProdotto(
            int idProdotto,
            String nome,
            String descrizione,
            String categoria,
            int sogliaMinima,
            String posizione) {

        Prodotto prodotto = ricercaProdotto(idProdotto);
        if (prodotto == null) {return false;}
        prodotto.modificaAttributi(nome, descrizione, categoria, sogliaMinima, posizione);

        try {
            gestorePersistenza.aggiorna(prodotto);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

}
