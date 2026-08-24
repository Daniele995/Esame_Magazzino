package Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Notifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String messaggio;

    @ManyToMany
    @JoinTable(
            name = "responsabile_notifica",
            joinColumns = @JoinColumn(name = "notifica_id"),
            inverseJoinColumns = @JoinColumn(name = "responsabile_id")
    )
    private List<Responsabile> responsabili;

    public Notifica(){
    }

    public Notifica(String messaggio, Utente utente){
        this.messaggio = messaggio;
        //this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public String getMessaggio() {
        return messaggio;
    }
}
