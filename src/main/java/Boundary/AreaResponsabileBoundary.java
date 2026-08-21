package Boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaResponsabileBoundary {
    private JPanel areaResponsabilePannel;
    private JButton gestioneAnagrafica;
    private JButton visualizzaStoricoMovimenti;
    private JButton visualizzaSituazioneMagazzino;
    private JButton andamentoComplessivo;


    public AreaResponsabileBoundary() {
        gestioneAnagrafica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriGestioneAnagrafica();
            }
        });
        visualizzaStoricoMovimenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriStoricoMovimenti();
            }
        });
        visualizzaSituazioneMagazzino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriSituazioneAggiornata();
            }
        });
        andamentoComplessivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apriAndamentoComplessivo();
            }
        });
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

    public JPanel apriFormResponsabilePannel() {
        return areaResponsabilePannel;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Area Responsabile");

            AreaResponsabileBoundary areaResponsabile = new AreaResponsabileBoundary();

            frame.setContentPane(areaResponsabile.apriFormResponsabilePannel());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
