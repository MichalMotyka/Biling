package main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SlownikAdresow {
    SQLStatment sqls = new SQLStatment();
    String SQL;
    public ResultSet getWojewodztwa(){
        SQL = "select Nazwa,GUS, Prefix AS 'KRAJ' from SlownikAdresow where Typ='województwo' AND stan='A'";
        ResultSet rs =sqls.getSQL(SQL);
        return rs;
    }
    public ResultSet getPowiat(String wojewodztwo){
        SQL = "select Nazwa,GUS from SlownikAdresow where (Typ='powiat' OR Typ = 'miasto na prawach powiatu') AND GUS LIKE '"+wojewodztwo+"%' AND stan='A'";
        ResultSet rs =sqls.getSQL(SQL);
        return rs;
    }
    public ResultSet getMiejscowosc(String powiat){
        SQL = "select Nazwa,GUS,TYP from SlownikAdresow where Typ!='powiat' AND Typ!='województwo' AND GUS LIKE '"+powiat+"%' AND stan='A'";
        ResultSet rs =sqls.getSQL(SQL);
        return rs;
    }
    public ResultSet getDane(String GUS,String NAZWA){
        SQL ="Select Nazwa,Typ,GUS,Prefix,id from SlownikAdresow where GUS='"+GUS+"' AND Nazwa ='"+NAZWA+"' AND stan = 'A'";
        ResultSet rs =sqls.getSQL(SQL);
        return rs;
    }
    public ResultSet findAdres(String NAZWA){
        SQL = "Select Nazwa,GUS,Typ from SlownikAdresow where Nazwa = '"+NAZWA+"' and stan = 'A'";
        ResultSet rs = sqls.getSQL(SQL);
        return rs;
    }
    public int setDaneAdresowe(String GUS,String Nazwa,String TYP,String Prefix){
        SQL = "Insert INTO SlownikAdresow values('"+GUS+"','"+Nazwa+"','"+TYP+"','"+Prefix+"','A')" ;
        return sqls.UpdateSQL(SQL);
    }
    public int setDaneAdresowe(String GUS,String Nazwa,String TYP,String Prefix,String kod,String Poczta,String SGUS,String SNazwa) throws SQLException {
        SQL = "UPDATE SlownikAdresow SET stan = 'N' where GUS='"+SGUS+"'AND Nazwa='"+SNazwa+"' AND stan = 'A'";
        sqls.UpdateSQL(SQL);
        SQL= "Insert INTO SlownikAdresow values('"+GUS+"','"+Nazwa+"','"+TYP+"','"+Prefix+"','A')  SELECT SCOPE_IDENTITY() AS 'id'";
        ResultSet KEY =sqls.getSQL(SQL);
        if(KEY.next()){
            SQL =  "Insert INTO KODYPOCZTOWE(kod,GUS_ID,Poczta) values('"+kod+"',"+KEY.getLong("id")+",'"+Poczta+"')";
        }
        return sqls.UpdateSQL(SQL);
    }
    public ResultSet getKod(String id){
        SQL = "Select kod,Poczta from KODYPOCZTOWE where GUS_ID="+id;
        ResultSet rs =sqls.getSQL(SQL);
        return rs;
    }
    public int  DodKraj(String kraj, String prefix, String maska,String gus){
        SQL="INSERT INTO SlownikPanstw(Panstwo,Prefix,MaskaKodu,MaskaGus) values('"+kraj+"','"+prefix+"','"+maska+"','"+gus+"')";
        return sqls.UpdateSQL(SQL);
    }
    public int EditKraj(String Skraj,String Nkraj,String prefix,String maska,String gus){
        SQL = "Update SlownikPanstw SET Panstwo ='"+Nkraj+"', Prefix='"+prefix+"', MaskaKodu='"+maska+"', MaskaGus='"+gus+"' where Panstwo='"+Skraj+"'";
        return sqls.UpdateSQL(SQL);
    }
    public ResultSet getKraje(){
        SQL = "Select Panstwo,Prefix from SlownikPanstw";
        ResultSet rs = sqls.getSQL(SQL);
        return rs;
    }
    public ResultSet getPantwo(String Panstwo){
        SQL = "Select * From SlownikPanstw where Panstwo ='"+Panstwo+"'";
        ResultSet rs = sqls.getSQL(SQL);
        return  rs;
    }
}
