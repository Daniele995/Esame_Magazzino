package Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("OPERATORE")
public class Operatore extends Utente{
    @OneToMany(mappedBy = "operatore")
    private List<Movimento> storicoPersonale = new ArrayList<>(); //viene creato vuoto

    public Operatore() {
        super();}

    public Operatore(String nome, String cognome, String email) {

        super(nome, cognome, email, Ruolo.OPERATORE);
    }
    // gestisce molti

    public void aggiungiMovimento(Movimento movimento) {
        if (movimento != null && !storicoPersonale.contains(movimento)) {
            storicoPersonale.add(movimento);
            movimento.setOperatore(this);
        }
    }

}
