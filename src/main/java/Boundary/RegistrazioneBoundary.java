package Boundary;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneBoundary {

    private JPanel registrazionePanel;
    private JTextField inserisciNome;
    private JTextField inserisciCognome;
    private JTextField inserisciEmail;
    private JComboBox scegliRuolo;
    private JLabel nome;
    private JLabel cognome;
    private JLabel email;
    private JLabel ruolo;
    private JButton invioDati;


    public RegistrazioneBoundary() {
        invioDati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }

    public JFrame apriFormRegistrazione() {
        JFrame frameRegistrazione = new JFrame("Registrazione Utente");
        frameRegistrazione.setContentPane(this.registrazionePanel);
        frameRegistrazione.pack();
        frameRegistrazione.setLocationRelativeTo(null);
        frameRegistrazione.setVisible(true);
        return frameRegistrazione;
    }
}
