package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Operatore extends Utente{
    @Id
    private int Operatore_id;
}
