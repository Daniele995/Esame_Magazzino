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

    public JPanel getStoricoCompletoMovimentiPanel() {
        return storicoCompletoMovimentiPanel;
    }
}
