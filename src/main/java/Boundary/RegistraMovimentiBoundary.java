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
    private JLabel label_esito;


    public RegistraMovimentiBoundary(int id_Operatore) {

        registraCarico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Premuto bottone");
                int id_prodotto = Integer.parseInt(inserisciId.getText());
                int quantita = Integer.parseInt(inserisciQuantita.getText());

                label_esito = new JLabel();
                int esito = ControllerOperatore.registraMovimento("carico",quantita,id_prodotto,id_Operatore);

                if (esito == -2){
                    label_esito.setText("Errore: Prodotto inesistente");
                    JOptionPane.showMessageDialog(null,
                            "Id inserito non corrispondente a nessun prodotto",
                            "Prodotto non trovato",
                            JOptionPane.ERROR_MESSAGE);

                } else if (esito == ControllerOperatore.MOVIMENTO_REGISTRATO_SUCCESSO){
                    label_esito.setText("Movimento registrato con successo");
                    JOptionPane.showMessageDialog(
                            null,
                            "Movimento salvato e quantità aggiornata",
                            "Salvataggio eseguito",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else if( esito == ControllerOperatore.MOVIMENTO_REGISTRATO_SOTTO_SCORTA){
                    label_esito.setText("Movimento registrato con successo");
                    JOptionPane.showMessageDialog(
                            null,
                            "Movimento salvato e quantità aggiornata, ma il prodotto è rimasto sotto scorta",
                            "Salvataggio eseguito",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    label_esito.setText("Movimento non eseguito");
                    JOptionPane.showMessageDialog(
                            null,
                            "Movimento non eseguito,",
                            "Errore nel salvataggio",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

            }
        });


        registraScarico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Premuto Bottone");

                int id_prodotto = Integer.parseInt(inserisciId.getText());
                int quantita = Integer.parseInt(inserisciQuantita.getText());

                label_esito = new JLabel();
                int esito = ControllerOperatore.registraMovimento("scarico",quantita,id_prodotto,id_Operatore);

                if (esito == -2){
                    label_esito.setText("Errore: Prodotto inesistente");
                    JOptionPane.showMessageDialog(null,
                            "Id inserito non corrispondente a nessun prodotto",
                            "Prodotto non trovato",
                            JOptionPane.ERROR_MESSAGE);

                } else if (esito == ControllerOperatore.MOVIMENTO_REGISTRATO_SUCCESSO){
                    label_esito.setText("Movimento registrato con successo");
                    JOptionPane.showMessageDialog(
                            null,
                            "Movimento salvato e quantità aggiornata",
                            "Salvataggio eseguito",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else if(esito == ControllerOperatore.ERRORE_QUANTITA_INSUFFICIENTE){
                    label_esito.setText("Movimento non eseguito a causa di scarsità nelle scorte");
                    JOptionPane.showMessageDialog(
                            null,
                            "Scorte insufficienti ad eseguire lo scarico",
                            "Errore nel salvataggio",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else if(esito == ControllerOperatore.MOVIMENTO_REGISTRATO_SOTTO_SCORTA){
                    label_esito.setText("Movimento eseguito e prodotto segnato sotto scorta");
                    JOptionPane.showMessageDialog(
                            null,
                            "Movimento eseguito, quantità aggiornata e prodotto segnato sotto scorta",
                            "Salvataggio eseguito",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    label_esito.setText("Movimento non eseguito");
                    JOptionPane.showMessageDialog(
                            null,
                            "Movimento non eseguito",
                            "Errore nel salvataggio",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

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
