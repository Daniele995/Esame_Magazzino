package Entity;

import java.util.Objects;

public class RegistroProdotti {
    private Magazzino magazzino = Magazzino.getInstance();


    public RegistroProdotti() {
    }

    public Prodotto ricercaProdotto(int idProdotto){
        for (Prodotto p: magazzino.getProdotti()){
            if(Objects.equals(p.getId(), idProdotto)){
                return p;
            }
        }
        return  null;
    }
}
