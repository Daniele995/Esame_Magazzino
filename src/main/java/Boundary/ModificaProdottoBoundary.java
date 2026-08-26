package Boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaProdottoBoundary {

    private JPanel modificaProdottoPanel;

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

        modificaProdotto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //creaProdottoValidazione();
            }
        });
    }

    public void apriModificaProdotto() {
        JFrame frame = new JFrame("Crea Prodotto");
        frame.setContentPane(this.modificaProdottoPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    //TEST INTERFACCIA
    public static void main(String[] args) {

        ModificaProdottoBoundary modificaProdottoBoundary =
                new ModificaProdottoBoundary();

        modificaProdottoBoundary.apriModificaProdotto();
    }


}
