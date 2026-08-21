package Boundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaResponsabileBoundary {
    private JPanel areaResponsabilePanel;
    private JButton gestioneAnagrafica;
    private JButton visualizzaStoricoMovimenti;
    private JButton visualizzaSituazioneMagazzino;
    private JButton andamentoComplessivo;


    public AreaResponsabileBoundary() {
        gestioneAnagrafica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                GestioneAnagraficaBoundary gestioneAnagrafica = new GestioneAnagraficaBoundary();
                gestioneAnagrafica.apriGestioneAnagrafica();
            }
        });
        visualizzaStoricoMovimenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoricoCompletoMovimentiBoundary storicoCompleto = new StoricoCompletoMovimentiBoundary();
                storicoCompleto.apriStoricoMovimenti();
            }
        });
        visualizzaSituazioneMagazzino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SituazioneAggiornataMagazzinoBoundary situazioneAggiornata = new SituazioneAggiornataMagazzinoBoundary();
                situazioneAggiornata.apriSituazioneAggiornata();
            }
        });
        andamentoComplessivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AndamentoComplessivoMagazzinoBoundary andamentoComplessivo = new AndamentoComplessivoMagazzinoBoundary();
                andamentoComplessivo.apriAndamentoComplessivo();
            }
        });
    }

    public JPanel apriFormResponsabilePanel() {
        JFrame frame = new JFrame("Area Responsabile");

        AreaResponsabileBoundary areaResponsabile = new AreaResponsabileBoundary();
        frame.setContentPane(this.areaResponsabilePanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return areaResponsabilePanel;
    }

/*
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
    }ù

 */
}
