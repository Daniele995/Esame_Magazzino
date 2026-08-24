package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Prodotto {
    @Id
    private Long id;
    private String nome;
    private String descrizione;
    private String categoria;
    private int sogliaMinima;
    private int qtaDisponibile;
    private String posizione;
    private boolean isSottoScorta = false;


    public Prodotto() {}

    public Prodotto(Long id, int qtaDisponibile, int sogliaMinima) {
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

    public Long getId() {
        return this.id;
    }

    public boolean isSottoScorta() {
        return isSottoScorta;
    }
}
