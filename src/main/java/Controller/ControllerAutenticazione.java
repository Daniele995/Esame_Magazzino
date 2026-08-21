package Controller;

public class ControllerAutenticazione {

    public static final int EMAIL_GIA_ESISTENTE = 0;
    public static final int REGISTRAZIONE_SUCCESSO = 1;
    public static final int ERRORE_DATI = -1;
    public static final int ACCESSO_SUCCESSO = 2;


    public int registrazioneUtente(String nome, String cognome, String email, String ruolo) {
        //Controllo campi
        if (nome == null || nome.isEmpty() || cognome == null || cognome.isEmpty() || email == null || email.isEmpty() || ruolo == null || ruolo.isEmpty()) {
            return ERRORE_DATI;
        }
        //Aggiungere controlli con i dati salvati
        return REGISTRAZIONE_SUCCESSO;
    }


    public int accesso(String email, String ruolo) {
        //Controllo campi
        if (email == null || email.isEmpty() || ruolo == null || ruolo.isEmpty()) {
            return ERRORE_DATI;
        }// Aggiungere controlli con i dati salvati
        return ACCESSO_SUCCESSO;
    }
}
