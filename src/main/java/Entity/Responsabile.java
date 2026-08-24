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
    private List<Notifica> notifiche=new ArrayList<>();  //viene creato vuoto

    public Responsabile() {
        super();
    }

    public Responsabile(String nome, String cognome, String email) {
        super(nome, cognome, email, Ruolo.RESPONSABILE);
    }

    // gestisce molti
    public void riceviNotifica(Notifica notifica){
        notifiche.add(notifica);
    }
}
