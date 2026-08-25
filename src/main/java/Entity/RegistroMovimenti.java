package Entity;

import Database.GestorePersistenza;

import java.util.ArrayList;
import java.util.Date;

public class RegistroMovimenti {

    private GestorePersistenza gestorePersistenza;

    public RegistroMovimenti(){
        gestorePersistenza = new GestorePersistenza();
    }

    public boolean registraMovimento(int id_prodotto, String tipo, int qta, Date data, int id_Operatore){

        Prodotto prodotto = gestorePersistenza.trovaPerId(Prodotto.class, (long) id_prodotto);
        Operatore operatore = gestorePersistenza.trovaPerId(Operatore.class, (long) id_Operatore);
        if (prodotto == null){
            System.out.println("Errore: Prodotto non trovato nel DB");
            return false;
        }

        if (tipo.equals("scarico") && qta > prodotto.getQtaDisponibile()){
            return false;
        } else {
            if (tipo.equals("scarico")) qta *= (-1);
            prodotto.aggiornaQta(qta);
            Movimento movimento = new Movimento(tipo, qta, data, operatore, prodotto);
            gestorePersistenza.aggiorna(prodotto);
            gestorePersistenza.salva(movimento);
            prodotto.addMovimento(movimento);
            operatore.aggiungiMovimento(movimento);



            if(tipo.equals("scarico") && prodotto.getQtaDisponibile() < prodotto.getSogliaMinima()){
                prodotto.setSottoscorta(true);
                Notifica notifica = new Notifica("prodotto sotto scorta",Magazzino.getInstance().getResponsabile());
                gestorePersistenza.salva(notifica);
               // Magazzino.getInstance().inviaNotifica(notifica);
            }
        }
        return true;

    }
}
