package Boundary;

import Controller.ControllerResponsabile;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaProdottoBoundary {

    private JPanel modificaProdottoPanel;

    private JRadioButton ricercaPerId;
    private JRadioButton ricercaPerNome;
    private JTextField inserisciRicerca;
    private JButton cercaProdotto;
    private Integer idProdottoSelezionato = null;

    private JLabel id;
    private JLabel nome;
    private JLabel descrizione;
    private JLabel posizione;
    private JLabel sogliaMinima;
    private JLabel categoria;
    private JLabel valoreId;

    private JTextField inserisciNome;
    private JTextField inserisciDescrizione;
    private JTextField inserisciCategoria;
    private JTextField inserisciSoglia;
    private JTextField inserisciPosizione;
    private JButton modificaProdotto;


    public ModificaProdottoBoundary() {

        ButtonGroup gruppoRicerca = new ButtonGroup();
        gruppoRicerca.add(ricercaPerId);
        gruppoRicerca.add(ricercaPerNome);

        ricercaPerId.setSelected(true);

        impostaCampiModificaAbilitati(false);

        cercaProdotto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ricercaProdottoValidazione();
            }
        });

        modificaProdotto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                modificaProdottoValidazione();
            }
        });
    }

    public void apriModificaProdotto() {
        JFrame frame = new JFrame("Modifica Prodotto");
        frame.setContentPane(this.modificaProdottoPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void impostaCampiModificaAbilitati(boolean abilitati) {
        inserisciNome.setEnabled(abilitati);
        inserisciDescrizione.setEnabled(abilitati);
        inserisciCategoria.setEnabled(abilitati);
        inserisciSoglia.setEnabled(abilitati);
        inserisciPosizione.setEnabled(abilitati);
        modificaProdotto.setEnabled(abilitati);
    }

    private void ricercaProdottoValidazione() {

        String valoreRicerca = inserisciRicerca.getText().trim();

        if (valoreRicerca.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Inserire un valore da cercare.",
                    "Errore di ricerca",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String[] prodottoTrovato = null;

        if (ricercaPerId.isSelected()) {
            int idProdotto;
            try {
                idProdotto = Integer.parseInt(valoreRicerca);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "L'ID deve essere un numero intero.",
                        "Errore di ricerca",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            if (idProdotto <= 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "L'ID deve essere maggiore di zero.",
                        "Errore di ricerca",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            prodottoTrovato = ControllerResponsabile.ricercaProdotto(idProdotto);

        } else if (ricercaPerNome.isSelected()) {
            if (valoreRicerca.length() > 45) {
                JOptionPane.showMessageDialog(
                        null,
                        "Il nome non può superare i 45 caratteri.",
                        "Errore di ricerca",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            prodottoTrovato = ControllerResponsabile.ricercaProdotto(valoreRicerca);
        }

        if (prodottoTrovato == null) {
            pulisciProdotto();
            JOptionPane.showMessageDialog(
                    null,
                    "Nessun prodotto trovato.",
                    "Ricerca prodotto",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        caricaProdotto(prodottoTrovato);
    }

    private void caricaProdotto(String[] prodotto) {

        idProdottoSelezionato = Integer.parseInt(prodotto[0]);

        valoreId.setText(prodotto[0]);
        inserisciNome.setText(prodotto[1]);
        inserisciDescrizione.setText(prodotto[2]);
        inserisciCategoria.setText(prodotto[3]);
        inserisciSoglia.setText(prodotto[4]);
        inserisciPosizione.setText(prodotto[5]);

        impostaCampiModificaAbilitati(true);
    }

    private void pulisciProdotto() {
        idProdottoSelezionato = null;
        valoreId.setText("-");
        inserisciNome.setText("");
        inserisciDescrizione.setText("");
        inserisciCategoria.setText("");
        inserisciSoglia.setText("");
        inserisciPosizione.setText("");
        impostaCampiModificaAbilitati(false);
    }

    private void modificaProdottoValidazione() {
        if (idProdottoSelezionato == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Specificare il prodotto da modificare.",
                    "Errore di modifica",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

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

        int sogliaMinimaInt;

        if (sogliaMinimaString.isEmpty()) {
            sogliaMinimaInt = 0;
        } else {
            try {
                sogliaMinimaInt =
                        Integer.parseInt(sogliaMinimaString);

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

        int esito =
                ControllerResponsabile.modificaProdotto(
                        idProdottoSelezionato,
                        nome,
                        descrizione,
                        categoria,
                        sogliaMinimaInt,
                        posizione
                );

        if (esito == ControllerResponsabile.PRODOTTO_MODIFICATO_SUCCESSO) {
            JOptionPane.showMessageDialog(
                    null,
                    "Prodotto modificato con successo.",
                    "Modifica prodotto",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else if (esito == ControllerResponsabile.PRODOTTO_GIA_PRESENTE) {
            JOptionPane.showMessageDialog(
                    null,
                    "Esiste già un prodotto con questo nome.",
                    "Errore di modifica",
                    JOptionPane.ERROR_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Errore durante la modifica del prodotto.",
                    "Errore di modifica",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    /*TEST INTERFACCIA
    public static void main(String[] args) {

        ModificaProdottoBoundary modificaProdottoBoundary =
                new ModificaProdottoBoundary();

        modificaProdottoBoundary.apriModificaProdotto();
    }*/

}
