package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Responsabile extends Utente {
    @Id
    private int Responsabile;
    private ArrayList<Notifica> codaNotifiche = new ArrayList<Notifica>();



    public void riceviNotifica(Notifica notifica){
        codaNotifiche.add(notifica);
    }
}
