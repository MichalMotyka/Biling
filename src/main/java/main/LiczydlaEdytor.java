package main;

import lombok.SneakyThrows;
import main.entity.Liczydlo;
import main.liczydla.actionLiczydla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LiczydlaEdytor extends actionLiczydla {

    private JFrame frame;
    private JTextField textField;

    public LiczydlaList getIczydlaList() {
        return iczydlaList;
    }

    private LiczydlaList iczydlaList= null;


    /**
     * Launch the application.
     */
    public void main(LiczydlaList liczydlaList) {
        this.iczydlaList = liczydlaList;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LiczydlaEdytor window = new LiczydlaEdytor();
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
    public LiczydlaEdytor() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 242, 211);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Nazwa");
        lblNewLabel.setBounds(38, 29, 57, 14);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(76, 26, 116, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        Choice choice = new Choice();
        choice.add("Zużyciowe");
        choice.add("Oddanie");
        choice.setBounds(76, 70, 116, 20);
        frame.getContentPane().add(choice);

        JLabel lblNewLabel_1 = new JLabel("Typ");
        lblNewLabel_1.setBounds(38, 70, 46, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Zapisz");
        btnNewButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                Liczydlo liczydlo = new Liczydlo(
                  textField.getText(),
                  choice.getSelectedItem()
                );
                Boolean czy_zam = addLiczydlo(liczydlo);
                if(czy_zam){
                    frame.dispose();
                }

            }
        });
        btnNewButton.setBounds(103, 113, 89, 23);
        frame.getContentPane().add(btnNewButton);
    }

}
