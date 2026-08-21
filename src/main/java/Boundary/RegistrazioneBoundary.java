package Boundary;
import Controller.ControllerAutenticazione;

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
                String nomeInserito = inserisciNome.getText();
                String cognomeInserito = inserisciCognome.getText();
                String emailInserita = inserisciEmail.getText();
                String ruoloSelezionato = (String) scegliRuolo.getSelectedItem();

                ControllerAutenticazione controller = new ControllerAutenticazione();
                int esito = controller.registrazioneUtente(nomeInserito, cognomeInserito, emailInserita, ruoloSelezionato);

                if (esito == ControllerAutenticazione.REGISTRAZIONE_SUCCESSO) {
                    JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo!");

                } else if (esito == ControllerAutenticazione.EMAIL_GIA_ESISTENTE) {
                    JOptionPane.showMessageDialog(null, "Errore: questa email è già registrata.");
                } else {
                    JOptionPane.showMessageDialog(null, "Errore nei dati inseriti o campi vuoti.");
                }


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
