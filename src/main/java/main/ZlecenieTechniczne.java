package main;

import com.toedter.calendar.JDateChooser;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ZlecenieTechniczne {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTable table;
    private JTable table_1;
    private JTable table_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ZlecenieTechniczne window = new ZlecenieTechniczne();
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
    public ZlecenieTechniczne() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 497, 577);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 486, 541);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 467, 502);
        panel.add(tabbedPane);

        JLayeredPane layeredPane = new JLayeredPane();
        tabbedPane.addTab("Dane", null, layeredPane, null);
        layeredPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Numer OT");
        lblNewLabel.setBounds(10, 10, 76, 13);
        layeredPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Numer obcy");
        lblNewLabel_1.setBounds(10, 54, 76, 13);
        layeredPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(80, 7, 318, 19);
        layeredPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Numer FPP");
        lblNewLabel_2.setForeground(Color.BLUE);
        lblNewLabel_2.setBounds(10, 101, 76, 13);
        layeredPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(80, 51, 318, 19);
        layeredPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setBounds(80, 98, 318, 19);
        layeredPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Numer umowy");
        lblNewLabel_3.setForeground(Color.BLUE);
        lblNewLabel_3.setBounds(10, 138, 87, 13);
        layeredPane.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setBounds(90, 135, 318, 19);
        layeredPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Numer p\u0142atnika");
        lblNewLabel_4.setBounds(10, 185, 76, 13);
        layeredPane.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setBounds(90, 182, 308, 19);
        layeredPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Adres");
        lblNewLabel_5.setBounds(10, 228, 45, 13);
        layeredPane.add(lblNewLabel_5);

        textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setBounds(42, 225, 356, 19);
        layeredPane.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Zestaw pomiarowy");
        lblNewLabel_6.setForeground(Color.BLUE);
        lblNewLabel_6.setBounds(10, 281, 105, 13);
        layeredPane.add(lblNewLabel_6);

        textField_6 = new JTextField();
        textField_6.setEditable(false);
        textField_6.setBounds(131, 278, 96, 19);
        layeredPane.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Pochodzenie");
        lblNewLabel_7.setBounds(10, 320, 87, 13);
        layeredPane.add(lblNewLabel_7);

        textField_7 = new JTextField();
        textField_7.setEditable(false);
        textField_7.setBounds(131, 320, 96, 19);
        layeredPane.add(textField_7);
        textField_7.setColumns(10);

        JButton btnNewButton_2 = new JButton("Opis");
        btnNewButton_2.setBounds(323, 277, 85, 21);
        layeredPane.add(btnNewButton_2);

        JLabel lblNewLabel_8 = new JLabel("Piorytet");
        lblNewLabel_8.setBounds(299, 320, 45, 13);
        layeredPane.add(lblNewLabel_8);

        Choice choice = new Choice();
        choice.setBounds(371, 320, 57, 18);
        layeredPane.add(choice);

        JLabel lblNewLabel_9 = new JLabel("Data rejestracji");
        lblNewLabel_9.setBounds(10, 366, 96, 13);
        layeredPane.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Data wykonania");
        lblNewLabel_10.setBounds(10, 407, 96, 13);
        layeredPane.add(lblNewLabel_10);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(109, 366, 119, 19);
        layeredPane.add(dateChooser);

        JDateChooser dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(109, 407, 118, 19);
        layeredPane.add(dateChooser_1);

        JLayeredPane layeredPane_1 = new JLayeredPane();
        tabbedPane.addTab("Akcje na liczniku", null, layeredPane_1, null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 462, 172);
        layeredPane_1.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Akcja", "Licznik"
                }
        ));
        scrollPane.setViewportView(table);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 182, 462, 293);
        layeredPane_1.add(scrollPane_1);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Sk\u0142adnik", "Termin", "Wskazanie"
                }
        ));
        scrollPane_1.setViewportView(table_1);

        JLayeredPane layeredPane_2 = new JLayeredPane();
        tabbedPane.addTab("Historia", null, layeredPane_2, null);
        layeredPane_2.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(0, 0, 462, 475);
        layeredPane_2.add(scrollPane_2);

        table_2 = new JTable();
        table_2.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Status przed", "Status po", "Data", "Login"
                }
        ));
        scrollPane_2.setViewportView(table_2);

        JButton btnNewButton = new JButton("Anuluj");
        btnNewButton.setBounds(105, 512, 85, 21);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Zatwierd\u017A");
        btnNewButton_1.setBounds(10, 512, 85, 21);
        panel.add(btnNewButton_1);
    }
}
