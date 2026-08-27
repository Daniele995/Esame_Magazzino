package Boundary;
import Controller.ControllerAutenticazione;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAccessoBoundary {
    private JPanel schermataIniziale;
    private JTextField inserisciEmail;
    private JComboBox scegliRuolo;
    private JButton accedi;
    private JButton registrati;
    private JLabel email;
    private JLabel ruolo;

    private JFrame frameRegistrazione;
    private JFrame frameResponsabile;
    private JFrame frameOperatore;


    public MainAccessoBoundary() {

        scegliRuolo.setSelectedIndex(-1);

        registrati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (frameRegistrazione == null || !frameRegistrazione.isDisplayable()) {
                    RegistrazioneBoundary regBoundary = new RegistrazioneBoundary();
                    frameRegistrazione = regBoundary.apriFormRegistrazione();
                }else {
                    frameRegistrazione.toFront();
                    frameRegistrazione.requestFocus();
                }
            }
        });
        accedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String emailInserita = inserisciEmail.getText();
                String ruoloSelezionato = (String) scegliRuolo.getSelectedItem();

                String errore = validaAccesso(emailInserita, ruoloSelezionato);

                if (errore != null) {
                    JOptionPane.showMessageDialog(null, errore, "Errore di validazione", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                accessoUtente(emailInserita, ruoloSelezionato);
            }
        });
    }

    private String validaAccesso(String email, String ruolo) {

        if (email.isEmpty() || ruolo == null ) {
            return "Errore: inserisci l'email e seleziona un ruolo.";
        }
        // controllo email
        else if (email.length() > 50) {
            return "Errore: L'email non può superare i 50 caratteri.";
        }
        else if (!email.contains("@")) {
            return "Errore: L'email non contiene il carattere '@'.";
        }
        else if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            return "Errore: L'email contiene caratteri speciali vietati.";
        }
        return null;
    }

    private void accessoUtente(String emailInserita, String ruoloSelezionato){

        int esito = ControllerAutenticazione.accessoUtente(emailInserita, ruoloSelezionato);

        if  (esito == ControllerAutenticazione.ACCESSO_SUCCESSO) {
            int idUtente = ControllerAutenticazione.getId(emailInserita);

            if ("Responsabile".equals(ruoloSelezionato)) {
                AreaResponsabileBoundary areaResp = new AreaResponsabileBoundary();
                frameResponsabile = areaResp.apriFormResponsabile();

            } else if ("Operatore".equals(ruoloSelezionato)) {
                AreaOperatoreBoundary areaOp = new AreaOperatoreBoundary(idUtente);
                frameOperatore = areaOp.apriFormOperatore();
            }

        }else if (esito == ControllerAutenticazione.ERRORE_DATI){
            JOptionPane.showMessageDialog(null, "Nessuna corrispondenza, registrati");
        }

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pagina iniziale");
        frame.setContentPane(new MainAccessoBoundary().schermataIniziale);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
