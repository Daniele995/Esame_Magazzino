package Entity;

import Database.GestorePersistenza;
import java.util.Date;
import java.util.List;

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

            if(tipo.equals("scarico") && prodotto.getQtaDisponibile() < prodotto.getSogliaMinima()){
                prodotto.setSottoscorta(true);

                List<Responsabile> listaResponsabili = GestoreUtenti.listaResponsabili();

                for(Responsabile resp: listaResponsabili){
                    Notifica notifica = new Notifica("Il prodotto con ID "+ prodotto.getId()+ " è sotto scorta",resp);
                    gestorePersistenza.salva(notifica);
                }
            } else if(tipo.equals("carico") && prodotto.getQtaDisponibile() >= prodotto.getSogliaMinima()){
                prodotto.setSottoscorta(false);
            }

            Movimento movimento = new Movimento(tipo, qta, data, operatore, prodotto);
            gestorePersistenza.aggiorna(prodotto);
            gestorePersistenza.salva(movimento);
            prodotto.addMovimento(movimento);
            operatore.aggiungiMovimento(movimento);

        }
        return true;

    }

}
