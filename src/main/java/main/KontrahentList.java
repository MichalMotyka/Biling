package main;

import lombok.SneakyThrows;
import main.entity.kontrahent;
import main.kontrahent.actionKontrahent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class KontrahentList extends actionKontrahent {

    private JFrame frame;
    private static  int tryb = 1;
    private JTextField textField;
    int clicker;
    kontrahent kontrahent;
    MouseActions mouseActions = new MouseActions();

    public static JTable getTable() {
        return table;
    }

    private static JTable table;
    static Umowa umowa = null;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KontrahentList window = new KontrahentList();
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
    public KontrahentList() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 834, 394);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        JButton find = new JButton("Szukaj");
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllKontrahent(textField.getText());
            }
        });
        find.setBounds(686, 11, 89, 23);
        frame.getContentPane().add(find);

        textField = new JTextField();
        textField.setBounds(228, 12, 448, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton edytuj = new JButton("edytuj");
        edytuj.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                Kontrahent kontrahent = null;
                try {
                    kontrahent = new Kontrahent();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                kontrahent.setStatus(1);
                kontrahent.iniKontrahebt =getKontrahentData(table.getValueAt(table.getSelectedRow(),0).toString());
                kontrahent.main(null);
            }
        });
        edytuj.setBounds(30, 11, 89, 23);
        frame.getContentPane().add(edytuj);

        JButton dodaj = new JButton("dodaj");
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kontrahent kontrahent = null;
                try {
                    kontrahent = new Kontrahent();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                kontrahent.setStatus(0);
                kontrahent.main(null);
            }
        });
        dodaj.setBounds(129, 11, 89, 23);
        frame.getContentPane().add(dodaj);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 52, 745, 292);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.addMouseListener(new MouseListener() {
            @SneakyThrows
            @Override
            public void mouseClicked(MouseEvent e) {
                if(mouseActions.TwoTimeClicked() && tryb==1){
                   Kontrahent kontrahent = new Kontrahent();
                   kontrahent.setStatus(2);
                   kontrahent.iniKontrahebt =getKontrahentData(table.getValueAt(table.getSelectedRow(),0).toString());
                   kontrahent.main(null);
                } else if (tryb==2) {
                    kontrahent = getKontrahentData(table.getValueAt(table.getSelectedRow(),0).toString());
                    umowa.initPlatnik(kontrahent);
                } else if (tryb==3) {
                    kontrahent = getKontrahentData(table.getValueAt(table.getSelectedRow(),0).toString());
                    umowa.initKoresPlatnik(kontrahent);
                }
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
        getAllKontrahent();
    }
   public void getKontrahentFromTable(Umowa umowa){
        main(null);
        tryb = 2;
        this.umowa = umowa;
    }
    public void getKoresKontrahentFromTable(Umowa umowa){
        main(null);
        tryb = 3;
        this.umowa = umowa;
    }

}
