package main;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FPP {

    private JFrame frame;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FPP window = new FPP();
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
    public FPP() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 878, 543);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fizyczny punkt poboru");
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 209, 211);
        frame.getContentPane().add(panel);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);


        JLabel lblNewLabel = new JLabel("P\u0142atnik");
        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Przenosi do płatnika");
            }
        });
        lblNewLabel.setBounds(10, 22, 45, 13);
        lblNewLabel.setForeground(Color.BLUE);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Odbiorca");
        lblNewLabel_1.setBounds(10, 111, 60, 13);
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Przeniesienie do Obiorcy");
            }
        });
        lblNewLabel_1.setForeground(Color.BLUE);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_6 = new JLabel("#PlaceHolder");
        lblNewLabel_6.setBounds(10, 62, 75, 13);
        panel.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("#PlaceHolder");
        lblNewLabel_7.setBounds(10, 155, 104, 13);
        panel.add(lblNewLabel_7);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 243, 209, 240);
        panel_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Odczyty");
        lblNewLabel_2.setForeground(Color.BLUE);
        lblNewLabel_2.setBounds(10, 10, 45, 13);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Umowy");
        lblNewLabel_3.setBounds(10, 43, 45, 13);
        lblNewLabel_3.setForeground(Color.BLUE);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Zlecenia OT");
        lblNewLabel_4.setBounds(10, 84, 79, 13);
        lblNewLabel_4.setForeground(Color.BLUE);
        panel_1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Faktury");
        lblNewLabel_5.setBounds(10, 130, 45, 13);
        lblNewLabel_5.setForeground(Color.BLUE);
        panel_1.add(lblNewLabel_5);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(229, 10, 620, 472);
        frame.getContentPane().add(tabbedPane);

        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Dane punktu", null, panel_2, null);
        panel_2.setLayout(null);

        JLabel lblNewLabel_14 = new JLabel("Numer FPP");
        lblNewLabel_14.setBounds(10, 10, 76, 13);
        panel_2.add(lblNewLabel_14);

        textField = new JTextField();
        textField.setBounds(97, 7, 245, 19);
        panel_2.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_15 = new JLabel("Numer Umowy");
        lblNewLabel_15.setBounds(10, 49, 120, 13);
        panel_2.add(lblNewLabel_15);

        textField_1 = new JTextField();
        textField_1.setBounds(97, 46, 251, 19);
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_16 = new JLabel("Adres");
        lblNewLabel_16.setBounds(10, 124, 45, 13);
        panel_2.add(lblNewLabel_16);

        textField_2 = new JTextField();
        textField_2.setBounds(75, 121, 388, 19);
        panel_2.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_17 = new JLabel("Taryfa");
        lblNewLabel_17.setBounds(401, 10, 45, 13);
        panel_2.add(lblNewLabel_17);

        textField_3 = new JTextField();
        textField_3.setBounds(475, 7, 67, 19);
        panel_2.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_18 = new JLabel("Fazowo\u015B\u0107");
        lblNewLabel_18.setBounds(401, 49, 62, 13);
        panel_2.add(lblNewLabel_18);

        textField_4 = new JTextField();
        textField_4.setBounds(475, 46, 67, 19);
        panel_2.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_19 = new JLabel("GUS");
        lblNewLabel_19.setBounds(10, 187, 45, 13);
        panel_2.add(lblNewLabel_19);

        textField_5 = new JTextField();
        textField_5.setBounds(75, 184, 388, 19);
        panel_2.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_20 = new JLabel("NRW FPP");
        lblNewLabel_20.setBounds(10, 88, 67, 13);
        panel_2.add(lblNewLabel_20);

        textField_6 = new JTextField();
        textField_6.setBounds(75, 85, 245, 19);
        panel_2.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_21 = new JLabel("Typ liczyde\u0142 ");
        lblNewLabel_21.setBounds(10, 236, 93, 13);
        panel_2.add(lblNewLabel_21);

        textField_7 = new JTextField();
        textField_7.setBounds(113, 233, 148, 19);
        panel_2.add(textField_7);
        textField_7.setColumns(10);

        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("Dane Licznika", null, panel_3, null);
        panel_3.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 323, 232);
        panel_3.add(scrollPane);
        //Dodanie skyrptu do pobierania liczników
        JTree tree = new JTree();
        tree.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("Liczniki") {
                    {
                        add(new DefaultMutableTreeNode("PlaceHolder"));
                    }
                }
        ));
        scrollPane.setViewportView(tree);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(343, 10, 262, 232);
        panel_3.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_8 = new JLabel("Nazwa");
        lblNewLabel_8.setBounds(10, 10, 45, 13);
        panel_4.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Model");
        lblNewLabel_9.setBounds(10, 33, 45, 13);
        panel_4.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("ID Licznika");
        lblNewLabel_10.setBounds(10, 65, 64, 13);
        panel_4.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("Data monta\u017Cu");
        lblNewLabel_11.setBounds(10, 88, 97, 13);
        panel_4.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("Data Demonta\u017Cu");
        lblNewLabel_12.setBounds(10, 113, 97, 13);
        panel_4.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("Data Legalizacji");
        lblNewLabel_13.setBounds(10, 136, 97, 13);
        panel_4.add(lblNewLabel_13);

        textField_8 = new JTextField();
        textField_8.setBounds(50, 7, 202, 19);
        panel_4.add(textField_8);
        textField_8.setColumns(10);

        textField_9 = new JTextField();
        textField_9.setBounds(50, 33, 202, 19);
        panel_4.add(textField_9);
        textField_9.setColumns(10);

        textField_10 = new JTextField();
        textField_10.setBounds(71, 56, 181, 19);
        panel_4.add(textField_10);
        textField_10.setColumns(10);

        textField_11 = new JTextField();
        textField_11.setBounds(101, 85, 151, 19);
        panel_4.add(textField_11);
        textField_11.setColumns(10);

        textField_12 = new JTextField();
        textField_12.setBounds(101, 110, 151, 19);
        panel_4.add(textField_12);
        textField_12.setColumns(10);

        textField_13 = new JTextField();
        textField_13.setBounds(101, 136, 151, 19);
        panel_4.add(textField_13);
        textField_13.setColumns(10);

        JPanel panel_5 = new JPanel();
        panel_5.setBounds(10, 252, 595, 183);
        panel_3.add(panel_5);
        panel_5.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 595, 183);
        panel_5.add(scrollPane_1);

        table = new JTable();
        scrollPane_1.setViewportView(table);

        textField.setEditable(false);
        textField_1.setEditable(false);
        textField_2.setEditable(false);
        textField_3.setEditable(false);
        textField_4.setEditable(false);
        textField_5.setEditable(false);
        textField_6.setEditable(false);
        textField_7.setEditable(false);
        textField_8.setEditable(false);
        textField_9.setEditable(false);
        textField_10.setEditable(false);
        textField_11.setEditable(false);
        textField_12.setEditable(false);
        textField_13.setEditable(false);


    }
}
