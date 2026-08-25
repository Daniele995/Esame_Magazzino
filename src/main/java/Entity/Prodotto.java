package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
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
    private boolean isSottoScorta;

    @OneToMany(mappedBy = "prodotto")
    private List<Movimento> movimenti = new ArrayList<>();

    public Prodotto() {}

    public Prodotto(int id,String nome, String descrizione, String categoria, int sogliaMinima, String posizione, int qtaDisponibile) {
        this.id=id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.categoria = categoria;
        this.sogliaMinima = sogliaMinima;
        this.posizione = posizione;
        this.qtaDisponibile = qtaDisponibile;
        this.isSottoScorta = qtaDisponibile<sogliaMinima;

    }


    /*public void addMovimento(Movimento movimento) {
        if (movimento != null && !movimenti.contains(movimento)) {
            movimenti.add(movimento);
            movimento.setProdotto(this);
        }
    }*/

    public String getNome(){
        return this.nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQtaDisponibile(){
        return this.qtaDisponibile;
    }

    public String getPosizione() {
        return posizione;
    }

    public int getSogliaMinima(){
        return this.sogliaMinima;
    }

    public void aggiornaQta(int nuovaQta){
        this.qtaDisponibile += nuovaQta;
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
