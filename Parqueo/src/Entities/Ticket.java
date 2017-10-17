/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Entities;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

public class Ticket {

    //Ticket attribute content
    private String t1
            = "      PARQUEO CLINICA DE SAN PABLO\n"
            + "_________________________________________\n\n"
            + "          FACTURA  : {{factura}}\n"
            + "          INGRESO  : {{fecha}}\n"
            //+ "          MATRICULA: {{matricula}}\n"
            + "_________________________________________\n\n"
            + "         GRACIAS POR SU VISITA\n"
            + "           CONTACTO {{telefono}}\n"
            + "\n\n\n\n\n";

    private String t2
            = "      PARQUEO CLINICA DE SAN PABLO\n"
            + "            CED {{cedula}}\n"
            + "_________________________________________\n\n"
            + "          FECHA    : {{fecha}}\n"
            + "          INGRESO  : {{ingreso}}\n"
            + "          SALIDA   : {{salida}}\n"
            //+ "          MINUTOS  : {{tiempo}}\n"
            + "          TOTAL    : {{total}}\n"
            + "_________________________________________\n\n"
            + "         GRACIAS POR SU VISITA\n"
            + "           CONTACTO {{telefono}}\n"
            + "\n\n\n\n\n";

    public Ticket(String factura, String fecha, String matricula, String telefono) {
        this.t1 = this.t1.replace("{{factura}}", factura);
        this.t1 = this.t1.replace("{{fecha}}", fecha);
        this.t1 = this.t1.replace("{{matricula}}", matricula);
        this.t1 = this.t1.replace("{{telefono}}", telefono);
    }

    public Ticket(String cedula, String fecha, String ingreso, String salida, String tiempo, String total, String telefono) {
        this.t2 = this.t2.replace("{{cedula}}", cedula);
        this.t2 = this.t2.replace("{{fecha}}", fecha);
        this.t2 = this.t2.replace("{{ingreso}}", ingreso);
        this.t2 = this.t2.replace("{{salida}}", salida);
        this.t2 = this.t2.replace("{{tiempo}}", tiempo);
        this.t2 = this.t2.replace("{{total}}", total);
        this.t2 = this.t2.replace("{{telefono}}", telefono);
    }

    public void printBytes() {

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService service = findPrintService("POS-80C", printService);

        DocPrintJob job = service.createPrintJob();
        byte[] cutP = new byte[]{0x1d, 'V', 1};

        try {

            Doc doc = new SimpleDoc(cutP, flavor, null);

            job.print(doc, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printEntrada() {
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService service = findPrintService("POS-80C", printService);

        if (service != null) {
            DocPrintJob job = service.createPrintJob();
            byte[] bytes = this.t1.getBytes();

            try {
                Doc doc = new SimpleDoc(bytes, flavor, null);
                job.print(doc, null);
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Error al imprimir: " + er.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe conectar la impresora.");
        }
    }

    public void printSalida() {
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService service = findPrintService("POS-80C", printService);

        if (service != null) {
            DocPrintJob job = service.createPrintJob();
            byte[] bytes = this.t2.getBytes();

            try {
                Doc doc = new SimpleDoc(bytes, flavor, null);
                job.print(doc, null);
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Error al imprimir: " + er.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe conectar la impresora.");
        }
    }
    
    private PrintService findPrintService(String printerName, PrintService[] printService) {
        for (PrintService service : printService) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }
        return null;
    }

}
