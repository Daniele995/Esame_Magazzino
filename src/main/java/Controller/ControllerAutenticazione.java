package Controller;

import Entity.*;

public class ControllerAutenticazione {

    public static final int EMAIL_GIA_ESISTENTE = 0;
    public static final int REGISTRAZIONE_SUCCESSO = 1;
    public static final int ERRORE_DATI = -1;
    public static final int ACCESSO_SUCCESSO = 2;


    public static int registrazioneUtente(String nome, String cognome, String email, String ruoloPassato) {

        Ruolo ruolo = Ruolo.valueOf(ruoloPassato.toUpperCase()); //Converto per enum
        GestoreUtenti gestore = new GestoreUtenti();

        boolean esisteUtente = gestore.esisteUtenteReg(email);
        if(esisteUtente){
            return EMAIL_GIA_ESISTENTE;
        }

        boolean creaUtente= gestore.creaUtente(nome, cognome, email, ruolo);
        if(creaUtente){
            return REGISTRAZIONE_SUCCESSO;
        }else {
            return ERRORE_DATI;
        }
        //return gestore.registrazione(nome, cognome, email, ruolo);
    }


    public static int accessoUtente(String email, String ruoloPassato) {
        Ruolo ruolo = Ruolo.valueOf(ruoloPassato.toUpperCase()); //Converto per enum
        GestoreUtenti gestore = new GestoreUtenti();

        boolean esisteUtente = gestore.esisteUtenteAccesso(email,ruolo);
        if (esisteUtente){
            return ACCESSO_SUCCESSO;
        }else {
            return ERRORE_DATI;
        }
        //return  gestore.accesso(email,ruolo);
    }

    public static int getId(String email){
        GestoreUtenti gestoreUtenti = new GestoreUtenti();
        return gestoreUtenti.trovaId(email);
    }
}
