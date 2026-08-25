package Entity;

import Database.GestorePersistenza;

import java.util.Map;

public class GestoreUtenti {

    private GestorePersistenza gestorePersistenza;

    public GestoreUtenti() {
        gestorePersistenza = new GestorePersistenza();
    }

    public int registrazione(String nome, String cognome, String email, Ruolo ruolo) {

        Utente utente = gestorePersistenza.cercaPrimoPerCampi(Utente.class, Map.of("email", email));

        if (utente != null) {
            return 0;
        }
        boolean esito=false;

            if (ruolo == Ruolo.OPERATORE) {
                Utente nuovoUtente = new Operatore(nome, cognome, email);
                esito = gestorePersistenza.salva(nuovoUtente);
            } else if (ruolo == Ruolo.RESPONSABILE) {
                Utente nuovoUtente = new Responsabile(nome, cognome, email);
                esito = gestorePersistenza.salva(nuovoUtente);
            }

        if (esito) {
            return 1;
        }else {
            return -1;
        }
    }

    public int accesso(String email, Ruolo ruolo) {
        Utente utente = gestorePersistenza.cercaPrimoPerCampi(Utente.class, Map.of("email", email, "ruolo", ruolo));
        if (utente == null) {
            return -1;
        }else {
            return 2;
        }

    }
    public int verificaCredenziali(String email){

        Map<String, Object> parametri = Map.of("email", email);

        Utente utente = gestorePersistenza.cercaPrimoPerCampi(Utente.class, parametri);

        if (utente != null){
            return utente.getId();
        }
        return -1;
    }
}
