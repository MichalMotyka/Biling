package main.liczydla;

import main.SQLStatment;
import main.entity.Liczydlo;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class liczydlaSQL {
    SQLStatment sqlStatment = new SQLStatment();
    String SQL = "";

    public ResultSet setLiczydlo(Liczydlo liczydlo) throws SQLException {
        SQL = "Select * from Liczydla where nazwa='"+liczydlo.getName()+"' AND aktyw='T'";
        ResultSet rs = sqlStatment.getSQL(SQL);
        if(rs.next()){
            return rs;
        }
        SQL = "IF NOT Exists(Select * from Liczydla where nazwa='"+liczydlo.getName()+"' and aktyw='T')\n" +
                "Begin\n" +
                "Insert into Liczydla values('"+liczydlo.getName()+"','"+liczydlo.getType()+"','T')\n" +
                "end";
        sqlStatment.setSQL(SQL);
        return null;
    }
    public ResultSet getAllLiczydlaSQL(){
        SQL = "Select nazwa AS Nazwa, typ AS Typ from Liczydla where aktyw='T'";
        return sqlStatment.getSQL(SQL);
    }
    public void anulujLiczydlo(Liczydlo liczydlo){
        SQL = "UPDATE Liczydla set aktyw='N' where nazwa='"+liczydlo.getName()+"'";
        sqlStatment.setSQL(SQL);
    }
    public ResultSet findLiczydlo(String nazwa){
        SQL = "Select nazwa AS Nazwa, typ as Typ from Liczydla where nazwa='"+nazwa+"' AND aktyw='T'";
        return sqlStatment.getSQL(SQL);
    }
}
