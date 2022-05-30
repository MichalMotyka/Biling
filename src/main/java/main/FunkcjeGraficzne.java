package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;





public class FunkcjeGraficzne {
    private String Nazwaprzycisku = "";
    private static boolean czyklik = false;
    private static boolean czyistnieje = false;
    private static List<String> przyciski = new ArrayList<String>();







    public void pobranieMenu(JMenuItem menu,String nazwa) {


    }

    public void dodaniePrzycisku(JPanel panel,Rectangle r) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if(przyciski.size()!=0) {
                    for(int i = 0; i < przyciski.size(); i ++) {
                        if(przyciski.get(i).equals(Nazwaprzycisku)) {
                            czyistnieje = true;
                        }}}
                if(czyklik && !czyistnieje) {
                    System.out.print("tak");
                    JButton btnNewButton = new JButton(Nazwaprzycisku);
                    btnNewButton.setBounds(x, y, 100, 33);
                    btnNewButton.setText(Nazwaprzycisku);
                    btnNewButton.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if(e.getModifiers()==MouseEvent.BUTTON3_MASK) {
                                panel.remove(btnNewButton);
                                for(int i = 0 ; i <przyciski.size();i++) {
                                    if(przyciski.get(i).equals(btnNewButton.getText())) {
                                        przyciski.remove(i);
                                        panel.repaint(r);
                                        break;
                                    }
                                }
                            }
                        }
                    });
                    panel.add(btnNewButton);
                    czyklik = false;
                    przyciski.add(Nazwaprzycisku);
                }}});

    }
}

