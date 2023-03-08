import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Autenticacion {
    private JButton buttonIngresar;
    public JPanel panelAutenticacion;
    private JButton buttonRegistar;
    private JTextField TextoUsuario;
    private JTextField TextoPassword;
    private JLabel LabelUsuario;
    private JLabel LabelPassword;
    private String UsuarioAdmin = "admin"; // "ipc1_202201318@ipc1delivery.com";
    private String PasswordAdmin = "123"; //  "202201318";

    //Función Autenticación

    public Autenticacion() {
     buttonIngresar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             if(!TextoUsuario.getText().isEmpty() && !TextoPassword.getText().isEmpty()){
               if(TextoUsuario.getText().equals(UsuarioAdmin) && TextoPassword.getText().equals(PasswordAdmin)){
                   Main.frame.setContentPane(new Administrador().JPanelAdmin);
                   Main.frame.pack();
                   Main.frame.setSize(600,800);
               }else if(Main.evitarrepetidos(TextoUsuario.getText())){
                   Main.frame.setContentPane(new Pantallausuario().JPanePanUsuario);
                   Main.frame.pack();
                   Main.frame.setSize(600,800);
               }else{
                 TextoUsuario.setText("");
                 TextoPassword.setText("");
                 JOptionPane.showMessageDialog(null, "CORREO Y/O CONTRASEÑA INCORRECTA");
               }
             }else{
                 JOptionPane.showMessageDialog(null, "LOS CAMPOS NO PUEDEN ESTAR VACÍOS, INTENTE DE NUEVO");
             }
        }
    });
        buttonRegistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new Registrar().panelRegistrar);
                Main.frame.pack();
                Main.frame.setSize(600,800);
            }
        });
    }
}
