import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroRegiones {
    private JButton registrarRegionButton;
    public JPanel JPanelRegistroregion;
    private JTextField TextCodigoregion;
    private JTextField Textnombre;
    private JTextField Textprecioespecial;
    private JTextField Textprecioestandar;
    private JButton regresarButton;
    private JPanel Jpanelregiones;
    private JComboBox<Regiones> comboBox1;
    private JButton eliminarRegionButton;
    private JButton modificarRegionButton;
    private JButton mostrarRegionesButton;

    public RegistroRegiones() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new Administrador().JPanelAdmin);
                Main.frame.pack();
                Main.frame.setSize(1000, 1000);
            }
        });

        registrarRegionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TextCodigoregion.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN CÓDIGO", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Textnombre.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NOMBRE", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Textprecioestandar.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN PRECIO ESTÁNDAR", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Textprecioespecial.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN PRECIO ESPECIAL", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Main.evitarregionesrepetidas(TextCodigoregion.getText())) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR, REGIÓN YA EXISTENTE", "Error", JOptionPane.ERROR_MESSAGE);
                    TextCodigoregion.setText("");
                    Textnombre.setText("");
                    Textprecioespecial.setText("");
                    Textprecioestandar.setText("");
                    return;
                }

                Main.regiones.add(new Regiones(TextCodigoregion.getText(), Textnombre.getText(), Double.parseDouble(Textprecioestandar.getText()), Double.parseDouble(Textprecioespecial.getText())));
                JOptionPane.showMessageDialog(null, "REGIÓN REGISTRADA CORRECTAMENTE");
                TextCodigoregion.setText("");
                Textnombre.setText("");
                Textprecioespecial.setText("");
                Textprecioestandar.setText("");
                llenarcombobox();
            }

        });
        eliminarRegionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexEliminar = comboBox1.getSelectedIndex();
                Main.regiones.remove(indexEliminar);
                llenarcombobox();
            }
        });
        modificarRegionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexseleccion = comboBox1.getSelectedIndex();
                Regiones seleccion = Main.regiones.get(indexseleccion);

                seleccion.setCodigoregion(TextCodigoregion.getText());
                seleccion.setNombreregion(Textnombre.getText());
                seleccion.setPrecioestandar(Double.parseDouble(Textprecioestandar.getText()));
                seleccion.setPrecioespecial(Double.parseDouble(Textprecioespecial.getText()));
                JOptionPane.showMessageDialog(null, "REGIÓN MODIFICADA CORRECTAMENTE");
                TextCodigoregion.setText("");
                Textnombre.setText("");
                Textprecioespecial.setText("");
                Textprecioestandar.setText("");
            }
        });
        mostrarRegionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarcombobox();
            }
        });
    }

    public void llenarcombobox() {
        comboBox1.removeAllItems();
        for (Regiones c :
                Main.regiones) {
            comboBox1.addItem(c);
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        comboBox1 = new JComboBox<Regiones>();
        for (Regiones c :
                Main.regiones) {
            comboBox1.addItem(c);
        }
        comboBox1 = new JComboBox(Main.regiones.toArray());

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Jpanelregiones = new JPanel();
        Jpanelregiones.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        Jpanelregiones.setPreferredSize(new Dimension(600, 800));
        Jpanelregiones.setRequestFocusEnabled(true);
        JPanelRegistroregion = new JPanel();
        JPanelRegistroregion.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(11, 5, new Insets(0, 0, 0, 0), -1, -1));
        JPanelRegistroregion.setBackground(new Color(-5709123));
        Jpanelregiones.add(JPanelRegistroregion, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 4, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(300, 300), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        JPanelRegistroregion.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 4, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        TextCodigoregion = new JTextField();
        TextCodigoregion.setText("");
        JPanelRegistroregion.add(TextCodigoregion, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        Textnombre = new JTextField();
        Textnombre.setText("");
        JPanelRegistroregion.add(Textnombre, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        Textprecioespecial = new JTextField();
        Textprecioespecial.setText("");
        JPanelRegistroregion.add(Textprecioespecial, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        Textprecioestandar = new JTextField();
        Textprecioestandar.setText("");
        JPanelRegistroregion.add(Textprecioestandar, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Código región:");
        JPanelRegistroregion.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Nombre:");
        JPanelRegistroregion.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Precio Estándar:");
        JPanelRegistroregion.add(label3, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Precio Especial:");
        JPanelRegistroregion.add(label4, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registrarRegionButton = new JButton();
        registrarRegionButton.setText("Registrar región");
        JPanelRegistroregion.add(registrarRegionButton, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        regresarButton = new JButton();
        regresarButton.setText("Regresar");
        JPanelRegistroregion.add(regresarButton, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        JPanelRegistroregion.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(10, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        JPanelRegistroregion.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        eliminarRegionButton = new JButton();
        eliminarRegionButton.setText("Eliminar región");
        JPanelRegistroregion.add(eliminarRegionButton, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        modificarRegionButton = new JButton();
        modificarRegionButton.setText("Modificar región");
        JPanelRegistroregion.add(modificarRegionButton, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        comboBox1.setModel(defaultComboBoxModel1);
        JPanelRegistroregion.add(comboBox1, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("REGIONES:");
        JPanelRegistroregion.add(label5, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mostrarRegionesButton = new JButton();
        mostrarRegionesButton.setText("Mostrar regiones");
        JPanelRegistroregion.add(mostrarRegionesButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        JPanelRegistroregion.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        JPanelRegistroregion.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Jpanelregiones;
    }

}