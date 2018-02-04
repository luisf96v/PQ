/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Ticket;

import Model.Imp.RgsImp;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisf
 */
public final class InTicket extends TicketHandler {

    public InTicket(String mat, String in) {
        try {
            RgsImp ri = new RgsImp();

            this.fact = this.fact.replace("{{horario}}",
                    convert(
                            ri.findValue("DAYS")
                                    .concat(" ")
                                    .concat(ri.findValue("HHR"))
                    ));
            this.fact = this.fact.replace("{{mat}}", mat);
            this.fact = this.fact.replace("{{in}}", in);
            this.fact = this.fact.replace("{{telefono}}", ri.findValue("TEL"));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void print() {
        this.PRINT_STRING(fact);
        this.CUT();
    }

    private String fact
            = new StringBuilder()
                    .append("      Parqueo Clinica de San Pablo\n")
                    .append("{{horario}}\n")
                    .append("_________________________________________\n\n")
                    .append("          Ingreso  : {{in}}\n")
                    .append("          Matricula: {{mat}}\n")
                    .append("_________________________________________\n\n")
                    .append("         Gracias por su visita \n")
                    .append("           Contacto {{telefono}}\n")
                    .append("\n\n\n\n\n")
                    .toString();
}
