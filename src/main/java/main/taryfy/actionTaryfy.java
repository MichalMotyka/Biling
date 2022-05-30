package main.taryfy;

import lombok.SneakyThrows;
import main.ErrorScreen;
import main.entity.Liczydlo;
import main.entity.Taryfa;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.validation.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

public abstract class actionTaryfy extends taryfaSQL{

    @SneakyThrows
    protected void setTableModel(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ResultSet rs = getAllLiczydla();
        while(rs.next()){
            model.addRow(new Object[]{rs.getString("Nazwa"),rs.getString("Typ"),false});
        }
    }
    protected Taryfa createTaryfe(ArrayList<Liczydlo> liczydloReQ, ArrayList<Liczydlo> liczydloadit, String nazwa){
        return new Taryfa(liczydloReQ,liczydloadit,nazwa);
    }
    protected void saveTaryfa(@Valid Taryfa taryfa,JFrame frame){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Taryfa>> validate = validator.validate(taryfa);
        if(validate.size() == 0){
            saveTaryfeSQL(taryfa);
            frame.dispose();
        }else {
        ErrorScreen errorScreen = new ErrorScreen();
        errorScreen.errorScreen();
        validate.forEach(validat -> errorScreen.addRow(validat.getMessage()));
        }

    }

    protected  void setTaryfaTable(JTable table){
        table.setModel(DbUtils.resultSetToTableModel(getTaryfy()));
    }
    protected ArrayList selectLiczydlo(JTable table){
        ArrayList<Liczydlo> skladniki = new ArrayList<>();
        for (int x = 0; x < table.getRowCount(); x++){
            if((boolean)table.getModel().getValueAt(x,2)){
                skladniki.add(new Liczydlo((String) table.getModel().getValueAt(x,0), (String) table.getModel().getValueAt(x,1)));
            }
        }
        return skladniki;
    }

    protected void dezaktywujTaryfe(String id){
        dezaktywacja(id);
    }

}
