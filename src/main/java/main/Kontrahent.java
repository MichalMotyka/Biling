package main;

import lombok.SneakyThrows;
import main.entity.Adres;
import main.entity.kontrahent;
import main.kontrahent.actionKontrahent;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

public class Kontrahent extends actionKontrahent {

    public JFrame frame;
    JTextField inputnumerdomu;
    JCheckBox chckbxNewCheckBox;
    public  JTextField textField;
    public JTextField textField_1;
    public JTextField textField_2;
    public JTextField textField_3;
    public JTextField textField_4;
    public JTextField textField_5;
    public JTextField textField_6;
    public JTextField textField_7;
    public static kontrahent iniKontrahebt;
    JTextField adreskorespnumerdomu;
    public static Adres initAdres;
    JLayeredPane layeredPane;

    public static JTable getTable() {
        return table;
    }

    public static JTable table;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private static int status;
    JPanel panel;
    private static int idKontrahent;
    private static int id;
    private static int id_kores;
    public JTextField textField_8;
    public  JButton zatwierdz;

    /**
     * Launch the application.
     */
    public  void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Kontrahent window = new Kontrahent();
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
    public Kontrahent() throws SQLException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws SQLException {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 727, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(43, 72, 45, 13);
        frame.getContentPane().add(lblNewLabel);

        panel = new JPanel();
        panel.setBounds(10, 10, 124, 368);
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JTree tree = new JTree();
        tree.setRootVisible(false);
        tree.setBackground(UIManager.getColor("Panel.background"));
        tree.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("JTREE\t") {
                    {
                        DefaultMutableTreeNode node_1;
                        node_1 = new DefaultMutableTreeNode("Dane FPP");
                        node_1.add(new DefaultMutableTreeNode("Umowy"));
                        node_1.add(new DefaultMutableTreeNode("FPP"));
                        node_1.add(new DefaultMutableTreeNode("Zlecenia OT"));
                        add(node_1);
                        node_1 = new DefaultMutableTreeNode("Rozliczenia");
                        node_1.add(new DefaultMutableTreeNode("Faktury"));
                        node_1.add(new DefaultMutableTreeNode("Prognozy"));
                        add(node_1);
                    }
                }
        ));
        tree.setBounds(10, 10, 104, 348);
        panel.add(tree);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(144, 10, 569, 368);
        frame.getContentPane().add(tabbedPane);

        layeredPane = new JLayeredPane();
        layeredPane.setOpaque(true);
        layeredPane.setBackground(UIManager.getColor("Panel.background"));
        tabbedPane.addTab("Dane Kontrahenta", null, layeredPane, null);
        layeredPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Nazwa Kontrahenta");
        lblNewLabel_1.setBounds(10, 10, 115, 13);
        layeredPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(135, 7, 419, 19);
        layeredPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Miejscowo\u015B\u0107");
        lblNewLabel_2.setForeground(Color.BLUE);
        lblNewLabel_2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(status!=2){
                    SlownikAdresGUI slownikAdresGUI = new SlownikAdresGUI();
                    slownikAdresGUI.mode = "select";
                    slownikAdresGUI.mode_id = "id";
                    slownikAdresGUI.jTextFields =getTextFieldAdres();
                    slownikAdresGUI.main(null);
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
        lblNewLabel_2.setBounds(10, 54, 96, 13);
        layeredPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setBounds(135, 51, 189, 19);
        layeredPane.add(textField_1);
        textField_1.setColumns(10);


        JLabel numerdomu = new JLabel("Numer domu");
        numerdomu.setBounds(10,86,90,13);
        layeredPane.add(numerdomu);

        inputnumerdomu = new JTextField();
        inputnumerdomu.setBounds(135,83,130,19);
        layeredPane.add(inputnumerdomu);

        JLabel lblNewLabel_3 = new JLabel("Poczta");
        lblNewLabel_3.setBounds(10, 116, 45, 13);
        layeredPane.add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setBounds(135, 113, 189, 19);
        layeredPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Kod Pocztowy");
        lblNewLabel_4.setBounds(334, 54, 96, 13);
        layeredPane.add(lblNewLabel_4);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setBounds(440, 51, 114, 19);
        layeredPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("GUS");
        lblNewLabel_5.setBounds(334, 116, 45, 13);
        layeredPane.add(lblNewLabel_5);

        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setBounds(440, 113, 114, 19);
        layeredPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("NIP");
        lblNewLabel_6.setBounds(334, 159, 96, 13);
        layeredPane.add(lblNewLabel_6);

        textField_5 = new JTextField();
        textField_5.setBounds(135, 156, 189, 19);
        layeredPane.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("PESEL");
        lblNewLabel_7.setBounds(10, 149, 45, 13);
        layeredPane.add(lblNewLabel_7);

        textField_6 = new JTextField();
        textField_6.setBounds(440, 156, 114, 19);
        layeredPane.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Saldo");
        lblNewLabel_8.setBounds(334, 199, 45, 13);
        layeredPane.add(lblNewLabel_8);

        textField_7 = new JTextField();
        textField_7.setEditable(false);
        textField_7.setBounds(419, 196, 135, 19);
        layeredPane.add(textField_7);
        textField_7.setColumns(10);

        chckbxNewCheckBox = new JCheckBox("Prosument");
        chckbxNewCheckBox.setBounds(10, 183, 93, 21);
        chckbxNewCheckBox.setEnabled(false);
        layeredPane.add(chckbxNewCheckBox);

        JLabel lblNewLabel_9 = new JLabel("Adres Korespondencyjny");
        lblNewLabel_9.setForeground(Color.BLUE);
        lblNewLabel_9.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(status!=2){
                    EdycjaAdresu.trybedycji=0;
                    SlownikAdresGUI slownikAdresGUI = new SlownikAdresGUI();
                    slownikAdresGUI.mode = "select";
                    slownikAdresGUI.mode_id = "id_kores";
                    slownikAdresGUI.jTextFields =getTextFieldAdres();
                    slownikAdresGUI.main(null);
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
        lblNewLabel_9.setBounds(10, 236, 150, 13);
        layeredPane.add(lblNewLabel_9);

        textField_8 = new JTextField();
        textField_8.setBounds(10, 261, 544, 19);
        layeredPane.add(textField_8);
        textField_8.setColumns(10);

        JLabel adreskoresp = new JLabel("Numer domu");
        adreskoresp.setBounds(10,295,150,13);
        layeredPane.add(adreskoresp);

        adreskorespnumerdomu = new JTextField();
        adreskorespnumerdomu.setBounds(10,315,150,19);
        layeredPane.add(adreskorespnumerdomu);

        zatwierdz = new JButton("Zatwierdź");
        zatwierdz.setBounds(450,295,100,30);
        zatwierdz.addActionListener(new ActionListener() {
            @SneakyThrows
            public void actionPerformed(ActionEvent e) {
                kontrahent kontrahent = new kontrahent(
                        textField.getText(),
                        textField_5.getText(),
                        textField_6.getText(),
                        000,
                        id,
                        id_kores,
                        "N",
                        0,
                        inputnumerdomu.getText(),
                        adreskorespnumerdomu.getText());
                if(status==0){
                    String id = saveKontrahent(kontrahent,getStatus());
                    KontrahentList.getTable().setModel(DbUtils.resultSetToTableModel(getKontrahentByID(id)));
                    if (id != null){
                        frame.dispose();
                    }
                }else if(status==1){
                    kontrahent.setId(idKontrahent);
                    if(saveKontrahent(kontrahent,getStatus()) != null){
                        frame.dispose();
                    }
                }

            }});
        layeredPane.add(zatwierdz);

        JLayeredPane layeredPane_1 = new JLayeredPane();
        tabbedPane.addTab("Dane historyczne", null, layeredPane_1, null);
        layeredPane_1.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 592, 341);
        layeredPane_1.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        if(status>=1){
            if(status==2){
                for (JTextField jTextField:getTextFieldData()) {
                    jTextField.setEditable(false);
                }
                textField_8.setEditable(false);
                zatwierdz.hide();
            }
            mapKontrahentToForm(iniKontrahebt);
            getHisData(String.valueOf(idKontrahent));
        }
    }

   public JTextField[] getTextFieldAdres(){
        return new JTextField[]{textField_1,textField_2,textField_3,textField_4,textField_8};
    }
    public JTextField[] getTextFieldData(){
        return new JTextField[]{textField,textField_5,textField_6,textField_7,inputnumerdomu,adreskorespnumerdomu};
    }
    public void mapKontrahentToForm(kontrahent kontrahent) throws SQLException {
            textField.setText(kontrahent.getNazwa());
            textField_5.setText(kontrahent.getPesel());
            textField_6.setText(kontrahent.getNIP());
            textField_7.setText(String.valueOf((float)kontrahent.getSaldo()/100));
            inputnumerdomu.setText(kontrahent.getNumerDomu());
            adreskorespnumerdomu.setText(kontrahent.getNumderDomuKores());
            id = kontrahent.getIdAdres();
            id_kores = kontrahent.getIdAdresKores();
            idKontrahent = kontrahent.getId();
            if(kontrahent.getProsument().equals("T")){
                chckbxNewCheckBox.setSelected(true);
            }
            Adres adres = getAdres(String.valueOf(kontrahent.getIdAdres()));
            textField_1.setText(adres.getNazwa());
            textField_2.setText(adres.getPoczta());
            textField_3.setText(adres.getKod());
            textField_4.setText(adres.getGUS());
            Adres adreskores = getAdres(String.valueOf(kontrahent.getIdAdresKores()));
            textField_8.setText(adreskores.getNazwa()+" "+adreskores.getPoczta()+" "+adreskores.getKod());
    }
    public JCheckBox getJCheckBox(){
        return chckbxNewCheckBox;
    }
    public static void setId(int guid){
        id = guid;
    }
    public static void setId_kores(int guid){
        id_kores = guid;
    }

}
