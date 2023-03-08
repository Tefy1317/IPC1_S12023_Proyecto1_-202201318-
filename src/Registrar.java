import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrar {
    public JPanel panelRegistrar;
    private JButton registrarButton;
    private JButton regresarButton;
    private JTextField textCorreo;
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textPassword;
    private JTextField textDPI;
    private JTextField textFechanacimiento;
    private JTextField textGenero;
    private JTextField textalias;
    private JTextField textTelefono;
    private JComboBox comboBoxRol;
    private JComboBox comboBoxNacionalidad;


    public Registrar() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textCorreo.getText().equals("admin")) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR, CORREO YA EXISTENTE", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (textCorreo.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN CORREO", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Main.evitarrepetidos(textCorreo.getText())) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR, CORREO YA EXISTENTE", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nacionalidadselect = comboBoxNacionalidad.getSelectedItem().toString();
                String rolselect = comboBoxRol.getSelectedItem().toString();
                Main.clientes.add(new Cliente(textCorreo.getText(), textNombre.getText(), textApellido.getText(), textPassword.getText(), textDPI.getText(), textFechanacimiento.getText(), textGenero.getText(), nacionalidadselect, textalias.getText(), Integer.parseInt(textTelefono.getText()),rolselect));
                JOptionPane.showMessageDialog(null, "Usuario correctamente registrado");
                textCorreo.setText("");
                textNombre.setText("");
                textApellido.setText("");
                textPassword.setText("");
                textDPI.setText("");
                textFechanacimiento.setText("");
                textalias.setText("");
                textTelefono.setText("");
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new Autenticacion().panelAutenticacion);
                Main.frame.pack();
                Main.frame.setSize(600, 800);
            }
        });
    }}