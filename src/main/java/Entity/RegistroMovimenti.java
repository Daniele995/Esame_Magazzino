package Entity;

import java.util.ArrayList;
import java.util.Date;

public class RegistroMovimenti {
    public ArrayList<Movimento> registroMovimenti = new ArrayList<Movimento>();
    Magazzino magazzino = Magazzino.getInstance();
    Responsabile responsabile = magazzino.getResponsabile();

    public boolean registraMovimento(int id_Movimento, int id_prodotto, String tipo, int qta, Date data, Operatore operatore){

        RegistroProdotti registroProdotti = new RegistroProdotti();
        Prodotto prodotto = registroProdotti.ricercaProdotto(id_prodotto);

        if (tipo.equals("scarico") && qta > prodotto.getQtaDisponibile()){
            return false;
        } else {
            if (tipo.equals("scarico")) qta *= (-1);
            prodotto.aggiornaQta(qta);
            Movimento movimento = new Movimento(id_Movimento, tipo, qta, data, operatore, prodotto);
            registroMovimenti.add(movimento);
            operatore.aggiungiMovimento(movimento);

            if(tipo.equals("scarico") && prodotto.getQtaDisponibile() < prodotto.getSogliaMinima()){
                prodotto.setSottoscorta(true);
                Notifica notifica = new Notifica("prodotto sotto scorta",this.responsabile);
                magazzino.inviaNotifica(notifica);
            }
        }
        return true;

    }

    public ArrayList<Movimento> getRegistroMovimenti() {
        return registroMovimenti;
    }
}
