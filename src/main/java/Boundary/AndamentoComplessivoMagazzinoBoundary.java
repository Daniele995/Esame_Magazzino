package Boundary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AndamentoComplessivoMagazzinoBoundary {
    private JTextField dataInizioField;
    private JTextField dataFineField;
    private JLabel daLabel;
    private JLabel aLabel;
    private JButton aggiornaButton;
    private JTable movimentiTable;
    private JLabel frequentiLabel;
    private JTable movFrequentiTable;
    private JLabel sottoScortaLabel;
    private JTable sottoScortaTable;
    private JPanel andamentoComplessivoPanel;

    public AndamentoComplessivoMagazzinoBoundary(){
        String[] colonneMovimenti = {"Prodotto", "Quantità", "Tipo Movimento"};
        DefaultTableModel modelloMovimenti = new DefaultTableModel(colonneMovimenti, 0);
        movimentiTable.setModel(modelloMovimenti);

        String[] colonneFrequenti = {"Prodotto", "Quantità", "Tipo Movimento", "Numero Movimenti"};
        DefaultTableModel modelloFrequenti = new DefaultTableModel(colonneFrequenti, 0);
        movFrequentiTable.setModel(modelloFrequenti);

        String[] colonneSottoScorta = {"Prodotto", "Quantità disponibile"};
        DefaultTableModel modelloSottoScorta = new DefaultTableModel(colonneSottoScorta, 0);
        sottoScortaTable.setModel(modelloSottoScorta);
    }

    public void apriAndamentoComplessivo(){
        JFrame frame = new JFrame("Andamento Complessivo");
        AndamentoComplessivoMagazzinoBoundary andamentoComplessivo = new AndamentoComplessivoMagazzinoBoundary();
        frame.setContentPane(andamentoComplessivo.getAndamentoComplessivoPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getAndamentoComplessivoPanel() {
        return andamentoComplessivoPanel;
    }
}
