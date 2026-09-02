package Boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GestioneAnagraficaBoundary {
    private JPanel gestioneAnagraficaPanel;
    private JButton modificaProdotto;
    private JButton creaProdotto;

    public GestioneAnagraficaBoundary() {

        creaProdotto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreaProdottoBoundary creaProdottoBoundary = new CreaProdottoBoundary();
                creaProdottoBoundary.apriCreaProdotto();
            }
        });

        modificaProdotto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificaProdottoBoundary modificaProdottoBoundary = new ModificaProdottoBoundary();
                modificaProdottoBoundary.apriModificaProdotto();
            }
        });

    }

    public void apriGestioneAnagrafica() {
        JFrame frame = new JFrame("Gestione Anagrafica");
        frame.setContentPane(this.gestioneAnagraficaPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    //TEST INTERFACCIA
    public static void main(String[] args) {

        GestioneAnagraficaBoundary gestioneAnagraficaBoundary =
                new GestioneAnagraficaBoundary();

        gestioneAnagraficaBoundary.apriGestioneAnagrafica();
    }

}