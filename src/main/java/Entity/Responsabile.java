package Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


import java.util.ArrayList;

@Entity
@DiscriminatorValue("RESPONSABILE")
public class Responsabile extends Utente {
    private ArrayList<Notifica> codaNotifiche = new ArrayList<Notifica>();

    public Responsabile() {
        super();
    }


    public void riceviNotifica(Notifica notifica){
        codaNotifiche.add(notifica);
    }
}
