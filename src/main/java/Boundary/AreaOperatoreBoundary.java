package Boundary;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaOperatoreBoundary {
    private JPanel areaOperatorePanel;
    private JButton consultoElenco;
    private JButton registraMovimento;
    private JButton consultaStoricoOperazioni;


    public AreaOperatoreBoundary() {
        consultoElenco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ConsultoElencoProdottiBoundary elencoBoundary = new ConsultoElencoProdottiBoundary();
                elencoBoundary.apriConsultoElenco();
            }
        });
        registraMovimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistraMovimentiBoundary registraMovimento = new RegistraMovimentiBoundary();
                registraMovimento.apriRegistraMovimento();
            }
        });
        consultaStoricoOperazioni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultoStoricoOperazioniBoundary consulta = new ConsultoStoricoOperazioniBoundary();
                consulta.apriConsultoStoricoOperazioni();
            }
        });
    }

    public JFrame apriFormOperatore(){
        JFrame frameOperatore = new JFrame("area operatore");
        frameOperatore.setContentPane(this.areaOperatorePanel);
        frameOperatore.pack();
        frameOperatore.setLocationRelativeTo(null);
        frameOperatore.setVisible(true);
        return frameOperatore;
    }
}
