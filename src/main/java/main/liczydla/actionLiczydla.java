package main.liczydla;

import main.entity.Liczydlo;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class actionLiczydla extends liczydlaSQL{



    protected boolean addLiczydlo(Liczydlo liczydlo) throws SQLException {
        if (setLiczydlo(liczydlo) !=null){
            JOptionPane.showMessageDialog(null,"Liczydło o podanej nazwie już istnieje");
            return false;
        }else {
            JOptionPane.showMessageDialog(null,"Pomyślnie dodano liczydło");
            return true;
        }
    }

    protected void getAllLiczydla(JTable table){
        table.setModel(DbUtils.resultSetToTableModel(getAllLiczydlaSQL()));
    }

    protected void dezaktywujLiczydlo(Liczydlo liczydlo){
        if (liczydlo.getName() != null) {
            anulujLiczydlo(liczydlo);
        }else{
            JOptionPane.showMessageDialog(null,"Nie wybrano liczydła");
        }
    }
    protected ResultSet finByName(String name){
        return findLiczydlo(name);
    }
}
