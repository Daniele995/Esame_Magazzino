package Eseguibile;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCreaTabelle {

    public static void main(String[] args) {

        // Avvia Hibernate usando la persistence-unit definita nel persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MagazzinoPU");

        // Chiude la fabbrica subito dopo la prova
        emf.close();

        System.out.println("Avvio di Hibernate completato.");
    }
}
