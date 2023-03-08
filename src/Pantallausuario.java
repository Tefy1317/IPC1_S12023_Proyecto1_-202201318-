import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantallausuario {
    public JPanel JPanePanUsuario;
    private JButton regresarButton;
public Pantallausuario() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.frame.setContentPane(new Autenticacion().panelAutenticacion);
            Main.frame.pack();
            Main.frame.setSize(600,800);
        }
    });
}
}
