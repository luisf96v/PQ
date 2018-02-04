package Model.Ticket;

import java.util.stream.IntStream;
import javax.print.DocFlavor;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JOptionPane;

public abstract class TicketHandler {

    protected TicketHandler() {
        PrintService printService[]
                = PrintServiceLookup.lookupPrintServices(
                        DocFlavor.BYTE_ARRAY.AUTOSENSE,
                        new HashPrintRequestAttributeSet()
                );

        for (PrintService service : printService) {
            if (service.getName().equalsIgnoreCase(Control.ProyectHandler.instance().getPrinter())) {
                this.printer = service;
            }
        }

        if (printer == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Impresora no detectada, nombre incorrecto.",
                    "Error Fatal con Impresora",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    protected void CUT() {
        try {
            if (printer != null) {
                printer.createPrintJob().
                        print(
                                new SimpleDoc(
                                        new byte[]{0x1d, 0x56, 0x00},// CUT 
                                        DocFlavor.BYTE_ARRAY.AUTOSENSE,
                                        null
                                ),
                                null
                        );
            }
        } catch (PrintException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Fatal con Impresora", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void OPEN_DAWER() {
        try {
            if (printer != null) {
                printer.createPrintJob().
                        print(
                                new SimpleDoc(
                                        new byte[]{27, 112, 48, 55, 121},// OPEN DAWER 
                                        DocFlavor.BYTE_ARRAY.AUTOSENSE,
                                        null
                                ),
                                null
                        );
            }
        } catch (PrintException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Fatal con Impresora", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void PRINT_STRING(String str) {
        try {
            if (printer != null) {
                printer.createPrintJob().
                        print(
                                new SimpleDoc(
                                        str.getBytes(),
                                        DocFlavor.BYTE_ARRAY.AUTOSENSE,
                                        null
                                ),
                                null
                        );
            }
        } catch (PrintException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Fatal con Impresora", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void print() {
        throw new UnsupportedOperationException("method not overridden");
    }

    protected String convert(String str) {
        if (str.length() > 41) {
            return str.substring(0, 40);
        }
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, (40 - str.length()) / 2).forEach(i -> sb.append(" "));
        return sb.append(str).toString();
    }

    private PrintService printer;

}
