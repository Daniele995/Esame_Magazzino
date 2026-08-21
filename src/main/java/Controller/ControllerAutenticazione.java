package Controller;

public class ControllerAutenticazione {

    public static final int EMAIL_GIA_ESISTENTE = 0;
    public static final int REGISTRAZIONE_SUCCESSO = 1;
    public static final int ERRORE_DATI = -1;
    public static final int ACCESSO_SUCCESSO = 2;


    public int registrazioneUtente(String nome, String cognome, String email, String ruolo) {
        //Controllo campi

        //Aggiungere controlli con i dati salvati
        return 3;
    }


    public int accesso(String email, String ruolo) {
        //Controllo campi
        // Aggiungere controlli con i dati salvati
        return 2;
    }
}
