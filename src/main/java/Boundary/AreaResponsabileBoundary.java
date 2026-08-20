package Boundary;

import javax.swing.*;

public class AreaResponsabileBoundary {
    private JPanel areaResponsabilePannel;
    private JButton gestioneAnagrafica;
    private JButton visualizzaStoricoMovimenti;
    private JButton visualizzaSituazioneMagazzino;
    private JButton andamentoComplessivo;


    public AreaResponsabileBoundary() {
        gestioneAnagrafica.addActionListener(e -> apriGestioneAnagrafica());
        visualizzaStoricoMovimenti.addActionListener(e -> apriStoricoMovimenti());
        visualizzaSituazioneMagazzino.addActionListener(e -> apriSituazioneAggiornata());
        andamentoComplessivo.addActionListener(e -> apriAndamentoComplessivo());
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

    public void apriSituazioneAggiornata(){
        JFrame frame = new JFrame("Situazione Aggiornata");

        SituazioneAggiornataMagazzinoBoundary situazioneAggiornataBoundary = new SituazioneAggiornataMagazzinoBoundary();
        frame.setContentPane(situazioneAggiornataBoundary.getSituazioneAggiornataMagazzinoPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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

    public void apriGestioneAnagrafica() {
        JFrame frame = new JFrame("Gestione Anagrafica");

        GestioneAnagraficaBoundary anagraficaBoundary = new GestioneAnagraficaBoundary();
        frame.setContentPane(anagraficaBoundary.getGestioneAnagraficaPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getAreaResponsabilePannel() {
        return areaResponsabilePannel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Area Responsabile");

            AreaResponsabileBoundary areaResponsabile = new AreaResponsabileBoundary();

            frame.setContentPane(areaResponsabile.getAreaResponsabilePannel());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
