import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrokioscos {
    private JTextField Textfieldcodigokiosco;
    private JTextField Textfieldnombrekiosco;
    private JTextField Textfieldcodigoregion;
    private JButton registrarkioscobutton;
    public JPanel Jpanelregitrokioscos;
    private JButton Regresarbutton;

    public Registrokioscos() {
    registrarkioscobutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Textfieldcodigokiosco.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN CÓDIGO", "Error", JOptionPane.ERROR_MESSAGE);
                Textfieldnombrekiosco.setText("");
                Textfieldcodigoregion.setText("");
                Textfieldcodigokiosco.setText("");
                return;
            }
            if (Textfieldcodigoregion.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN CÓDIGO DE REGIÓN", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Textfieldnombrekiosco.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NOMBRE", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Main.evitarkioscosrepetidos(Textfieldcodigokiosco.getText())) {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR, CÓDIGO YA EXISTENTE", "Error", JOptionPane.ERROR_MESSAGE);
                Textfieldnombrekiosco.setText("");
                Textfieldcodigoregion.setText("");
                Textfieldcodigokiosco.setText("");
                return;
            }
            Main.kioscos.add(new Kiosco(Textfieldcodigokiosco.getText(), Textfieldcodigoregion.getText(), Textfieldnombrekiosco.getText()));
            JOptionPane.showMessageDialog(null, "Kiosco correctamente registrado");
            Textfieldnombrekiosco.setText("");
            Textfieldcodigoregion.setText("");
            Textfieldcodigokiosco.setText("");
        }
    });
        Regresarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new Administrador().JPanelAdmin);
                Main.frame.pack();
                Main.frame.setSize(600,800);
            }
        });
    }
}
