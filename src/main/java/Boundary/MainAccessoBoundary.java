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

                if (emailInserita == null || emailInserita.isEmpty() || ruoloSelezionato == null || ruoloSelezionato.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Errore: credenziali non valide o ruolo errato!");
                    return;
                }

                ControllerAutenticazione controller = new ControllerAutenticazione();
                int esito = controller.accesso(emailInserita, ruoloSelezionato);

                if  (esito == ControllerAutenticazione.ACCESSO_SUCCESSO) {
                    int idUtente = ControllerAutenticazione.eseguiLogin(emailInserita);

                    if ("Responsabile".equals(ruoloSelezionato)) {
                        AreaResponsabileBoundary areaResp = new AreaResponsabileBoundary();
                        frameResponsabile = areaResp.apriFormResponsabile();

                    } else if ("Operatore".equals(ruoloSelezionato)) {
                        AreaOperatoreBoundary areaOp = new AreaOperatoreBoundary(idUtente);
                        frameOperatore = areaOp.apriFormOperatore();
                    }

                }

            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pagina iniziale");
        frame.setContentPane(new MainAccessoBoundary().schermataIniziale);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
