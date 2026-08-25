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
        //Elenco prodotti, quantità disponibile e indicazione sottoscorta
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


