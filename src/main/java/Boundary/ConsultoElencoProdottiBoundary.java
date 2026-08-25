package Boundary;
import Controller.ControllerOperatore;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConsultoElencoProdottiBoundary {
    private JPanel consultoElencoProdotti;
    private JTable elencoProdotti;
    private JButton applica;
    private JTextField filtro;
    private boolean datiDisponibili = true;


    public ConsultoElencoProdottiBoundary() {
        // Attributi dell'elenco da mostrare
        String[] elenco = {"ID", "Nome Prodotto", "Descrizione", "Categoria", "Soglia Minima", "Posizione", "Quantità disponibile"};

        DefaultTableModel modelloTabella = new DefaultTableModel(elenco, 0);

        ControllerOperatore controller = new ControllerOperatore();
        List<String[]> listaProdotti = controller.getElencoProdotti();

        if (listaProdotti != null && !listaProdotti.isEmpty()) {
            for (String[] rigaProdotto : listaProdotti) {
                modelloTabella.addRow(rigaProdotto);
            }
            elencoProdotti.setModel(modelloTabella);

        }else {
            datiDisponibili = false;

        }

        // se viene applicato il filtro
        applica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String categoriaInserita = filtro.getText();

                if (categoriaInserita != null && !categoriaInserita.isEmpty()) {
                    List<String[]> risultati = controller.getProdottiPerCategoria(categoriaInserita);

                    if (risultati != null && !risultati.isEmpty()) {
                        modelloTabella.setRowCount(0);
                        for (String[] riga : risultati) {
                            modelloTabella.addRow(riga);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Nessun prodotto corrisponde al filtro applicato!");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Errore: categoria non inserita correttamente!");

                }

            }
        });

    }

    public JFrame apriConsultoElenco() {
        if (!datiDisponibili) {
            JOptionPane.showMessageDialog(null,
                    "Al momento non ci sono prodotti registrati nel magazzino.",
                    "Attenzione",
                    JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        JFrame frameElenco = new JFrame("Elenco Prodotti");
        frameElenco.setContentPane(this.consultoElencoProdotti);
        frameElenco.pack();
        frameElenco.setLocationRelativeTo(null);
        frameElenco.setVisible(true);
        return frameElenco;
    }
}
