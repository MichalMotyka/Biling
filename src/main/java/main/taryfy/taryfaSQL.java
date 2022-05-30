package main.taryfy;

import lombok.SneakyThrows;
import main.SQLStatment;
import main.entity.Liczydlo;
import main.entity.Taryfa;

import java.sql.ResultSet;

public abstract class taryfaSQL {
    SQLStatment sqlStatment = new SQLStatment();
    String SQL;

    ResultSet getAllLiczydla(){
        SQL = "Select nazwa AS Nazwa, typ AS Typ from Liczydla where aktyw='T'";
        return sqlStatment.getSQL(SQL);
    }

    ResultSet getTaryfy(){
        SQL = "Select Nazwa,id AS NRW from Taryfa where aktyw='T'";
        return sqlStatment.getSQL(SQL);
    }

    @SneakyThrows
    void saveTaryfeSQL(Taryfa taryfa){
        SQL="Insert INTO Taryfa(Nazwa,aktyw) values('"+taryfa.getNazwa()+"','T') Select @@IDENTITY AS ID";
        ResultSet rs =  sqlStatment.getSQL(SQL);
        if(rs.next()){
            taryfa.setId(rs.getString("ID"));
        }
        for (Liczydlo liczydlo:taryfa.getLiczydlaReq()) {
            SQL = "Select id FROM Liczydla where nazwa='"+liczydlo.getName()+"' AND aktyw='T'";
             rs =sqlStatment.getSQL(SQL);
             while(rs.next()){
                 liczydlo.setId(rs.getInt("id"));
             }
            SQL= "INSERT INTO TaryfaSkladniki(taryfa,skladnik,czy_wymag) values("+taryfa.getId()+","+liczydlo.getId()+",'T')";
            sqlStatment.setSQL(SQL);
        }
        for (Liczydlo liczydlo:taryfa.getLiczydlaAdit()) {
            SQL = "Select id FROM Liczydla where nazwa='"+liczydlo.getName()+"' AND aktyw='T'";
            rs = sqlStatment.getSQL(SQL);
            while(rs.next()){
                liczydlo.setId(rs.getInt("id"));
            }
            SQL= "INSERT INTO TaryfaSkladniki(taryfa,skladnik,czy_wymag) values("+taryfa.getId()+","+liczydlo.getId()+",'N')";
            sqlStatment.setSQL(SQL);
        }
    }
    protected ResultSet skladnikiwymag(String id){
        SQL = "Select skladnik from TaryfaSkladniki where czy_wymag='T' AND taryfa="+id;
        return sqlStatment.getSQL(SQL);
    }

    @SneakyThrows
    protected ResultSet skladnikiNiewymag(String id){
        SQL = "Select skladnik from TaryfaSkladniki where czy_wymag='N' AND taryfa="+id;
        ResultSet rs = sqlStatment.getSQL(SQL);
        StringBuilder ids = new StringBuilder();
        while(rs.next()){
            ids.append(rs.getString("skladnik"));
        }
        SQL= "Select nazwa AS Nazwa, typ AS Typ from Liczydla where id in("+ids.toString()+")";
        System.out.println(ids.toString());
        return sqlStatment.getSQL(SQL);
    }
    protected ResultSet getByIdTaryfa(String id){
       SQL= "Select Nazwa from Taryfa where id="+id;
       return sqlStatment.getSQL(SQL);
    }
    protected void dezaktywacja(String id){
        SQL = "UPDATE Taryfa SET aktyw='N' where id="+id;
        sqlStatment.setSQL(SQL);
    }
}
