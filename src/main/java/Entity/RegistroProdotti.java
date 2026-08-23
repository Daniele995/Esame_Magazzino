package Entity;

public class RegistroProdotti {
    private Magazzino magazzino = Magazzino.getInstance();


    public RegistroProdotti() {
    }

    public Prodotto ricercaProdotto(int idProdotto){
        for (Prodotto p: magazzino.getProdotti()){
            if(p.getId() == idProdotto){
                return p;
            }
        }
        return  null;
    }
}
