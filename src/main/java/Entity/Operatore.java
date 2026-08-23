package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Operatore extends Utente{
    @OneToMany
    private List<Movimento> storicoPersonale = new ArrayList<Movimento>();

    public Operatore() {

    }

    public void aggiungiMovimento(Movimento movimento){
        storicoPersonale.add(movimento);
    }


}
