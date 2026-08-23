package Boundary;
import Controller.ControllerOperatore;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraMovimentiBoundary {
    private JPanel RegistraMovimentiPanel;
    private JTextField inserisciId;
    private JTextField inserisciQuantita;
    private JButton registraCarico;
    private JButton registraScarico;
    private JLabel id;
    private JLabel quantità;


    public RegistraMovimentiBoundary(int id_Operatore) {

        registraCarico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Premuto bottone");
                int id_prodotto = Integer.getInteger(inserisciId.getText());
                int quantita = Integer.getInteger(inserisciQuantita.getText());


                int esito = ControllerOperatore.registraMovimento("carico",id_prodotto,quantita,id_Operatore);

            }
        });
    }

    public JFrame apriRegistraMovimento() {
        JFrame frameElenco = new JFrame("Registra movimento");
        frameElenco.setContentPane(this.RegistraMovimentiPanel);
        frameElenco.pack();
        frameElenco.setLocationRelativeTo(null);
        frameElenco.setVisible(true);
        return frameElenco;
    }
}
