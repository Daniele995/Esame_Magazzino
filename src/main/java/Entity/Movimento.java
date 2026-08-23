package Entity;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@DiscriminatorValue("OPERATORE")
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Movimento_id;
    private String tipo;
    private int quantita;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "Operatore_id")
    private Operatore operatore;
    @ManyToOne
    @JoinColumn(name = "prodotto_id")
    private Prodotto prodotto;


    public Movimento() {}

    public Movimento(String tipo, int quantita, Date data, Operatore operatore, Prodotto prodotto){
        this.tipo = tipo;
        this.quantita = quantita;
        this.data = data;
        this.operatore = operatore;
        this.prodotto = prodotto;
}



    public int getMovimento_id() {
        return Movimento_id;
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

