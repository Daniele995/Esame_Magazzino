package Entity;

import java.util.Date;

import jakarta.persistence.*;


@Entity

public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMovimento;
    private String tipo;
    private int quantita;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "Operatore_id")
    private Operatore operatore;

    @ManyToOne
    @JoinColumn(name = "Prodotto_id")
    private Prodotto prodotto;


    public Movimento() {}

    public Movimento(String tipo, int quantita, Date data, Operatore operatore, Prodotto prodotto){
        this.tipo = tipo;
        this.quantita = quantita;
        this.data = data;
        this.operatore = operatore;
        this.prodotto = prodotto;
}


    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public void setOperatore(Operatore operatore) {
        this.operatore = operatore;
    }

    public int getIdMovimento() {
        return idMovimento;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantita() {
        return quantita;
    }

    public Date getData() {
        return data;
    }

    public Operatore getOperatore() {
        return operatore;
    }


}

