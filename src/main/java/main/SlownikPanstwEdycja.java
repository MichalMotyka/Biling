package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SlownikPanstwEdycja extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private static int operacje = 1;
    private static String panstwo = null;
    private String Skraj;
    SlownikAdresow SA = new SlownikAdresow();
    static JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3;

    /**
     * Launch the application.
     */
    public static void main(int operacja, String panstwa) {
        operacje = operacja;
        panstwo = panstwa;
        try {
            SlownikPanstwEdycja dialog = new SlownikPanstwEdycja();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public SlownikPanstwEdycja() throws SQLException {
        setBounds(100, 100, 269, 253);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            lblNewLabel = new JLabel("Kraj");
            lblNewLabel.setBounds(10, 21, 46, 14);
            contentPanel.add(lblNewLabel);
        }
        {
            textField = new JTextField();
            textField.setBounds(99, 18, 130, 20);
            contentPanel.add(textField);
            textField.setColumns(10);
        }
        {
            lblNewLabel_1 = new JLabel("Prefix");
            lblNewLabel_1.setBounds(10, 58, 46, 14);
            contentPanel.add(lblNewLabel_1);
        }
        {
            textField_1 = new JTextField();
            textField_1.setBounds(99, 55, 130, 20);
            contentPanel.add(textField_1);
            textField_1.setColumns(10);
        }
        {
            lblNewLabel_2 = new JLabel("Maska Kodu");
            lblNewLabel_2.setBounds(10, 96, 79, 14);
            contentPanel.add(lblNewLabel_2);
        }
        {
            textField_2 = new JTextField();
            textField_2.setBounds(99, 93, 130, 20);
            contentPanel.add(textField_2);
            textField_2.setColumns(10);
        }
        {
            lblNewLabel_3 = new JLabel("Maska GUS");
            lblNewLabel_3.setBounds(10, 133, 66, 14);
            contentPanel.add(lblNewLabel_3);
        }
        {
            textField_3 = new JTextField();
            textField_3.setBounds(99, 130, 130, 20);
            contentPanel.add(textField_3);
            textField_3.setColumns(10);
        }
        if (operacje == 0) {
            ResultSet rs = SA.getPantwo(panstwo);
            if (rs.next()) {
                Skraj = rs.getString("Panstwo");
                textField.setText(rs.getString("Panstwo"));
                textField_1.setText(rs.getString("Prefix"));
                textField_2.setText(rs.getString("MaskaKodu"));
                textField_3.setText(rs.getString("MaskaGus"));
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!textField.getText().equals(null) && !textField.getText().equals("") && !textField_1.getText().equals(null) && !textField_1.getText().equals("")
                                && !textField_2.getText().equals(null) && !textField_2.getText().equals("") && !textField_3.getText().equals(null) && !textField_3.getText().equals("")) {
                            if (!(textField_1.getText().length() > 3)) {
                                SlownikAdresow SA = new SlownikAdresow();
                                ResultSet rs = SA.getPantwo(textField.getText());
                                try {
                                    if (!rs.next()) {
                                        if (operacje == 1) {

                                            SA.DodKraj(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
                                            SlownikPanstw.UpdateDATA();
                                            dispose();


                                        }
                                        if (operacje == 0) {
                                            SA.EditKraj(Skraj, textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
                                            SlownikPanstw.UpdateDATA();
                                            dispose();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Kraj o podanej nazwie istnieje już w systemie");
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Podany prefix jest zbyt długi, maksymalna długość to 3 znaki");
                            }
                        } else {
                            Object[] polatekstowe = new Object[8];
                            polatekstowe[0] = textField.getText();
                            polatekstowe[1] = textField_1.getText();
                            polatekstowe[2] = textField_2.getText();
                            polatekstowe[3] = textField_3.getText();
                            JLabel[] lbl = new JLabel[4];
                            lbl[0] = lblNewLabel;
                            lbl[1] = lblNewLabel_1;
                            lbl[2] = lblNewLabel_2;
                            lbl[3] = lblNewLabel_3;
                            for (int i = 0; i <= 3; i++) {
                                if (polatekstowe[i].equals(null) || polatekstowe[i].equals("")) {
                                    lbl[i].setForeground(Color.RED);
                                }
                            }
                            for (int i = 0; i <= 3; i++) {
                                if (!polatekstowe[i].equals(null) && !polatekstowe[i].equals("")) {
                                    lbl[i].setForeground(Color.BLACK);
                                }
                            }
                        }
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }

    }

}
