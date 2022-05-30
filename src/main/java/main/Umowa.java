package main;

import com.toedter.calendar.JDateChooser;
import main.entity.Adres;
import main.entity.kontrahent;
import main.kontrahent.actionKontrahent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class Umowa extends actionKontrahent {

    private JFrame frame;
    private static JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private static JTextField textField_4;
    private static JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTable table;
    private JTable table_1;
    private static Umowa window;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window = new Umowa();
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
    public Umowa() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 671);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 886, 634);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 886, 634);
        panel.add(tabbedPane);

        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Płatnik", null, panel_1, null);
        panel_1.setLayout(null);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_5.setBounds(10, 10, 443, 298);
        panel_1.add(panel_5);
        panel_5.setLayout(null);

        JLabel lblNewLabel = new JLabel("P\u0142atnik");
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KontrahentList kontrahentList = new KontrahentList();
                kontrahentList.getKontrahentFromTable(window);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        lblNewLabel.setBounds(10, 10, 45, 13);
        panel_5.add(lblNewLabel);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(50, 7, 112, 19);
        panel_5.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Adres");
        lblNewLabel_2.setBounds(10, 109, 45, 13);
        panel_5.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setBounds(10, 132, 423, 19);
        panel_5.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("NIP/PESEL");
        lblNewLabel_3.setBounds(10, 181, 75, 13);
        panel_5.add(lblNewLabel_3);

        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setBounds(76, 178, 357, 19);
        panel_5.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Nazwa");
        lblNewLabel_4.setBounds(10, 57, 45, 13);
        panel_5.add(lblNewLabel_4);

        textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setBounds(10, 80, 423, 19);
        panel_5.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Adres korespondencyjny");
        lblNewLabel_5.setBounds(10, 227, 150, 13);
        panel_5.add(lblNewLabel_5);

        textField_6 = new JTextField();
        textField_6.setEditable(false);
        textField_6.setBounds(10, 250, 423, 19);
        panel_5.add(textField_6);
        textField_6.setColumns(10);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_6.setBounds(10, 318, 443, 263);
        panel_1.add(panel_6);
        panel_6.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Odbiorca");
        lblNewLabel_1.setBounds(10, 10, 60, 13);
        lblNewLabel_1.setForeground(Color.BLUE);
        lblNewLabel_1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KontrahentList kontrahentList = new KontrahentList();
                kontrahentList.getKoresKontrahentFromTable(window);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        panel_6.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBounds(62, 7, 112, 19);
        panel_6.add(textField_1);

        JLabel lblNewLabel_2_1 = new JLabel("Adres");
        lblNewLabel_2_1.setBounds(10, 108, 45, 13);
        panel_6.add(lblNewLabel_2_1);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBounds(10, 131, 423, 19);
        panel_6.add(textField_3);

        JLabel lblNewLabel_4_1 = new JLabel("Nazwa");
        lblNewLabel_4_1.setBounds(10, 56, 45, 13);
        panel_6.add(lblNewLabel_4_1);

        textField_7 = new JTextField();
        textField_7.setEditable(false);
        textField_7.setColumns(10);
        textField_7.setBounds(10, 79, 423, 19);
        panel_6.add(textField_7);

        JLabel lblNewLabel_3_1 = new JLabel("NIP/PESEL");
        lblNewLabel_3_1.setBounds(10, 169, 75, 13);
        panel_6.add(lblNewLabel_3_1);

        textField_8 = new JTextField();
        textField_8.setEditable(false);
        textField_8.setColumns(10);
        textField_8.setBounds(76, 166, 357, 19);
        panel_6.add(textField_8);

        JLabel lblNewLabel_5_1 = new JLabel("Adres korespondencyjny");
        lblNewLabel_5_1.setBounds(10, 209, 160, 13);
        panel_6.add(lblNewLabel_5_1);

        textField_9 = new JTextField();
        textField_9.setEditable(false);
        textField_9.setColumns(10);
        textField_9.setBounds(10, 232, 423, 19);
        panel_6.add(textField_9);

        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("New tab", null, panel_3, null);
        panel_3.setLayout(null);

        JPanel panel_7 = new JPanel();
        panel_7.setBounds(10, 10, 861, 546);
        panel_3.add(panel_7);
        panel_7.setLayout(null);

        JLabel lblNewLabel_6 = new JLabel("Tarfya");
        lblNewLabel_6.setForeground(Color.BLUE);
        lblNewLabel_6.setBackground(Color.WHITE);
        lblNewLabel_6.setBounds(10, 224, 45, 13);
        panel_7.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Harmonogram");
        lblNewLabel_7.setForeground(Color.BLUE);
        lblNewLabel_7.setBounds(10, 276, 90, 13);
        panel_7.add(lblNewLabel_7);

        textField_10 = new JTextField();
        textField_10.setEditable(false);
        textField_10.setBounds(20, 247, 279, 19);
        panel_7.add(textField_10);
        textField_10.setColumns(10);

        textField_11 = new JTextField();
        textField_11.setEditable(false);
        textField_11.setBounds(20, 298, 279, 19);
        panel_7.add(textField_11);
        textField_11.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Sk\u0142adniki");
        lblNewLabel_8.setForeground(Color.BLUE);
        lblNewLabel_8.setBounds(10, 327, 45, 13);
        panel_7.add(lblNewLabel_8);

        textField_12 = new JTextField();
        textField_12.setEditable(false);
        textField_12.setBounds(20, 350, 279, 19);
        panel_7.add(textField_12);
        textField_12.setColumns(10);

        JLabel lblNewLabel_10 = new JLabel("Moc umowna");
        lblNewLabel_10.setBounds(10, 379, 96, 13);
        panel_7.add(lblNewLabel_10);

        textField_13 = new JTextField();
        textField_13.setEditable(false);
        textField_13.setBounds(20, 402, 279, 19);
        panel_7.add(textField_13);
        textField_13.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("Cennik");
        lblNewLabel_9.setForeground(Color.BLUE);
        lblNewLabel_9.setBounds(10, 431, 45, 13);
        panel_7.add(lblNewLabel_9);

        textField_14 = new JTextField();
        textField_14.setEditable(false);
        textField_14.setBounds(20, 454, 279, 19);
        panel_7.add(textField_14);
        textField_14.setColumns(10);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Prosument");
        chckbxNewCheckBox.setBounds(10, 479, 93, 21);
        panel_7.add(chckbxNewCheckBox);

        JLabel lblNewLabel_11 = new JLabel("Data Sporz\u0105dzenia");
        lblNewLabel_11.setBounds(10, 10, 120, 13);
        panel_7.add(lblNewLabel_11);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(20, 33, 142, 19);
        panel_7.add(dateChooser);

        JLabel lblNewLabel_12 = new JLabel("Data rozpocz\u0119cia");
        lblNewLabel_12.setBounds(10, 62, 90, 13);
        panel_7.add(lblNewLabel_12);

        JDateChooser dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(20, 85, 142, 19);
        panel_7.add(dateChooser_1);

        JLabel lblNewLabel_13 = new JLabel("Przewidywana data zako\u0144czenia");
        lblNewLabel_13.setBounds(10, 109, 186, 13);
        panel_7.add(lblNewLabel_13);

        JDateChooser dateChooser_2 = new JDateChooser();
        dateChooser_2.setBounds(20, 134, 142, 19);
        panel_7.add(dateChooser_2);

        JLabel lblNewLabel_14 = new JLabel("Data ko\u0144ca umowy");
        lblNewLabel_14.setBounds(10, 163, 142, 13);
        panel_7.add(lblNewLabel_14);

        textField_15 = new JTextField();
        textField_15.setEditable(false);
        textField_15.setBounds(20, 186, 279, 19);
        panel_7.add(textField_15);
        textField_15.setColumns(10);

        JPanel panel_4 = new JPanel();
        tabbedPane.addTab("New tab", null, panel_4, null);
        panel_4.setLayout(null);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_8.setBounds(10, 10, 350, 552);
        panel_4.add(panel_8);
        panel_8.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 350, 552);
        panel_8.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JPanel panel_8_1 = new JPanel();
        panel_8_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_8_1.setBounds(521, 10, 350, 552);
        panel_4.add(panel_8_1);
        panel_8_1.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 350, 552);
        panel_8_1.add(scrollPane_1);

        table_1 = new JTable();
        scrollPane_1.setViewportView(table_1);

        JButton btnNewButton = new JButton("+");
        btnNewButton.setBounds(400, 244, 85, 21);
        panel_4.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("-");
        btnNewButton_1.setBounds(400, 302, 85, 21);
        panel_4.add(btnNewButton_1);

        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("New tab", null, panel_2, null);
        panel_2.setLayout(null);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Fizyczna wersja dokumentu");
        chckbxNewCheckBox_1.setBounds(6, 6, 173, 21);
        panel_2.add(chckbxNewCheckBox_1);

        JButton btnNewButton_2 = new JButton("Dodaj");
        btnNewButton_2.setBounds(181, 6, 85, 21);
        panel_2.add(btnNewButton_2);

        JLabel lblNewLabel_15 = new JLabel("Fazowo\u015B\u0107 umowna");
        lblNewLabel_15.setBounds(10, 67, 106, 13);
        panel_2.add(lblNewLabel_15);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(6, 101, 124, 26);
        panel_2.add(comboBox);
    }

     void initPlatnik(kontrahent kontrahent) throws SQLException {
        textField.setText(String.valueOf(kontrahent.getId()));
        textField_5.setText(kontrahent.getNazwa());
        if(kontrahent.getPesel()==""){
            textField_4.setText(kontrahent.getNIP());
        }else{
            textField_4.setText(kontrahent.getPesel());
        }
        Adres adres = getAdres(String.valueOf(kontrahent.getIdAdres()));
        Adres kores = getAdres(String.valueOf(kontrahent.getIdAdresKores()));
        textField_2.setText(adres.getNazwa()+" "+ kontrahent.getNumerDomu()+ " "+adres.getPoczta()+ " "+ adres.getKod());
        textField_6.setText(kores.getNazwa()+" "+ kontrahent.getNumderDomuKores()+ " "+kores.getPoczta()+ " "+ kores.getKod());
    }
    void initKoresPlatnik(kontrahent kontrahent) throws SQLException {
        textField_1.setText(String.valueOf(kontrahent.getId()));
        textField_7.setText(kontrahent.getNazwa());
        if(kontrahent.getPesel()==""){
            textField_8.setText(kontrahent.getNIP());
        }else{
            textField_8.setText(kontrahent.getPesel());
        }
        Adres adres = getAdres(String.valueOf(kontrahent.getIdAdres()));
        Adres kores = getAdres(String.valueOf(kontrahent.getIdAdresKores()));
        textField_3.setText(adres.getNazwa()+" "+ kontrahent.getNumerDomu()+ " "+adres.getPoczta()+ " "+ adres.getKod());
        textField_9.setText(kores.getNazwa()+" "+ kontrahent.getNumderDomuKores()+ " "+kores.getPoczta()+ " "+ kores.getKod());
    }


}
