package Controller;

import Entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerOperatore {
    public static final int MOVIMENTO_NON_REGISTRATO=0;
    public static final int MOVIMENTO_REGISTRATO_SUCCESSO=1;
    public static final int MOVIMENTO_REGISTRATO_SOTTO_SCORTA=2;
    public static final int ERRORE_QUANTITA_INSUFFICIENTE=-1;

    public static int registraMovimento(int idMovimento, String tipo, int quantita, int id_prodotto, Operatore operatore){

        RegistroMovimenti registroMovimenti = new RegistroMovimenti();
        RegistroProdotti registroProdotti = new RegistroProdotti();

        Prodotto prodotto = registroProdotti.ricercaProdotto(id_prodotto);

        if (tipo.equals("scarico") && quantita > prodotto.getQtaDisponibile()){
            return ERRORE_QUANTITA_INSUFFICIENTE;
        }

        registroMovimenti.registraMovimento(idMovimento, id_prodotto, tipo, quantita, new Date(), operatore);

        if (prodotto.isSottoScorta()) return MOVIMENTO_REGISTRATO_SOTTO_SCORTA;

        return MOVIMENTO_REGISTRATO_SUCCESSO;
    }

    public static List<String[]> getStoricoOperazioni(int idProdotto){
        RegistroMovimenti registroMovimenti = new RegistroMovimenti();

        List<Movimento> movimenti = registroMovimenti.getRegistroMovimenti();
        List<String[]> righe = new ArrayList<>();

        for (Movimento m: movimenti){
            String[] riga = new String[]{
                    String.valueOf(m.getMovimento_id()), m.getTipo(), String.valueOf(m.getQuantita()), m.getData().toString(), m.getOperatore().getNome()
            };
            righe.add(riga);
        }
        return righe;
    }




}
