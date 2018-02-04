/*
 *  PRQ PROYECT 
 *   Made by: Luis Fernando V�squez Quir�s 
 *      - Github: luisf96v
 *      - Email  : luis96v@gmail.com 
 */
package Model.Imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DB {

    public DB() throws ClassNotFoundException, SQLException {        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(this.link, this.user, this.pass);   
    }
    
    public DB(String link, String user, String pass) throws ClassNotFoundException, SQLException {        
        Class.forName("com.mysql.jdbc.Driver");
        this.con = DriverManager.getConnection(link, user, pass); 
    }
    
    public ResultSet executeRS(String proc) throws SQLException{
        CallableStatement cs = con.prepareCall(proc);
        return cs.executeQuery();
    }
   
    public boolean execute(String proc) throws SQLException{
        CallableStatement cs = con.prepareCall(proc);
        return cs.execute();
    }
    
    public void close() throws SQLException{
        con.close();
    }
    
    private final Connection con;
    
    private final String link = "jdbc:mysql://localhost:3306/PRQ?noAccessToProcedureBodies=true";
    private final String user = "emp";
    private final String pass = "emp2017";
}