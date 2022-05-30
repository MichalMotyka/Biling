package main;

import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class SlownikPanstw {

    private JFrame frame;
    private static JTable table;
    static SlownikAdresow SA = new SlownikAdresow();
    static DefaultTableModel model;
    static String Panstwo = null;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SlownikPanstw window = new SlownikPanstw();
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
    public SlownikPanstw() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 430, 493);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 394, 393);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int x = table.getSelectedRow();
               Panstwo = table.getValueAt(x,0).toString();
               System.out.println(Panstwo);
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
        model = (DefaultTableModel) DbUtils.resultSetToTableModel(SA.getKraje());
        table.setModel(model);
        scrollPane.setViewportView(table);

        JButton btnNewButton = new JButton("Dodaj");
        btnNewButton.setBounds(10, 11, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SlownikPanstwEdycja.main(1,null);
            }
        });
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Edytuj");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SlownikPanstwEdycja.main(0,Panstwo);
            }
        });
        btnNewButton_1.setBounds(109, 11, 89, 23);
        frame.getContentPane().add(btnNewButton_1);
    }
    public static void UpdateDATA(){
        model = (DefaultTableModel) DbUtils.resultSetToTableModel(SA.getKraje());
        table.setModel(model);
        table.repaint();
    }
}
