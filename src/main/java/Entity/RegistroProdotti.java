package Entity;

import Database.GestorePersistenza;

import java.util.List;
import java.util.Objects;

public class RegistroProdotti {


    public RegistroProdotti() {
    }

    public Prodotto ricercaProdotto(int idProdotto){
        GestorePersistenza gestorePersistenza = new GestorePersistenza();
        List<Prodotto> prodotti = gestorePersistenza.cercaTutti(Prodotto.class);
        for (Prodotto p: prodotti){
            if(p.getId() == idProdotto){
                return p;
            }
        }
        return null;
    }
}
