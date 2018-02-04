/*
 *  PRQ PROYECT 
 *   Made by: Luis Fernando V�squez Quir�s 
 *      - Github: luisf96v
 *      - Email  : luis96v@gmail.com 
 */
package Model.Imp;

import Model.DAO.UserDAO;
import Model.Entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;


public final class UserImp extends DB implements UserDAO{

    public UserImp() throws ClassNotFoundException, SQLException{
        super();
    }
    
    public UserImp(String link, String user, String pass) throws ClassNotFoundException, SQLException{
        super(link, user, pass);
    }
    
    @Override
    public User findUser(String user, String password) throws SQLException {
        String querry = this.log_proc
                              .replace("{user}", user)
                              .replace("{pass}", password);
        try
        {
            ResultSet rs = this.executeRS(querry);
            return (rs.next())? new User(rs.getString("PROF"), user): null;
        }catch(SQLException ex){
            throw ex;
       } 
    }

    @Override
    public boolean newUser(String user, String name, String password) throws SQLException {
        String querry = this.new_proc
                              .replace("{user}", user)
                              .replace("{pass}", password)
                              .replace("{name}", String.valueOf(name));
        try
        {
            this.execute(querry);
            return true;
        }catch(SQLException ex){
            if(ex.getErrorCode() == 1644){
                return false;
            }
            throw ex;
       } 
    }
    
    private final String log_proc = "{CALL PRQ.FIND_USER('{user}','{pass}')}";
    private final String new_proc = "{CALL PRQ.NEW_USER('{user}','{pass}','{name}')}";
}
