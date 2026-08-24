package Eseguibile;

import Database.GestorePersistenza;
import Entity.Prodotto;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCreaTabelle {

    public static void main(String[] args) {

        // Avvia Hibernate usando la persistence-unit definita nel persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MagazzinoPU");
        GestorePersistenza gestorePersistenza = new GestorePersistenza();

       // Prodotto prodotto1 = new Prodotto(3, "Biscotti", "Biscotti al burro", "Alimentari", 10, "A23", 4);
       // gestorePersistenza.salva(prodotto1);

        // Chiude la fabbrica subito dopo la prova
        emf.close();

        System.out.println("Avvio di Hibernate completato.");
    }
}
