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

        Prodotto prodotto1 = new Prodotto( "Biscotti", "Biscotti al burro", "Alimentari", 10, "A3", 4);
        Prodotto prodotto2 = new Prodotto( "Biscotti1", "Biscotti", "Alimentari", 10, "A2", 5);
        Prodotto prodotto3 = new Prodotto( "Biscotti2", "Biscotti vaniglia", "Alimentari", 10, "A1", 4);
        Prodotto prodotto4 = new Prodotto( "Sedia", "Sedia pieghevole", "Casa", 10, "A44", 4);
        gestorePersistenza.salva(prodotto1);
        gestorePersistenza.salva(prodotto2);
        gestorePersistenza.salva(prodotto3);
        gestorePersistenza.salva(prodotto4);

        // Chiude la fabbrica subito dopo la prova
        emf.close();

        System.out.println("Avvio di Hibernate completato.");
    }
}
