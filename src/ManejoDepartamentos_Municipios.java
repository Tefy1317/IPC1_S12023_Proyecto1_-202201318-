import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
public class ManejoDepartamentos_Municipios {
    private JComboBox<Departamentos> DepartamentoscomboBox;
    private JButton registrardepartamentoButton;
    private JButton modificardepartamentoButton;
    private JButton eliminardepartamentoButton;
    private JComboBox<Municipios> MunicipioscomboBox;
    private JTextField Textnombremunicipio;
    private JButton registrarmunicipioButton;
    private JButton modificarmunicipioButton;
    private JButton eliminarmunicipioButton;
    private JButton regresarButton;
    private JComboBox<Regiones> CodRegioncomboBox;
    private JComboBox<Departamentos> Coddepartamentocombobox;
    private JTextField Textnombredepartamento;
    public JPanel JPanelDepartamentos_mun;
    private JButton mostrarcomboboxButton;
    private JButton mostrarmunicipiosButton;
    private JTextField textFieldcodigodep;
    private JButton generarCodigoButton;

    public ManejoDepartamentos_Municipios() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(new Administrador().JPanelAdmin);
                Main.frame.pack();
                Main.frame.setSize(1000, 1000);
            }
        });
        registrardepartamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexseleccion = CodRegioncomboBox.getSelectedIndex();
                Regiones seleccion = Main.regiones.get(indexseleccion);

                if (Textnombredepartamento.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NOMBRE", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (textFieldcodigodep.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN CÓDIGO", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Main.evitardepartamentosrepetidos(Textnombredepartamento.getText())) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR, DEPARTAMENTO YA EXISTENTE", "Error", JOptionPane.ERROR_MESSAGE);
                    Textnombredepartamento.setText("");
                    textFieldcodigodep.setText("");
                    return;
                }

                Main.departamentos.add(new Departamentos(seleccion.getCodigoregion(), seleccion.getNombreregion(), seleccion.getPrecioestandar(), seleccion.getPrecioespecial(), Textnombredepartamento.getText(), textFieldcodigodep.getText()));
                JOptionPane.showMessageDialog(null, "DEPARTAMENTO REGISTRADO CORRECTAMENTE");
                Textnombredepartamento.setText("");
                textFieldcodigodep.setText("");

                CodRegioncomboBox.removeAllItems();
                DepartamentoscomboBox.removeAllItems();
                Coddepartamentocombobox.removeAllItems();
                for (Regiones reg :
                        Main.regiones) {
                    CodRegioncomboBox.addItem(reg);
                }
                for (Departamentos dep :
                        Main.departamentos) {
                    DepartamentoscomboBox.addItem(dep);
                }
                for (Departamentos dep :
                        Main.departamentos) {
                    Coddepartamentocombobox.addItem(dep);
                }
            }
        });
        mostrarcomboboxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CodRegioncomboBox.removeAllItems();
                DepartamentoscomboBox.removeAllItems();
                for (Regiones reg :
                        Main.regiones) {
                    CodRegioncomboBox.addItem(reg);
                }
                for (Departamentos dep :
                        Main.departamentos) {
                    DepartamentoscomboBox.addItem(dep);
                }
            }
        });
        eliminardepartamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexEliminar = DepartamentoscomboBox.getSelectedIndex();
                Main.departamentos.remove(indexEliminar);
                DepartamentoscomboBox.removeAllItems();
                Coddepartamentocombobox.removeAllItems();
                for (Departamentos dep :
                        Main.departamentos) {
                    DepartamentoscomboBox.addItem(dep);
                }
                for (Departamentos dep :
                        Main.departamentos) {
                    Coddepartamentocombobox.addItem(dep);
                }
            }
        });
        generarCodigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = UUID.randomUUID().toString().substring(0, 5);
                textFieldcodigodep.setText(codigo);
            }
        });
        registrarmunicipioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexseleccion = Coddepartamentocombobox.getSelectedIndex();
                Departamentos seleccion = Main.departamentos.get(indexseleccion);

                if (Textnombremunicipio.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NOMBRE", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Main.evitarmunicipiosrepetidos(Textnombremunicipio.getText())) {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR, MUNICIPIO YA EXISTENTE", "Error", JOptionPane.ERROR_MESSAGE);
                    Textnombremunicipio.setText("");
                    return;
                }

                Main.municipios.add(new Municipios(seleccion.getCodigodepartamento(), Textnombremunicipio.getText()));
                JOptionPane.showMessageDialog(null, "MUNICIPIO REGISTRADO CORRECTAMENTE");
                Textnombremunicipio.setText("");

                Coddepartamentocombobox.removeAllItems();
                MunicipioscomboBox.removeAllItems();
                for (Municipios muni :
                        Main.municipios) {
                    MunicipioscomboBox.addItem(muni);
                }
                for (Departamentos dep :
                        Main.departamentos) {
                    Coddepartamentocombobox.addItem(dep);
                }
            }
        });
        eliminarmunicipioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexEliminar = MunicipioscomboBox.getSelectedIndex();
                Main.municipios.remove(indexEliminar);
                MunicipioscomboBox.removeAllItems();
                for (Municipios muni :
                        Main.municipios) {
                    MunicipioscomboBox.addItem(muni);
                }
            }
        });
        modificarmunicipioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexseleccion = MunicipioscomboBox.getSelectedIndex();
                Municipios seleccion = Main.municipios.get(indexseleccion);
                int indexselec = Coddepartamentocombobox.getSelectedIndex();
                Departamentos selec = Main.departamentos.get(indexselec);
                seleccion.setNombremunicipio(Textnombremunicipio.getText());
                seleccion.setCodigodepartamento(selec.getCodigodepartamento());
                JOptionPane.showMessageDialog(null, "REGIÓN MODIFICADA CORRECTAMENTE");
                Textnombremunicipio.setText("");

            }
        });
        modificardepartamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexseleccion = DepartamentoscomboBox.getSelectedIndex();
                Departamentos seleccion = Main.departamentos.get(indexseleccion);
                int indexselec = CodRegioncomboBox.getSelectedIndex();
                Regiones selec = Main.regiones.get(indexselec);

                seleccion.setCodigoregion(selec.getCodigoregion());
                seleccion.setNombreregion(selec.getNombreregion());
                seleccion.setNombredepartamento(Textnombredepartamento.getText());
                seleccion.setCodigodepartamento(textFieldcodigodep.getText());
                JOptionPane.showMessageDialog(null, "REGIÓN MODIFICADA CORRECTAMENTE");
                Textnombredepartamento.setText("");
                textFieldcodigodep.setText("");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DepartamentoscomboBox = new JComboBox<Departamentos>();
        for (Departamentos nombredepartamento :
                Main.departamentos) {
            DepartamentoscomboBox.addItem(nombredepartamento);
        }
        DepartamentoscomboBox = new JComboBox(Main.departamentos.toArray());
        int selecciondep = DepartamentoscomboBox.getSelectedIndex();

        MunicipioscomboBox = new JComboBox<Municipios>();
        for (Municipios m :
                Main.municipios) {
            MunicipioscomboBox.addItem(m);
        }
        MunicipioscomboBox = new JComboBox(Main.municipios.toArray());
        int seleccionmun = MunicipioscomboBox.getSelectedIndex();

        CodRegioncomboBox = new JComboBox<Regiones>();
        for (Regiones reg :
                Main.regiones) {
            CodRegioncomboBox.addItem(reg);
        }
        CodRegioncomboBox = new JComboBox(Main.regiones.toArray());
        int seleccionreg = CodRegioncomboBox.getSelectedIndex();

        Coddepartamentocombobox = new JComboBox<Departamentos>();
        for (Departamentos dep :
                Main.departamentos) {
            Coddepartamentocombobox.addItem(dep);
        }
        Coddepartamentocombobox = new JComboBox(Main.departamentos.toArray());
        int seleccioncodep = Coddepartamentocombobox.getSelectedIndex();

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
        JPanelDepartamentos_mun = new JPanel();
        JPanelDepartamentos_mun.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(12, 10, new Insets(0, 0, 0, 0), -1, -1));
        DepartamentoscomboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        DepartamentoscomboBox.setModel(defaultComboBoxModel1);
        JPanelDepartamentos_mun.add(DepartamentoscomboBox, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Departamentos:");
        JPanelDepartamentos_mun.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        JPanelDepartamentos_mun.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Municipios:");
        JPanelDepartamentos_mun.add(label2, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        MunicipioscomboBox = new JComboBox();
        JPanelDepartamentos_mun.add(MunicipioscomboBox, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Código departamento:");
        JPanelDepartamentos_mun.add(label3, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Nombre:");
        JPanelDepartamentos_mun.add(label4, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Textnombremunicipio = new JTextField();
        JPanelDepartamentos_mun.add(Textnombremunicipio, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        JPanelDepartamentos_mun.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(10, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        Coddepartamentocombobox = new JComboBox();
        JPanelDepartamentos_mun.add(Coddepartamentocombobox, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        JPanelDepartamentos_mun.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        JPanelDepartamentos_mun.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(4, 9, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        JPanelDepartamentos_mun.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        JPanelDepartamentos_mun.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(11, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        mostrarcomboboxButton = new JButton();
        mostrarcomboboxButton.setText("Mostrar");
        JPanelDepartamentos_mun.add(mostrarcomboboxButton, new com.intellij.uiDesigner.core.GridConstraints(1, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Código Región y Región:");
        JPanelDepartamentos_mun.add(label5, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        CodRegioncomboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        CodRegioncomboBox.setModel(defaultComboBoxModel2);
        JPanelDepartamentos_mun.add(CodRegioncomboBox, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registrardepartamentoButton = new JButton();
        registrardepartamentoButton.setText("Registrar");
        JPanelDepartamentos_mun.add(registrardepartamentoButton, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Nombre:");
        JPanelDepartamentos_mun.add(label6, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Textnombredepartamento = new JTextField();
        Textnombredepartamento.setText("");
        JPanelDepartamentos_mun.add(Textnombredepartamento, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        eliminardepartamentoButton = new JButton();
        eliminardepartamentoButton.setText("Eliminar");
        JPanelDepartamentos_mun.add(eliminardepartamentoButton, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        modificardepartamentoButton = new JButton();
        modificardepartamentoButton.setText("Modificar");
        JPanelDepartamentos_mun.add(modificardepartamentoButton, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldcodigodep = new JTextField();
        JPanelDepartamentos_mun.add(textFieldcodigodep, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        generarCodigoButton = new JButton();
        generarCodigoButton.setText("Generar código");
        JPanelDepartamentos_mun.add(generarCodigoButton, new com.intellij.uiDesigner.core.GridConstraints(4, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Código departamento:");
        JPanelDepartamentos_mun.add(label7, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        regresarButton = new JButton();
        regresarButton.setText("Regresar");
        JPanelDepartamentos_mun.add(regresarButton, new com.intellij.uiDesigner.core.GridConstraints(9, 6, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registrarmunicipioButton = new JButton();
        registrarmunicipioButton.setText("Registrar");
        JPanelDepartamentos_mun.add(registrarmunicipioButton, new com.intellij.uiDesigner.core.GridConstraints(7, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        eliminarmunicipioButton = new JButton();
        eliminarmunicipioButton.setText("Eliminar");
        JPanelDepartamentos_mun.add(eliminarmunicipioButton, new com.intellij.uiDesigner.core.GridConstraints(8, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        modificarmunicipioButton = new JButton();
        modificarmunicipioButton.setText("Modificar");
        JPanelDepartamentos_mun.add(modificarmunicipioButton, new com.intellij.uiDesigner.core.GridConstraints(7, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPanelDepartamentos_mun;
    }

}
