package Control;

import Model.Entities.Rgs;
import View.Panels.System.Configuracion;
import View.Panels.Rgs.RgsIn;
import View.Panels.Rgs.RgsList;
import View.Panels.Rgs.RgsOut;
import javax.swing.JPanel;

/**
 *
 * @author luisf
 */
public class PanelFactory {

    PanelFactory() {
    }

    public static JPanel createPanel(int type) {
        switch (type) {
            case IN:
                return new RgsIn(1);
            case LIST:
                return new RgsList();
         /*   case INFO:
                return new RgsInfo("");*/
            case OUT:
                return new RgsOut(null);
            case CONFIG:
                return new Configuracion();
            default:
                return null;
        }
    }

    public static void openPanel(int type, Object... args) {
        switch (type) {
            case IN:
                if (args.length == 0) {
                    ProyectHandler.window().panelIn(1);
                } else {
                    ProyectHandler.window().panelIn((int) args[0]);
                }
                break;
            case LIST:
                ProyectHandler.window().panelList();
                break;
         /*   case INFO:
                ProyectHandler.window().setPanel(
                        new RgsInfo((String) args[0]),
                        (String) args[1]
                );
                break;*/
            case OUT:
                ProyectHandler.window().setPanel(
                        new RgsOut((Rgs) args[0]),
                        (String) args[1]
                );
                break;
            case CONFIG:
                ProyectHandler.window().panelConifg();
                break;
        }
    }

    public final static int IN = 0;
    public final static int INFO = 1;
    public final static int LIST = 2;
    public final static int OUT = 3;
    public final static int CONFIG = 4;
}
