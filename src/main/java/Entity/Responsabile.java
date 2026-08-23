package Entity;

import jakarta.persistence.Entity;


import java.util.ArrayList;

@Entity
public class Responsabile extends Utente {
    private ArrayList<Notifica> codaNotifiche = new ArrayList<Notifica>();



    public void riceviNotifica(Notifica notifica){
        codaNotifiche.add(notifica);
    }
}
