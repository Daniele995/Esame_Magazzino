package Entity;

import java.util.ArrayList;
import java.util.List;


public class Magazzino {

    private static Magazzino instance = null;

    private List<Operatore> operatori = new ArrayList<Operatore>();

    private List<Prodotto> prodotti = new ArrayList<Prodotto>();
    private Responsabile responsabile;

    private Magazzino(){
    }

    public void setResponsabile(Responsabile responsabile){
        this.responsabile = responsabile;
    }

    public Responsabile getResponsabile() {
        return responsabile;
    }

    public void aggiungiOperatore(Operatore operatore){
        operatori.add(operatore);
    }

    public void licenzia(Operatore operatore){
        operatori.remove(operatore);
    }

    public static Magazzino getInstance(){
        if (instance == null){
            instance = new Magazzino();
        }
        return instance;
    }

    public void inviaNotifica(Notifica notifica){
        this.responsabile.riceviNotifica(notifica);
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }
}
