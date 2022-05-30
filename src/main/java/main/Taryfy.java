package main;

import main.taryfy.actionTaryfy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taryfy extends actionTaryfy{

    private JFrame frame;
    private JTable table;
    private JTable table_1;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Taryfy window = new Taryfy();
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
    public Taryfy() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 879, 431);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 58, 400, 283);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Nazwa", "Typ", "Wybrane"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    String.class, String.class, Boolean.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        scrollPane.setViewportView(table);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(453, 58, 400, 283);
        frame.getContentPane().add(scrollPane_1);

        table_1 = new JTable();
        table_1.setDefaultEditor(Object.class, null);
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Nazwa", "Typ", "Wybrane"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    String.class, String.class, Boolean.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        scrollPane_1.setViewportView(table_1);

        JButton btnNewButton = new JButton("Zatwied\u017A");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTaryfa(createTaryfe(selectLiczydlo(table),selectLiczydlo(table_1),textField.getText()),frame);
            }
        });
        btnNewButton.setBounds(764, 358, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Anuluj");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnNewButton_1.setBounds(650, 358, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("Wymagane sk\u0142adniki");
        lblNewLabel.setBounds(148, 33, 140, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Opcjonalne sk\u0142adniki");
        lblNewLabel_1.setBounds(608, 33, 130, 14);
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(84, 359, 103, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Nazwa");
        lblNewLabel_2.setBounds(20, 362, 46, 14);
        frame.getContentPane().add(lblNewLabel_2);

        setTableModel(table);
        setTableModel(table_1);
    }


}
