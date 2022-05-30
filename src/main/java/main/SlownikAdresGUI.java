package main;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SlownikAdresGUI {
    static int row,col;
    static int clicker= 1;
    private JFrame frame;
    private JTextField textField;
    private static  JTable table;
    static DefaultTableModel model;
    static int okno = 0;
    private String backWojewo;
    private static String wojewodztwo;
    public static String mode="",mode_id="";
    static SlownikAdresow SA = new SlownikAdresow();
    public static int[] id_ad;
    public static JTextField[] jTextFields;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SlownikAdresGUI window = new SlownikAdresGUI();
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
    public SlownikAdresGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 850, 404);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("<--");
        btnNewButton.setBounds(20, 11, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(okno == 1){
                    table.setModel(DbUtils.resultSetToTableModel( SA.getWojewodztwa()));
                    okno=0;
                }else if(okno == 2){
                    table.setModel(DbUtils.resultSetToTableModel( SA.getPowiat(backWojewo)));
                    okno=1;
                }
            }
        });
        frame.getContentPane().add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 45, 789, 297);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        scrollPane.setViewportView(table);

        table.setModel(DbUtils.resultSetToTableModel( SA.getWojewodztwa()));


        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MouseActions mouseActions = new MouseActions();
                if (clicker == 1) {
                    row = table.getSelectedRow();
                    col = table.getSelectedColumn();
                    MouseActions.TwoTimeClicked(clicker);
                    clicker++;
                }else if(clicker == 2 && row== table.getSelectedRow() && col == table.getSelectedColumn()){
                    if (MouseActions.TwoTimeClicked(clicker)) {
                        if (okno==0){
                            wojewodztwo = table.getValueAt(row,1).toString();
                            wojewodztwo= String.valueOf(wojewodztwo.charAt(0))+String.valueOf(wojewodztwo.charAt(1));
                            table.setModel(DbUtils.resultSetToTableModel(SA.getPowiat(wojewodztwo)));
                            okno=1;
                            backWojewo = wojewodztwo;
                        }else if(okno==1){
                            wojewodztwo = table.getValueAt(row,1).toString();
                            wojewodztwo= String.valueOf(wojewodztwo.charAt(0))+String.valueOf(wojewodztwo.charAt(1)+String.valueOf(wojewodztwo.charAt(2))+String.valueOf(wojewodztwo.charAt(3)));
                            table.setModel(DbUtils.resultSetToTableModel(SA.getMiejscowosc(wojewodztwo)));
                            okno=2;
                        }
                        clicker--;
                        row = table.getSelectedRow();
                        col = table.getSelectedColumn();
                    }
                }else if(clicker==2){
                    row = table.getSelectedRow();
                    col = table.getSelectedColumn();
                    clicker=1;
                }
                getAdres();
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

        textField = new JTextField();
        textField.setBounds(378, 12, 314, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton_1 = new JButton("Wyszukaj");
        btnNewButton_1.setBounds(702, 11, 89, 23);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDATA(SA.findAdres(textField.getText()));
            }
        });
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("+");
        btnNewButton_2.setBounds(129, 11, 89, 23);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EdycjaAdresu.main(0,null,null);
            }
        });
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Edytuj");
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EdycjaAdresu.main(1,table.getValueAt(row,1).toString(),table.getValueAt(row,0).toString());
            }
        });
        btnNewButton_3.setBounds(228, 11, 89, 23);
        frame.getContentPane().add(btnNewButton_3);
    }
    public static void UpdateDATA(){
        if(okno==0){
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(SA.getWojewodztwa());
        }
        if (okno==1){
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(SA.getPowiat(wojewodztwo));
        }
        if(okno != 1 && okno !=0){
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(SA.getMiejscowosc(wojewodztwo));
        }
        table.setModel(model);
        table.repaint();
    }
    public static void findDATA(ResultSet rs){
        model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
        table.setModel(model);
        table.repaint();
        okno = 2;
    }
    public static void getAdres(){
        if(okno==2 && mode.equals("select")) {
           ResultSet rs = SA.getDane(table.getValueAt(row,1).toString(),table.getValueAt(row, 0).toString());
            row = table.getSelectedRow();
            col = table.getSelectedColumn();
            try {
                if(rs.next()){
                    int id = 0;
                    if (mode_id.equals("id")) {
                        id = rs.getInt("id");
                        Kontrahent.setId(id);
                    }
                    else if (mode_id.equals("id_kores")) {
                        id = rs.getInt("id");
                        Kontrahent.setId_kores(id);
                    }
                    rs = SA.getKod(String.valueOf(id));
                  if(mode_id.equals("id") && rs.next()){
                      jTextFields[0].setText(table.getValueAt(row, 0).toString());
                      jTextFields[3].setText(table.getValueAt(row,1).toString());
                      jTextFields[1].setText(rs.getString("Poczta"));
                      jTextFields[2].setText(rs.getString("kod"));
                  } else if (mode_id.equals("id_kores") && rs.next()) {
                      jTextFields[4].setText(table.getValueAt(row, 0).toString()+" "+rs.getString("Poczta")+" "+rs.getString("kod"));
                  }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
