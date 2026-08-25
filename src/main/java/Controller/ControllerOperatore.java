package Controller;

import Database.GestorePersistenza;
import Entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerOperatore {
    public static final int MOVIMENTO_NON_REGISTRATO=0;
    public static final int MOVIMENTO_REGISTRATO_SUCCESSO=1;
    public static final int MOVIMENTO_REGISTRATO_SOTTO_SCORTA=2;
    public static final int ERRORE_QUANTITA_INSUFFICIENTE=-1;

    public static int registraMovimento(String tipo, int quantita, int id_prodotto, int id_Operatore){

        RegistroMovimenti registroMovimenti = new RegistroMovimenti();
        RegistroProdotti registroProdotti = new RegistroProdotti();

        Prodotto prodotto = registroProdotti.ricercaProdotto(id_prodotto);
        if (prodotto == null){
            return -2;
        }

        if (tipo.equals("scarico") && quantita > prodotto.getQtaDisponibile()){
            return ERRORE_QUANTITA_INSUFFICIENTE;
        }

        registroMovimenti.registraMovimento(id_prodotto, tipo, quantita, new Date(), id_Operatore);

        if (prodotto.isSottoScorta()) return MOVIMENTO_REGISTRATO_SOTTO_SCORTA;

        return MOVIMENTO_REGISTRATO_SUCCESSO;
    }

    public static List<String[]> getStoricoOperazioni(int idProdotto){
        RegistroMovimenti registroMovimenti = new RegistroMovimenti();

        GestorePersistenza gestorePersistenza = new GestorePersistenza();

        List<Movimento> movimenti = gestorePersistenza.cercaTutti(Movimento.class);
        List<String[]> righe = new ArrayList<>();

        for (Movimento m: movimenti){
            String[] riga = new String[]{
                    String.valueOf(m.getMovimento_id()), m.getTipo(), String.valueOf(m.getQuantita()), m.getData().toString(), m.getOperatore().getNome()
            };
            righe.add(riga);
        }
        return righe;
    }

    public List<String[]> getElencoProdotti() {
        RegistroReport registroReport = new RegistroReport();
        return registroReport.consultaElencoProdotti();
    }

    public List<String[]> getProdottiPerCategoria(String categoria) {
        RegistroProdotti registroProdotti = new RegistroProdotti();
        return registroProdotti.cercaProdottiPerCategoria(categoria);
    }

    }


