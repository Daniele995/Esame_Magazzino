package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Prodotto {
    @Id
    private int id;
    private String nome;
    private String descrizione;
    private String categoria;
    private int sogliaMinima;
    private int qtaDisponibile;
    private String posizione;
    private boolean isSottoScorta = false;

    @OneToMany(mappedBy = "prodotto")
    private List<Movimento> movimenti;


    public Prodotto() {}

    /*

    public Prodotto(String nome, String descrizione, String categoria, int sogliaMinima, String posizione, int qtaDisponibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.categoria = categoria;
        this.sogliaMinima = sogliaMinima;
        this.posizione = posizione;
        this.qtaDisponibile = qtaDisponibile;
    }


    */
    public Prodotto(int id, int qtaDisponibile, int sogliaMinima) {
        this.id = id;
        this.qtaDisponibile = qtaDisponibile;
        this.sogliaMinima = sogliaMinima;
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
        isSottoScorta = sottoscorta;
    }

    public int getId() {
        return this.id;
    }

    public boolean isSottoScorta() {
        return isSottoScorta;
    }
}
