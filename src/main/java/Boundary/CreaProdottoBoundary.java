package Boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreaProdottoBoundary {

    private JPanel creaProdottoPanel;

    private JLabel nome;            //NOME PRODOTTO
    private JLabel descrizione;     //DESCRIZIONE
    private JLabel categoria;       //CATEGORIA
    private JLabel sogliaMinima;    //SOGLIA MINIMA
    private JLabel posizione;       //POSIZIONE

    private JTextField inserisciNome;
    private JTextField inserisciDescrizione;
    private JTextField inserisciCategoria;
    private JTextField inserisciSoglia;
    private JTextField inserisciPosizione;

    private JButton creaProdotto;


    public CreaProdottoBoundary() {

        creaProdotto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                creaProdottoValidazione();
            }
        });
    }

    private void creaProdottoValidazione() {

        String nome = inserisciNome.getText();
        String descrizione = inserisciDescrizione.getText();
        String categoria = inserisciCategoria.getText();
        String sogliaMinimaString = inserisciSoglia.getText();
        String posizione = inserisciPosizione.getText();


        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Il nome prodotto non può essere vuoto.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (nome.length() > 45) {
            JOptionPane.showMessageDialog(
                    null,
                    "Il nome prodotto non può superare i 45 caratteri.",
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

        if (descrizione.length() > 255) {
            JOptionPane.showMessageDialog(
                    null,
                    "La descrizione non può superare i 255 caratteri.",
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

        if (categoria.length() > 45) {
            JOptionPane.showMessageDialog(
                    null,
                    "La categoria non può superare i 45 caratteri.",
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

        if (posizione.length() > 45) {
            JOptionPane.showMessageDialog(
                    null,
                    "La posizione non può superare i 45 caratteri.",
                    "Errore di inserimento",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //La soglia minima deve essere un intero non negativo
        int sogliaMinimaInt;

        if (sogliaMinimaString.isEmpty()) {
            sogliaMinimaInt = 0;
        } else {

            try {
                sogliaMinimaInt = Integer.parseInt(sogliaMinimaString);
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "La soglia minima deve essere un numero intero.",
                        "Errore di inserimento",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            if (sogliaMinimaInt < 0) {

                JOptionPane.showMessageDialog(
                        null,
                        "La soglia minima non può essere negativa.",
                        "Errore di inserimento",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

        }

    }

    public void apriCreaProdotto() {
        JFrame frame = new JFrame("Crea Prodotto");
        frame.setContentPane(this.creaProdottoPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    /*TEST INTERFACCIA (e creaProdottoValidazione) *
    public static void main(String[] args) {

        CreaProdottoBoundary creaProdottoBoundary =
                new CreaProdottoBoundary();

        creaProdottoBoundary.apriCreaProdotto();
    }
    */
}