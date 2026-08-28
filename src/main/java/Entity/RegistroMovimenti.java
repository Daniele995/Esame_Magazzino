package Entity;

import Database.GestorePersistenza;
import java.util.Date;
import java.util.List;

public class RegistroMovimenti {

    private GestorePersistenza gestorePersistenza;

    public RegistroMovimenti(){
        gestorePersistenza = new GestorePersistenza();
    }

    public void registraMovimento(Prodotto prodotto, String tipo, int qta, Date data, int id_Operatore){

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

            Operatore operatore = gestorePersistenza.trovaPerId(Operatore.class, (long) id_Operatore);
            Movimento movimento = new Movimento(tipo, qta, data, operatore, prodotto);
            gestorePersistenza.aggiorna(prodotto);
            gestorePersistenza.salva(movimento);
            prodotto.addMovimento(movimento);
            operatore.aggiungiMovimento(movimento);

    }

}
