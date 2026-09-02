package Controller;

import Database.GestorePersistenza;
import Entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerOperatore {
    public static final int ERRORE_PRODOTTO_NON_TROVATO=0;
    public static final int MOVIMENTO_REGISTRATO_SUCCESSO=1;
    public static final int MOVIMENTO_REGISTRATO_SOTTO_SCORTA=2;
    public static final int ERRORE_QUANTITA_INSUFFICIENTE=-1;
    public static final int MOVIMENTO_REGISTRATO_SOTTO_SCORTA_RIMOSSO = 3;

    public static int registraMovimento(String tipo, int quantita, int id_prodotto, int id_Operatore){


        RegistroProdotti registroProdotti = new RegistroProdotti();

        Prodotto prodotto = registroProdotti.ricercaProdotto(id_prodotto);

        if (prodotto == null){
            return ERRORE_PRODOTTO_NON_TROVATO;
        }

        if (tipo.equals("scarico") && quantita > prodotto.getQtaDisponibile()){
            return ERRORE_QUANTITA_INSUFFICIENTE;
        }

        boolean eraSottoScorta = prodotto.isSottoScorta();
        int nuovaQuantita = prodotto.getQtaDisponibile();
        if (tipo.equals("carico")) {
            nuovaQuantita += quantita;
        } else if (tipo.equals("scarico")) {
            nuovaQuantita -= quantita;
        }
        boolean saraSottoScorta = (nuovaQuantita < prodotto.getSogliaMinima());

        RegistroMovimenti registroMovimenti = new RegistroMovimenti();
        registroMovimenti.registraMovimento(prodotto, tipo, quantita, new Date(), id_Operatore);

        if (eraSottoScorta && !saraSottoScorta){
            return MOVIMENTO_REGISTRATO_SOTTO_SCORTA_RIMOSSO;
        }
        if (saraSottoScorta){
            return MOVIMENTO_REGISTRATO_SOTTO_SCORTA;
        }

        return MOVIMENTO_REGISTRATO_SUCCESSO;
    }

    public static List<String[]> getElencoProdotti() {
        RegistroReport registroReport = new RegistroReport();
        return registroReport.consultaElencoProdotti();
    }

    public static List<String[]> getProdottiPerCategoria(String categoria) {
        RegistroProdotti registroProdotti = new RegistroProdotti();
        return registroProdotti.cercaProdottiPerCategoria(categoria);
    }

    }


