package Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;


import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("RESPONSABILE")
public class Responsabile extends Utente {
    @ManyToMany(mappedBy = "responsabili")
    private List<Notifica> notifiche;

    public Responsabile() {
        super();
    }

    public Responsabile(String nome, String cognome, String email) {
        super(nome, cognome, email, Ruolo.RESPONSABILE);
    }


    /*public void riceviNotifica(Notifica notifica){
        codaNotifiche.add(notifica);
    }*/
}
