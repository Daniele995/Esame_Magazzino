package Entity;
import java.util.Date;
import jakarta.persistence.Entity;

public class Movimento {
    private String tipo;
    private int quantita;
    private Date data;
    private Operatore operatore;
    private Prodotto prodotto;
}
