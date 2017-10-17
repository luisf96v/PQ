package Entities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.joda.time.DateTime;

public final class PDF {

    String path;
    List<Vehiculo> lista;

    public PDF(List<Vehiculo> lista, String path) {
        this.lista = lista;
        this.path = path;
    }

    public final void generarPDF() throws IOException {
        DateTime dateTime = new DateTime();

        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream cs = new PDPageContentStream(doc, page);

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_BOLD, 25);
            cs.moveTextPositionByAmount(30, 730);
            cs.drawString("Parqueo Clínica San Pablo");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 15);
            cs.moveTextPositionByAmount(30, 690);
            cs.drawString("Hecho por: Luis Fernando Vasquez.");
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 15);
            cs.moveTextPositionByAmount(30, 660);
            cs.drawString("Fecha Creación: " + dateTime.toString("dd/MM/yyyy HH:mm"));
            cs.endText();

            cs.drawLine(0, 610, 700, 610);
            cs.drawLine(0, 200, 700, 200);

            cs.close();
            doc.save("C:/Users/luisf/Desktop/File.pdf");
            doc.close();
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
        }
    }

    public final void setPath(String path) {
        this.path = path;
    }

    public final void setLista(List<Vehiculo> lista) {
        this.lista = lista;
    }
}
