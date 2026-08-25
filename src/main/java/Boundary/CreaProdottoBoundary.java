package Boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreaProdottoBoundary {

    private JPanel CreaProdottoPanel;

    //CODICE PRODOTTO
    private JLabel CodiceProdotto;
    private JTextField CodiceProdottoTF;
    //NOME PRODOTTO
    private JLabel NomeProdotto;
    private JTextField NomeProdottoTF;
    //DESCRIZIONE
    private JLabel Descrizione;
    private JTextField DescrizioneTF;
    //CATEGORIA
    private JLabel Categoria;
    private JTextField CategoriaTF;
    //SOGLIA MINIMA
    private JLabel SogliaMinima;
    private JTextField SogliaMinimaTF;
    //POSIZIONE
    private JLabel Posizione;
    private JTextField PosizioneTF;
    //CONFERMA CREAZIONE
    private JLabel ConfermaCreazione;
    private JButton ConfermaCreazioneB;
    //ESITO
    private JLabel Esito;
    private JLabel EsitoLabel;


    public CreaProdottoBoundary() {

        ConfermaCreazioneB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                creaProdottoValidazione();
            }
        });
    }

    private void creaProdottoValidazione() {

        String codice = CodiceProdottoTF.getText();
        String nome = NomeProdottoTF.getText();
        String descrizione = DescrizioneTF.getText();
        String categoria = CategoriaTF.getText();
        String sogliaMinimaString = SogliaMinimaTF.getText();
        String posizione = PosizioneTF.getText();

        if (codice.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Il codice prodotto non può essere vuoto.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Il nome prodotto non può essere vuoto.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (descrizione.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "La descrizione non può essere vuota.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (categoria.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "La categoria non può essere vuota.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (sogliaMinimaString.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "La soglia minima non può essere vuota.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (posizione.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "La posizione non può essere vuota.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //La soglia minima deve essere un intero non negativo
        int sogliaMinima;

        try {
            sogliaMinima = Integer.parseInt(sogliaMinimaString);
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "La soglia minima deve essere un numero intero.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        if (sogliaMinima < 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "La soglia minima non può essere negativa.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        //EsitoLabel.setText("TEMP: I dati erano plausibili");
    }

    public void apriCreaProdotto() {
        JFrame frame = new JFrame("Crea Prodotto");
        frame.setContentPane(this.CreaProdottoPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



/*  TEST INTERFACCIA (e creaProdottoValidazione)
    public static void main(String[] args) {

        CreaProdottoBoundary creaProdottoBoundary =
                new CreaProdottoBoundary();

        creaProdottoBoundary.apriCreaProdotto();
    }

 */
}