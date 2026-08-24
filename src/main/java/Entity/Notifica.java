package Entity;

import jakarta.persistence.*;



@Entity
public class Notifica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String messaggio;

    @ManyToOne
    @JoinColumn(name = "responsabile_id")
    private Responsabile responsabile;

    public Notifica(){
    }

    public Notifica(String messaggio, Responsabile responsabile){
        this.messaggio = messaggio;
        this.responsabile = responsabile;

       /* if (responsabile != null) {
            responsabile.riceviNotifica(this);
        }*/
    }

    public int getId() {
        return id;
    }

    public String getMessaggio() {
        return messaggio;
    }
}
