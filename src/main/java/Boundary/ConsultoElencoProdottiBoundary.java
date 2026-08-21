package Boundary;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultoElencoProdottiBoundary {
    private JPanel consultoElencoProdotti;
    private JTable elencoProdotti;



    public ConsultoElencoProdottiBoundary() {
        String[] colonne = {"ID", "Nome Prodotto", "Quantità"};
        Object[][] dati = {
                {"1", "Lavatrice", "15"},
                {"2", "Forno", "8"}
        };

        DefaultTableModel modelloTabella = new DefaultTableModel(dati, colonne);
        elencoProdotti.setModel(modelloTabella);
    }

    public JFrame apriConsultoElenco() {
        JFrame frameElenco = new JFrame("Elenco Prodotti");
        frameElenco.setContentPane(this.consultoElencoProdotti);
        frameElenco.pack();
        frameElenco.setLocationRelativeTo(null);
        frameElenco.setVisible(true);
        return frameElenco;
    }
}
