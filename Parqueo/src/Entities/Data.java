package Entities;

import View.Fondo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;

public class Data {

    /*ATRIBUTES*/
    static private Data singleton;
    static private Connection connect;
    static private Fondo fondo;
    /*------------------------------------------*/
    private Data() {
    }

    public static Data getInstance() {
        if (singleton == null) {
            singleton = new Data();
        }
        return singleton;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connect == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Parqueo?" + "user=root&password=root");
        }
        return connect;
    }
    
    public static Fondo getFondo(){
        if(fondo == null){
            fondo = new Fondo(); 
        }
        return fondo;
    }

}
