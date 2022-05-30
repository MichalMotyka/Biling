package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Odczyt {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTable table;
    private JTextField textField_6;
    private JTextField textField_7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Odczyt window = new Odczyt();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Odczyt() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1074, 438);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBounds(10, 145, 129, 246);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_6 = new JLabel("Rejestr proces\u00F3w");
        lblNewLabel_6.setForeground(Color.BLUE);
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(10, 10, 109, 13);
        panel.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Rejestr Ruch\u00F3w");
        lblNewLabel_7.setForeground(Color.BLUE);
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setBounds(0, 43, 129, 13);
        panel.add(lblNewLabel_7);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBounds(10, 10, 1040, 125);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Numer umowy");
        lblNewLabel.setBounds(10, 10, 86, 13);
        panel_1.add(lblNewLabel);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(106, 7, 216, 19);
        panel_1.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Numer odczytu");
        lblNewLabel_1.setBounds(10, 47, 94, 13);
        panel_1.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setBounds(106, 44, 216, 19);
        panel_1.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("P\u0142atnik");
        lblNewLabel_2.setBounds(10, 82, 45, 13);
        panel_1.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setBounds(106, 79, 216, 19);
        panel_1.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Numer FPP");
        lblNewLabel_3.setBounds(332, 10, 94, 13);
        panel_1.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setBounds(436, 7, 198, 19);
        panel_1.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Licznik");
        lblNewLabel_4.setBounds(332, 47, 45, 13);
        panel_1.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setBounds(436, 44, 198, 19);
        panel_1.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Odbiorca");
        lblNewLabel_5.setBounds(332, 82, 85, 13);
        panel_1.add(lblNewLabel_5);

        JButton btnNewButton_1 = new JButton("Anuluj");
        btnNewButton_1.setBounds(835, 78, 85, 21);
        panel_1.add(btnNewButton_1);

        JButton btnNewButton = new JButton("Zatwierd\u017A");
        btnNewButton.setBounds(936, 78, 94, 21);
        panel_1.add(btnNewButton);

        textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setBounds(436, 79, 198, 19);
        panel_1.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Data odczytu");
        lblNewLabel_8.setBounds(644, 10, 94, 13);
        panel_1.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Rodzaj odczytu");
        lblNewLabel_9.setBounds(644, 47, 94, 13);
        panel_1.add(lblNewLabel_9);

        textField_6 = new JTextField();
        textField_6.setEditable(false);
        textField_6.setBounds(748, 7, 207, 19);
        panel_1.add(textField_6);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setEditable(false);
        textField_7.setBounds(748, 44, 207, 19);
        panel_1.add(textField_7);
        textField_7.setColumns(10);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_2.setBounds(149, 147, 901, 244);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 901, 244);
        panel_2.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Sk\u0142adnik", "Data poprzedniego odczytu", "Wskazanie poprzednie", "Wskazanie bie\u017Cace", "Zu\u017Cycie", "Komunikat"
                }
        ));
        scrollPane.setViewportView(table);
    }
}
