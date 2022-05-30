package main.kontrahent;

import main.SQLStatment;
import main.entity.kontrahent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public abstract class kontrahentSQL {
    String SQL;
    SQLStatment sqlStatment = new SQLStatment();

    ResultSet insertKontrahent(kontrahent kontrahent){
        SQL = "Insert into kontrahent(nazwa,pesel,NIP,saldo,idAdres,idAdresKores,prosument,nrwPPE,numerDomu,numerDomuKores) values " +
                "('"+kontrahent.getNazwa()+
                "','" + kontrahent.getPesel()+
                "','"+kontrahent.getNIP()+
                "'," + kontrahent.getSaldo()+
                "," + kontrahent.getIdAdres() +
                "," + kontrahent.getIdAdresKores() +
                ",'N'"+
                ","+1+
                ",'"+kontrahent.getNumerDomu() +
                "','"+kontrahent.getNumderDomuKores()+"')  SELECT SCOPE_IDENTITY() as 'ID'";
        return sqlStatment.getSQL(SQL);
    }
    void UpdateKontrahent(kontrahent kontrahent){
        SQL ="INSERT INTO KontrahentDaneHistoryczne(nazwa," +
                "pesel," +
                "NIP," +
                "saldo," +
                "idAdres," +
                "idAdresKores," +
                "prosument," +
                "nrwPPE," +
                "ID_Adres," +
                "numerDomu," +
                "numerDomuKores)" +
                "SELECT " +
                "nazwa" +
                ",pesel" +
                ",NIP" +
                ",saldo" +
                ",idAdres" +
                ",idAdresKores" +
                ",prosument" +
                ",nrwPPE" +
                ",ID" +
                ",numerDomu" +
                ",numerDomuKores FROM kontrahent where id ="+kontrahent.getId()+"  SELECT SCOPE_IDENTITY() as 'ID'";
        ResultSet rs = sqlStatment.getSQL(SQL);
        try {
            if(rs.next()){
                Date date = new Date();
                sqlStatment.UpdateSQL("Update KontrahentDaneHistoryczne SET dataAktualizacji='"+date.toString()+"' where id ="+rs.getString("ID"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        SQL = "Update kontrahent SET nazwa='"+kontrahent.getNazwa()+"',NIP='"+kontrahent.getNIP()+"',pesel='"+kontrahent.getPesel()+"',idAdres="+kontrahent.getIdAdres()
                +",idAdresKores="+kontrahent.getIdAdresKores()+",numerDomu='"+kontrahent.getNumerDomu()+"',numerDomuKores='"+kontrahent.getNumderDomuKores()
                +"' where ID = "+kontrahent.getId();
        sqlStatment.setSQL(SQL);
    }
    ResultSet getKontrahent(){
        SQL = "Select ID AS Kontrahent,nazwa AS Nazwa from kontrahent";
        return sqlStatment.getSQL(SQL);
    }
    ResultSet getKontrahent(String parametr){
        SQL = "Select ID AS Kontrahent, nazwa AS Nazwa from kontrahent where nazwa LIKE '%"+parametr+"%' OR pesel LIKE '"+parametr+"' OR NIP Like '"+parametr+"' OR ID LIKE '"+parametr+"'";
        return sqlStatment.getSQL(SQL);
    }
    ResultSet getKontrahentById(String id){
        SQL = "Select * from kontrahent where ID ="+id;
        return sqlStatment.getSQL(SQL);
    }
    ResultSet getKontrahentById(String id,String table){
        SQL = "Select ID AS Kontrahent, nazwa AS Nazwa from kontrahent where ID ="+id;
        return sqlStatment.getSQL(SQL);
    }
    ResultSet getAdresById(String id){
        SQL = "Select * from SlownikAdresow where id="+id;
        return sqlStatment.getSQL(SQL);
    }
    ResultSet getPocztaById(String id){
        SQL = "Select * from KODYPOCZTOWE where GUS_ID="+id;
        return sqlStatment.getSQL(SQL);
    }
    ResultSet getDaneHistoryczne(String kontrahent){
        SQL ="SELECT " +
                "KontrahentDaneHistoryczne.[nazwa]" +
                ",[pesel]" +
                ",[NIP]" +
                ",SlownikAdresow.Nazwa" +
                ",kores.Nazwa" +
                ",[numerDomu]" +
                ",[numerDomuKores]" +
                ",[dataAktualizacji]" +
                ",[UserLogin] " +
                "FROM KontrahentDaneHistoryczne " +
                "INNER JOIN SlownikAdresow ON SlownikAdresow.ID=KontrahentDaneHistoryczne.idAdres " +
                "INNER JOIN SlownikAdresow as kores ON kores.ID=KontrahentDaneHistoryczne.idAdresKores " +
                "where ID_Adres ="+kontrahent;
        return sqlStatment.getSQL(SQL);
    }
}
