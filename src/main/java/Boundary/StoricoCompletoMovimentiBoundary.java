package Boundary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StoricoCompletoMovimentiBoundary {
    private JPanel storicoCompletoMovimentiPanel;
    private JTable storicoCompleto;

    public StoricoCompletoMovimentiBoundary(){
        String[] colonne = {"Data", "ID Prodotto", "Tipo Movimento", "Quantità", "Operatore"};
        DefaultTableModel modelloTabella = new DefaultTableModel(colonne, 0);
        storicoCompleto.setModel(modelloTabella);
    }

    public void apriStoricoMovimenti() {
        JFrame frame = new JFrame("Storico Movimenti");

        StoricoCompletoMovimentiBoundary storicoMovimentiBoundary = new StoricoCompletoMovimentiBoundary();
        frame.setContentPane(storicoMovimentiBoundary.getStoricoCompletoMovimentiPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getStoricoCompletoMovimentiPanel() {
        return storicoCompletoMovimentiPanel;
    }
}
