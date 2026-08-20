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

    public JPanel getSituazioneAggiornataMagazzinoPanel() {
        return situazioneAggiornataMagazzinoPanel;
    }
}


