package Boundary;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultoStoricoOperazioniBoundary {
    private JPanel consultoStoricoOperazioniPanel;
    private JTable consultoStoricoOperazioni;


    public ConsultoStoricoOperazioniBoundary() {
        String[] colonne = {"Id", "Prodotto", "Quantità"};
        Object[][] dati = {
                {"1", "Lavatrice", "15"},
                {"2", "Forno", "8"}
        };

        DefaultTableModel modelloTabella = new DefaultTableModel(dati, colonne);
        consultoStoricoOperazioni.setModel(modelloTabella);
    }


    public JFrame apriConsultoStoricoOperazioni(){
        JFrame frameOperatore = new JFrame("Consulto Storico Operazioni");
        frameOperatore.setContentPane(this.consultoStoricoOperazioniPanel);
        frameOperatore.pack();
        frameOperatore.setLocationRelativeTo(null);
        frameOperatore.setVisible(true);
        return frameOperatore;
    }
}
