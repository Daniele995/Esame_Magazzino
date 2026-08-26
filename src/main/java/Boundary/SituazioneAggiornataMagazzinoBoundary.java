package Boundary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SituazioneAggiornataMagazzinoBoundary {
    private JPanel situazioneAggiornataMagazzinoPanel;
    private JTable situazioneMagazzino;
    private boolean datiDisponibili = true;

    public SituazioneAggiornataMagazzinoBoundary(){
        String[] colonne = {"Prodotto", "Quantità", "Sotto Scorta"};
        String[] elenco = {"ID", "Nome Prodotto", "Descrizione", "Categoria", "Soglia Minima", "Posizione", "Quantità disponibile", "Indicazione sotto scorta"};

        DefaultTableModel modelloTabella = new DefaultTableModel(colonne, 0);
        situazioneMagazzino.setModel(modelloTabella);

    }

    public void apriSituazioneAggiornata(){
        JFrame frame = new JFrame("Situazione Aggiornata");

        frame.setContentPane(this.situazioneAggiornataMagazzinoPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}


