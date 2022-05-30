package main;

import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EdycjaAdresu extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_4;
    private  JTextField textField_2;
    static int trybedycji;
    private static String NGUS,SNazwa,Nazwa;
    Choice choice = new Choice();
    Choice choice_1 = new Choice();
    SlownikAdresow SA = new SlownikAdresow();

    /**
     * Launch the application.
     */
    public static void main(int tryb, String GUS,String nazwa) {
        try {
            trybedycji = tryb;
            NGUS = GUS;
            Nazwa = nazwa;
            EdycjaAdresu dialog = new EdycjaAdresu();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public EdycjaAdresu() throws SQLException {
        setResizable(false);
        setBounds(100, 100, 346, 299);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nazwa");
        lblNewLabel.setBounds(10, 11, 46, 14);
        contentPanel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(99, 8, 209, 20);
        contentPanel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("GUS");
        lblNewLabel_1.setBounds(10, 47, 46, 14);
        contentPanel.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(99, 44, 209, 20);
        contentPanel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Kod Pocztowy");
        lblNewLabel_4.setBounds(10, 150, 95, 14);
        contentPanel.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setBounds(99, 149, 209, 20);
        contentPanel.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Prefix");
        lblNewLabel_2.setForeground(Color.BLUE);
        lblNewLabel_2.setBounds(10, 175, 46, 14);
        contentPanel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Typ");
        lblNewLabel_3.setForeground(Color.BLUE);
        lblNewLabel_3.setBounds(10, 86, 46, 14);
        contentPanel.add(lblNewLabel_3);


        JLabel lblNewLabel_5 = new JLabel("Poczta");
        lblNewLabel_5.setBounds(10, 125, 79, 14);
        contentPanel.add(lblNewLabel_5);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(99, 118, 209, 20);
        contentPanel.add(textField_2);



        choice.setBounds(99, 80, 209, 20);
        choice.add("miasto na prawach powiatu");
        choice.add("powiat");
        choice.add("miasto");
        choice.add("gmina miejska");
        choice.add("delegatura");
        choice.add("miasto stołeczne, na prawach powiatu");
        choice.add("obszar wiejski");
        choice.add("dzielnica");
        choice.add("gmina wiejska");
        choice.add("województwo");
        contentPanel.add(choice);


        choice_1.setBounds(99, 186, 209, 20);
        ResultSet rs = SA.getKraje();
        while(rs.next()){
            choice_1.add(rs.getString("Prefix"));
        }
        contentPanel.add(choice_1);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @SneakyThrows
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (trybedycji==0){
                            if (SA.setDaneAdresowe(textField_1.getText(),textField.getText(),choice.getSelectedItem().toString(),choice_1.getSelectedItem().toString())==1){
                                JOptionPane.showMessageDialog(null,"Pomyslnie zapisano dane");
                                SlownikAdresGUI.UpdateDATA();
                                dispose();
                            }else{
                                JOptionPane.showMessageDialog(null,"Nie udało się zapisać danych w systemie");
                            }
                        }
                        if (trybedycji==1){
                            if (SA.setDaneAdresowe(textField_1.getText(),textField.getText(),choice.getSelectedItem().toString(),choice_1.getSelectedItem().toString(),textField_4.getText(),textField_2.getText().toString(),NGUS,SNazwa)==1){
                                JOptionPane.showMessageDialog(null,"Pomyslnie zapisano dane");
                                SlownikAdresGUI.UpdateDATA();
                                dispose();
                            }else{
                                JOptionPane.showMessageDialog(null,"Nie udało się zapisać danych w systemie");
                            }
                        }
                    }
                });
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
                buttonPane.add(cancelButton);
            }
            if (trybedycji == 1) {
                wpiszdane();
            }
        }
    }

    public void wpiszdane() {
        ResultSet rs = SA.getDane(NGUS,Nazwa);
        try {
            if (rs.next()) {
                textField.setText(rs.getString("Nazwa"));
                SNazwa = rs.getString("Nazwa");
                textField_1.setText(rs.getString("GUS"));
                choice.select(rs.getString("Typ"));
                choice_1.select(rs.getString("Prefix"));
                String id = rs.getString("id");
                ResultSet rs2 = SA.getKod(id);
                if (rs2.next()) {
                    textField_4.setText(rs2.getString("kod"));
                    textField_2.setText(rs2.getString("Poczta"));
                }
            }
        } catch (SQLException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            JOptionPane.showMessageDialog(null, "Błąd: Nie udało się pobrać danych, skontaktuj się z administratorem systemu \n" + pw.toString());
        }
    }


}

