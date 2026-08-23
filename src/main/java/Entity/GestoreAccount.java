package Entity;

import Database.GestorePersistenza;

import java.util.Map;

public class GestoreAccount {

    public int verificaCredenziali(String email){
        GestorePersistenza gestorePersistenza = new GestorePersistenza();

        Map<String, Object> parametri = Map.of("email", email);

        Utente utente = gestorePersistenza.cercaPrimoPerCampi(Utente.class, parametri);

        if (utente != null){
            return utente.getId();
        }
        return -1;
    }
}
