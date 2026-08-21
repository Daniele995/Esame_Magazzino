package Boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GestioneAnagraficaBoundary {
    private JPanel gestioneAnagraficaPanel;
    private JButton modificaProdotto;
    private JButton creaProdotto;

    public void apriGestioneAnagrafica() {
        JFrame frame = new JFrame("Gestione Anagrafica");

        GestioneAnagraficaBoundary anagraficaBoundary = new GestioneAnagraficaBoundary();
        frame.setContentPane(this.gestioneAnagraficaPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
