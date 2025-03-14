import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrokioscos {
    private JTextField Textfieldcodigokiosco;
    private JTextField Textfieldnombrekiosco;
    private JButton registrarkioscobutton;
    public JPanel Jpanelregitrokioscos;
    private JButton Regresarbutton;
    private JComboBox<Regiones> CodigoregioncomboBox;
    private JButton mostrarRegionesButton;
    private JComboBox<Kiosco> KioscoscomboBox;

    public Registrokioscos() {
        $$$setupUI$$$();
        registrarkioscobutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Textfieldcodigokiosco.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN CÓDIGO", "Error", JOptionPane.ERROR_MESSAGE);
                    Textfieldnombrekiosco.setText("");
                    Textfieldcodigokiosco.setText("");
                    return;
                }
                if (Textfieldnombrekiosco.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NOMBRE", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Main.evitarkioscosrepetidos(Textfieldnombrekiosco.getText())) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR, NOMBRE DE KIOSCO YA EXISTENTE", "Error", JOptionPane.ERROR_MESSAGE);
                    Textfieldnombrekiosco.setText("");
                    return;
                }
                if (Main.evitarcodigokioscosrepetidos(Textfieldcodigokiosco.getText())) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR, CÓDIGO YA EXISTENTE", "Error", JOptionPane.ERROR_MESSAGE);
                    Textfieldcodigokiosco.setText("");
                    return;
                }
                int indexseleccion = CodigoregioncomboBox.getSelectedIndex();
                Regiones seleccion = Main.regiones.get(indexseleccion);

                Main.kioscos.add(new Kiosco(Textfieldcodigokiosco.getText(), Textfieldnombrekiosco.getText(), seleccion.getCodigoregion()));
                JOptionPane.showMessageDialog(null, "KIOSCO REGISTRADO CORRECTAMENTE");
                Textfieldnombrekiosco.setText("");
                Textfieldcodigokiosco.setText("");
                CodigoregioncomboBox.removeAllItems();
                KioscoscomboBox.removeAllItems();
                for (Regiones reg :
                        Main.regiones) {
                    CodigoregioncomboBox.addItem(reg);
                }
                for (Kiosco k :
                        Main.kioscos) {
                    KioscoscomboBox.addItem(k);
                }
            }
        });
        Regresarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new Administrador().JPanelAdmin);
                Main.frame.pack();
                Main.frame.setSize(1000, 1000);
            }
        });
        mostrarRegionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodigoregioncomboBox.removeAllItems();
                for (Regiones reg :
                        Main.regiones) {
                    CodigoregioncomboBox.addItem(reg);
                }
            }
        });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Jpanelregitrokioscos = new JPanel();
        Jpanelregitrokioscos.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 10, new Insets(0, 0, 0, 0), -1, -1));
        Textfieldcodigokiosco = new JTextField();
        Jpanelregitrokioscos.add(Textfieldcodigokiosco, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        Jpanelregitrokioscos.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(2, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Código kiosco:");
        Jpanelregitrokioscos.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        Jpanelregitrokioscos.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        Textfieldnombrekiosco = new JTextField();
        Jpanelregitrokioscos.add(Textfieldnombrekiosco, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        Jpanelregitrokioscos.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Nombre kiosco:");
        Jpanelregitrokioscos.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Código región:");
        Jpanelregitrokioscos.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        Jpanelregitrokioscos.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        Jpanelregitrokioscos.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(1, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        Jpanelregitrokioscos.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        registrarkioscobutton = new JButton();
        registrarkioscobutton.setText("Registrar");
        Jpanelregitrokioscos.add(registrarkioscobutton, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Regresarbutton = new JButton();
        Regresarbutton.setText("Regresar");
        Jpanelregitrokioscos.add(Regresarbutton, new com.intellij.uiDesigner.core.GridConstraints(3, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CodigoregioncomboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        CodigoregioncomboBox.setModel(defaultComboBoxModel1);
        Jpanelregitrokioscos.add(CodigoregioncomboBox, new com.intellij.uiDesigner.core.GridConstraints(2, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mostrarRegionesButton = new JButton();
        mostrarRegionesButton.setText("Mostrar");
        Jpanelregitrokioscos.add(mostrarRegionesButton, new com.intellij.uiDesigner.core.GridConstraints(2, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Kioscos registrados:");
        Jpanelregitrokioscos.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        KioscoscomboBox = new JComboBox();
        Jpanelregitrokioscos.add(KioscoscomboBox, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Jpanelregitrokioscos;
    }

}
