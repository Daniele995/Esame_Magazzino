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

                String errore = validaCampi(nomeInserito, cognomeInserito, emailInserita, ruoloSelezionato);

                if (errore != null) {
                    JOptionPane.showMessageDialog(null, errore, "Errore di validazione", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ControllerAutenticazione controller = new ControllerAutenticazione();
                int esito = controller.registrazioneUtente(nomeInserito, cognomeInserito, emailInserita, ruoloSelezionato);

                if (esito == ControllerAutenticazione.REGISTRAZIONE_SUCCESSO) {
                    JOptionPane.showMessageDialog(null, "Registrazione avvenuta con successo!");

                } else if (esito == ControllerAutenticazione.EMAIL_GIA_ESISTENTE) {
                    JOptionPane.showMessageDialog(null, "Errore: questa email è già registrata.");
                }


            }
        });
    }

    private String validaCampi(String nome, String cognome, String email, String ruolo) {

        if (nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || ruolo == null || ruolo.isEmpty()) {
            return "Errore: tutti i campi devono essere compilati.";
        }
        // controlli sul nome
        else if (nome.length() > 40) {
            return "Errore: Il nome non può superare i 40 caratteri.";
        }
        else if (!nome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            return "Errore: Il nome contiene simboli o caratteri non consentiti.";
        }

        // controlli sul cognome
        else if (cognome.length() > 40) {
            return "Errore: Il cognome non può superare i 40 caratteri.";
        }
        else if (!cognome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            return "Errore: Il cognome contiene simboli o caratteri non consentiti.";
        }

        // controlli email
        else if (email.length() > 50) {
            return "Errore: L'email non può superare i 50 caratteri.";
        }
        else if (!email.contains("@")) {
            return "Errore: L'email non contiene il carattere '@'.";
        }
        else if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return "Errore: L'email contiene caratteri speciali vietati.";
        }
        // se tutto va bene restituisco null
        return null;
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
