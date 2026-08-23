package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Operatore extends Utente{
    @Id
    private int Operatore_id;
    @OneToMany
    private ArrayList<Movimento> storicoPersonale = new ArrayList<Movimento>();

    public Operatore() {

    }

    public void aggiungiMovimento(Movimento movimento){
        storicoPersonale.add(movimento);
    }


}
