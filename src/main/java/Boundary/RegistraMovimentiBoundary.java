package Boundary;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraMovimentiBoundary {
    private JPanel RegistraMovimentiPanel;
    private JTextField inserisciId;
    private JTextField inserisciQuantità;
    private JButton registraCarico;
    private JButton registraScarico;
    private JLabel id;
    private JLabel quantità;


    public RegistraMovimentiBoundary() {
        registraCarico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
