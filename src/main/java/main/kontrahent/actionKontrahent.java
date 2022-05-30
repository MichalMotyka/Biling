package main.kontrahent;

import main.ErrorScreen;
import main.Kontrahent;
import main.KontrahentList;
import main.entity.Adres;
import main.entity.kontrahent;
import net.proteanit.sql.DbUtils;

import javax.validation.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;


public abstract class actionKontrahent extends kontrahentSQL{


     public String saveKontrahent(@Valid kontrahent kontrahent, int tryb) throws SQLException {
         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         Validator validator = factory.getValidator();
         Set<ConstraintViolation<kontrahent>> validate = validator.validate(kontrahent);
         String id = null;
         if (validate.size() == 0) {
             if (tryb == 0) {
                ResultSet rs = insertKontrahent(kontrahent);
                if(rs.next()){
                    id= rs.getString("ID");
                }
             }
             if (tryb == 1) {
                 UpdateKontrahent(kontrahent);
             }
         }else {
             ErrorScreen errorScreen = new ErrorScreen();
             errorScreen.errorScreen();
             validate.forEach(validat -> errorScreen.addRow(validat.getMessage()));
         }
         return id;
     }

     public void getAllKontrahent(){
         KontrahentList.getTable().setModel(DbUtils.resultSetToTableModel(getKontrahent()));
     }
     public void getHisData(String id){
         Kontrahent.getTable().setModel(DbUtils.resultSetToTableModel(getDaneHistoryczne(id)));
     }
     public void getAllKontrahent(String parametr){
         KontrahentList.getTable().setModel(DbUtils.resultSetToTableModel(getKontrahent(parametr)));
     }
     public ResultSet getKontrahentByID(String id){
         return getKontrahentById(id,"holder");
     }
     public kontrahent getKontrahentData(String id) throws SQLException {
         ResultSet rs = getKontrahentById(id);
         kontrahent kontrahent = null;
         if(rs.next()){
                     kontrahent = new kontrahent(
                     rs.getString("nazwa"),
                     rs.getString("pesel"),
                     rs.getString("NIP"),
                     rs.getInt("saldo"),
                     rs.getInt("idAdres"),
                     rs.getInt("idAdresKores"),
                     rs.getString("prosument"),
                     rs.getInt("nrwPPE"),
                     rs.getString("numerDomu"),
                     rs.getString("numerDomuKores")
             );
                     kontrahent.setId(rs.getInt("ID"));


         }
         return kontrahent;
     }
     public Adres getAdres(String id) throws SQLException {
         Adres adres = null;
         ResultSet rs = getAdresById(id);
         ResultSet rs1 = getPocztaById(id);
         if(rs.next()){
           if (rs1.next()){
               adres = new Adres(
                       rs.getString("Nazwa"),
                       rs.getString("GUS"),
                       rs1.getString("Poczta"),
                       rs1.getString("kod"));
           }
         }
         return adres;
     }

}
