package main;

import main.entity.Liczydlo;
import main.liczydla.actionLiczydla;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LiczydlaList extends actionLiczydla {

    private JFrame frame;
    private JTextField textField;
    private JTable table;
    private Liczydlo liczydlo;

    private static LiczydlaList window;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window = new LiczydlaList();
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
    public LiczydlaList() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 535, 328);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 71, 486, 207);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                table.getSelectedRow();
                liczydlo = new Liczydlo(String.valueOf(table.getValueAt(table.getSelectedRow(),0)),String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
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

        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setBounds(10, 11, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LiczydlaEdytor liczydlaEdytor = new LiczydlaEdytor();
                liczydlaEdytor.main(window);

            }
        });
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Anuluj");
        btnNewButton_1.setBounds(109, 11, 89, 23);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dezaktywujLiczydlo(liczydlo);
                refreshTable();
            }
        });
        frame.getContentPane().add(btnNewButton_1);

        textField = new JTextField();
        textField.setBounds(208, 12, 196, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton_2 = new JButton("Znajd\u017A");
        btnNewButton_2.setBounds(407, 11, 89, 23);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setModel(DbUtils.resultSetToTableModel(finByName(textField.getText())));
            }
        });
        frame.getContentPane().add(btnNewButton_2);

        getAllLiczydla(table);
    }

    public void refreshTable(){
        getAllLiczydla(table);
    }
}
