package Entity;
import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_utente", discriminatorType = DiscriminatorType.STRING)
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    private String email;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;

    public Utente() {}



    public Utente(String nome, String cognome, String email, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }

    public int getId(){
        return this.id;
    }

}
