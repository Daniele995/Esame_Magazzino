package Entity;

import java.util.ArrayList;
import java.util.Date;

public class RegistroMovimenti {
    public ArrayList<Movimento> registroMovimenti = new ArrayList<Movimento>();
    Magazzino magazzino = Magazzino.getInstance();
    Responsabile responsabile = magazzino.getResponsabile();

    public void RegistraMovimento(int id, Prodotto prodotto, String tipo, int qta, Date data, Utente utente){
        if (tipo.equals("scarico") && qta > prodotto.getQtaDisponibile()){
            System.out.println("Errore: scorte insufficienti");
        } else {
            if (tipo.equals("scarico")) qta *= (-1);
            prodotto.aggiornaQta(qta);
            Movimento movimento = new Movimento(id, tipo, qta, data, (Operatore) utente, prodotto);
            registroMovimenti.add(movimento);

            if(tipo.equals("scarico") && prodotto.getQtaDisponibile() < prodotto.getSogliaMinima()){
                prodotto.setSottoscorta(true);
                Notifica notifica = new Notifica("prodotto sotto scorta",this.responsabile);
                magazzino.inviaNotifica(notifica);
            }
        }

    }

}
