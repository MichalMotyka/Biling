package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ErrorScreen extends JDialog {

    private final JPanel contentPanel = new JPanel();
    JTextPane textPane;
    private static DefaultTableModel  model;
    private JTable table;

    /**
     * Launch the application.
     */
    public void errorScreen() {
        try {
            ErrorScreen dialog = new ErrorScreen();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ErrorScreen() {
        setResizable(false);
        setBounds(100, 100, 545, 326);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nie uda\u0142o si\u0119 zapisa\u0107 danych z nast\u0119puj\u0105cych przyczyn");
        lblNewLabel.setBounds(10, 11, 509, 14);
        contentPanel.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 38, 509, 90);
        contentPanel.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Komunikat"
                }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                textPane.setText(table.getValueAt(row,0).toString());
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
        textPane = new JTextPane();
        textPane.setBackground(SystemColor.menu);
        textPane.setEditable(false);
        textPane.setBounds(10, 139, 509, 90);
        contentPanel.add(textPane);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                getRootPane().setDefaultButton(okButton);
            }
        }
    }
    public void addRow(String error) {
        model.addRow(new Object[] {error});
    }
}
