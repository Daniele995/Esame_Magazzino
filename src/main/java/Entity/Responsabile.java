package Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;


import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("RESPONSABILE")
public class Responsabile extends Utente {
    @OneToMany(mappedBy = "responsabile")
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
