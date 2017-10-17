/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueo;

import Entities.Data;
import Entities.PDF;
import View.Fondo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class Parqueo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            /*Fondo i = Data.getFondo();
            i.setVisible(true);
            i.setLocationRelativeTo(null);*/
            new PDF(null,"").generarPDF();
        } catch (IOException ex) {
            Logger.getLogger(Parqueo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
