/*
 *  PRQ PROYECT 
 *   Made by: Luis Fernando V�squez Quir�s 
 *      - Github: luisf96v
 *      - Email  : luis96v@gmail.com 
 */
package Model.Entities;

public final class User {

    public User(String name, String user) {
        this.name = name;
        this.user = user;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    private String name;
    private String user;
}
