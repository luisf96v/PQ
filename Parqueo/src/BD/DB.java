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

    public DB() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(link, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Base de datos apagada.", "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            throw ex;
        }
    }

    //===============================================================
    /* Registro */
    //===============================================================
    public void createRegistro(Vehiculo v) {
        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                CallableStatement cs = con.prepareCall("{call new_registro(?,?,?,?,?)}");
                cs.setString(1, v.getMatricula());
                switch (v.getTipo()) {
                    case "Automóvil Act": {
                        cs.setString(2, "N");
                        break;
                    }
                    case "Automóvil": {
                        cs.setString(2, "A");
                        break;
                    }
                    case "Motocicleta": {
                        cs.setString(2, "M");
                        break;
                    }
                    default: {
                        cs.setString(2, "O");
                        break;
                    }
                }
                cs.setString(3, v.getEntrada().toString("yyyy-MM-dd HH:mm:ss"));
                cs.setString(4, v.getEntrada().toString("yyyy-MM-dd HH:mm:ss"));
                cs.setDouble(5, v.getTotal());
                cs.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    private final String link = "jdbc:mysql://localhost:3306/parqueo";
    private final String user = "root";
    private final String pass = "root";
}
