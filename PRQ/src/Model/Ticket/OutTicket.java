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
public final class OutTicket extends TicketHandler {

    public OutTicket(String num, String in, String out, String period, int total) {
        try {
            RgsImp ri = new RgsImp();
            this.fact = this.fact
                    .replace("{{name}}", convert(ri.findValue("NAME")))
                    .replace("{{cedula}}", convert("Ced. ".concat(ri.findValue("CED"))))
                    .replace("{{num}}", num)
                    //.replace("{{uName}}", convert(ProyectHandler.instance().getUser().getName()))
                    .replace("{{date}}", new org.joda.time.DateTime().toString("dd/MM/yyyy"))
                    .replace("{{in}}", in)
                    .replace("{{out}}", out)
                    .replace("{{period}}", period)
                    .replace("{{total}}", String.valueOf(total))
                    .replace("{{horario}}", convert(
                            ri.findValue("DAYS")
                                    .concat(" ")
                                    .concat(ri.findValue("HHR"))
                    ))
                    .replace("{{tel}}", convert(
                            "Contacto: ".concat(ri.findValue("TEL")))
                    );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OutTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void print() {
        this.PRINT_STRING(fact);
        this.CUT();
        this.OPEN_DAWER();
    }

    private String fact
            = new StringBuilder()
                    .append("{{name}}\n")
                    .append("{{cedula}}\n")
                 //   .append("{{uName}}\n")
                    .append("           Factura No. {{num}}\n")
                    .append("_________________________________________\n\n")
                    .append("          Fecha    : {{date}}\n")
                    .append("          Ingreso  : {{in}}\n")
                    .append("          Salida   : {{out}}\n")
                    .append("          Estadia  : {{period}}\n")
                    .append("          Monto    : {{total}} I.V.I\n")
                    .append("_________________________________________\n\n")
                    .append("{{horario}}\n")
                    .append("{{tel}}\n\n")
                    .append("        Gracias por la confianza\n")
                    .append("\n\n\n\n\n")
                    .toString();

}
