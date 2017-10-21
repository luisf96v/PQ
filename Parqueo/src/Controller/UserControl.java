/*
 *  PRQ PROYECT 
 *   Made by: Luis Fernando Vasquez Quiros 
 *      - Github: luisf96v
 *      - Email  : luis96v@gmail.com 
 */
package Controller;

import BD.DB;
import Entities.User;
import java.sql.SQLException;

public final class UserControl {    
    
    private UserControl(){}
    
    public static UserControl getInstance(){
        if(uc == null){
            uc = new UserControl(); 
        }
        return uc;    }

    public static User getUser() {
        return user;
    }
    
    public boolean doLogIn(String user, String pass) throws SQLException{
        DB base = new DB();
        String name = base.logIn(user,pass);
        if(name != null){
            UserControl.user = new User(name,user);
            return true;
        }
        return false;
    }
    
    
    private static User user;
    private static UserControl uc;
}
