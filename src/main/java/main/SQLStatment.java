package main;

import java.sql.*;

public class SQLStatment {
    private ResultSet rs;
    private String frn = "DESKTOP-00LEJPI\\MSSQLSERVER";
    private String fDn = "Biling_SUMA";
    private Connection con;
    private PreparedStatement stmt ;

    public ResultSet getSQL(String SQL) {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://"+ frn + ";databaseName="+ fDn, "sa", "Poczta12!@#$%^");
            stmt = con.prepareStatement(SQL);
            rs = stmt.executeQuery();
        }catch(SQLException e1) {
            e1.printStackTrace();
        }

        return rs;
    }
    public void setSQL(String SQL) {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://"+ frn + ";databaseName="+ fDn, "sa", "Poczta12!@#$%^");
            stmt = con.prepareStatement(SQL);
            stmt.execute();
        }catch(SQLException e1) {
            e1.printStackTrace();
        }
    }
    public int UpdateSQL(String SQL){
        int i = 0;
        try{
            con = DriverManager.getConnection("jdbc:sqlserver://"+ frn + ";databaseName="+ fDn, "sa", "Poczta12!@#$%^");
            stmt = con.prepareStatement(SQL);
             i = stmt.executeUpdate();
        }catch (SQLException e1){
            e1.printStackTrace();
        }
        return i;
    }
}
