package Boundary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SituazioneAggiornataMagazzinoBoundary {
    private JPanel situazioneAggiornataMagazzinoPanel;
    private JTable situazioneMagazzino;

    public SituazioneAggiornataMagazzinoBoundary(){
        String[] colonne = {"Prodotto", "Quantità", "Sotto Scorta"};
        DefaultTableModel modelloTabella = new DefaultTableModel(colonne, 0);
        situazioneMagazzino.setModel(modelloTabella);
    }

    public void apriSituazioneAggiornata(){
        JFrame frame = new JFrame("Situazione Aggiornata");

        SituazioneAggiornataMagazzinoBoundary situazioneAggiornataBoundary = new SituazioneAggiornataMagazzinoBoundary();
        frame.setContentPane(situazioneAggiornataBoundary.getSituazioneAggiornataMagazzinoPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getSituazioneAggiornataMagazzinoPanel() {
        return situazioneAggiornataMagazzinoPanel;
    }
}


