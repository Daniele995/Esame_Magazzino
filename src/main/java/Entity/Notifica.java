package Entity;

import jakarta.persistence.*;

@Entity
public class Notifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String messaggio;
    @ManyToOne
    private Utente utente;

    public Notifica(){
    }

    public Notifica(String messaggio, Utente utente){
        this.messaggio = messaggio;
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public String getMessaggio() {
        return messaggio;
    }
}
