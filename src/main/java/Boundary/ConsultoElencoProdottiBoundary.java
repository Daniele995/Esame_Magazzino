package Boundary;
import Controller.ControllerOperatore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ConsultoElencoProdottiBoundary {
    private JPanel consultoElencoProdotti;
    private JTable elencoProdotti;



    public ConsultoElencoProdottiBoundary() {
        String[] colonne = {"ID", "Nome Prodotto", "Descrizione", "Categoria", "Soglia Minima", "Posizione", "Quantità disponibile"};

        DefaultTableModel modelloTabella = new DefaultTableModel(colonne, 0);

        ControllerOperatore controller = new ControllerOperatore();
        List<String[]> listaProdotti = controller.getElencoProdotti();

        if (listaProdotti != null) {
            for (String[] rigaProdotto : listaProdotti) {
                modelloTabella.addRow(rigaProdotto);
            }
        }
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
