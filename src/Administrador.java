import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrador {
    private JButton manejoDeKioscosButton;
    private JButton regresarButton;
    private JButton reportesButton;
    private JButton manejoDeRegionesYButton;
    private JButton manejoDeDepartamentosYButton;
    public JPanel JPanelAdmin;

    public Administrador() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.frame.setContentPane(new Autenticacion().panelAutenticacion);
            Main.frame.pack();
            Main.frame.setSize(600,800);
        }
    });
        manejoDeKioscosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new Registrokioscos().Jpanelregitrokioscos);
                Main.frame.pack();
                Main.frame.setSize(600,800);
            }
        });
    }
}
