package Control;

import Model.Entities.User;
import View.Principal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectHandler {

    private ProyectHandler() {
        try {
            printer  = new Model.Imp.RgsImp().findValue("PRINTER");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProyectHandler.class.getName()).log(Level.SEVERE, null, ex);
            printer = "";
        }
    }

    public static ProyectHandler instance() {
        if (ph == null) {
            ph = new ProyectHandler();
        }
        return ph;
    }

    public static Principal window() {
        return ProyectHandler.instance().principal();
    }

    public Principal principal() {
        if (window == null) {
            window = new Principal();
        }
        return window;
    }

    public void visibleWindow() {
        window.setVisible(!window.isVisible());
    }

    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    private Principal window;
    private static ProyectHandler ph;
    private String printer;
    private User user;
}
