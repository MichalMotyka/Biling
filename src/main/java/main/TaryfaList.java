package main;

import main.taryfy.actionTaryfy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TaryfaList extends actionTaryfy {

    private JFrame frame;
    private JTable table;
    private  String id;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TaryfaList window = new TaryfaList();
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
    public TaryfaList() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 515, 334);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton_1 = new JButton("Dodaj");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Taryfy.main(null);
            }
        });
        btnNewButton_1.setBounds(10, 10, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Dezaktywuj");
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dezaktywujTaryfe(id);
                setTaryfaTable(table);
            }
        });
        btnNewButton_2.setBounds(109, 10, 114, 23);
        frame.getContentPane().add(btnNewButton_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 44, 476, 240);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        setTaryfaTable(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                id = String.valueOf(table.getValueAt(table.getSelectedRow(),1));
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
        scrollPane.setViewportView(table);

    }
}
