/*
 *  PRQ PROYECT 
 *   Made by: Luis Fernando V�squez Quir�s 
 *      - Github: luisf96v
 *      - Email  : luis96v@gmail.com 
 */

package Model.DAO;

import Model.Entities.User;
import java.sql.SQLException;


public interface UserDAO {
    public User findUser(String user, String password) throws SQLException;
    public boolean newUser(String name, String user, String password) throws SQLException;
}
