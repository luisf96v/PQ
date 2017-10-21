/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Entities.Vehiculo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class DB {

    public DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(link, user, pass);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error con Base de Datos.", "Contacte con el administrador.", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Base de datos apagada.", "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    //===============================================================
    /* Registro */
    //===============================================================
    public Vehiculo createRgs(Vehiculo v) {
        if (con != null) {
            Vehiculo aux  = v;
        
            try {
                Statement stmt = con.createStatement();
                CallableStatement cs = con.prepareCall("{CALL NEW_RGS(?,?)}");
                cs.setString(1, v.getMatricula());
                switch (v.getTipo()) {
                    case "Automóvil Act": {
                        cs.setInt(2, 1);
                        break;
                    }
                    case "Automóvil": {
                        cs.setInt(2, 2);
                        break;
                    }
                    case "Motocicleta": {
                        cs.setInt(2, 3);
                        break;
                    }
                    default: {
                        cs.setInt(2, 4);
                        break;
                    }
                } 
                cs.execute();
                
                ResultSet rs = cs.getResultSet();
                rs.next();
                rs.getDate(1);
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            return aux;
        }
        return null;
    }

    //===============================================================
    /* USER */
    //===============================================================
    public String logIn(String user, String pass) throws SQLException{
        CallableStatement cs = con.prepareCall("{CALL FIND_USER('"+user+"','"+pass+"')}");
        ResultSet rs = cs.executeQuery();
        
        return rs.next()? rs.getString(1) : null;
    }
    
    public List<Vehiculo> registrosFechas(Date d1, Date d2) {
        List<Vehiculo> list = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            CallableStatement cs = con.prepareCall("call Registros_Fechas(?,?)");
            cs.setDate(1, d1);
            cs.setDate(2, d2);
            cs.execute();
            ResultSet rs = cs.getResultSet();

            while (rs.next()) {
                list.add(new Vehiculo(rs.getString(1), rs.getDouble(2)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private Connection con;
    private final String link = "jdbc:mysql://localhost:3306/PRQ?noAccessToProcedureBodies=true";
    private final String user = "emp";
    private final String pass = "emp2017";
}
