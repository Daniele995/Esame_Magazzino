package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Prodotto {
    @Id
    private int id;
    private int qtaDisponibile;
    private int sogliaMinima;
    private boolean isSottoscorta = false;

    public Prodotto(int id, int qtaDisponibile, int sogliaMinima) {
        this.id = id;
        this.qtaDisponibile = qtaDisponibile;
        this.sogliaMinima = sogliaMinima;
    }

    public Prodotto() {

    }

    public int getQtaDisponibile(){
        return this.qtaDisponibile;
    }

    public int getSogliaMinima(){
        return this.sogliaMinima;
    }

    public void aggiornaQta(int nuovaQta){
        this.qtaDisponibile = nuovaQta;
    }

    public void setSottoscorta(boolean sottoscorta) {
        isSottoscorta = sottoscorta;
    }
}
