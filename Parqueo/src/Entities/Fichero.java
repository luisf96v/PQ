package Entities;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDate;

/**
 *
 * @author luisf
 */
public class Fichero {

    public static void analizaFichero() {

        File data = new File("data.dat");

        try {
            if (analizaReinicio()) {
                if (!data.exists()) {
                    data.createNewFile();
                    vaciaFacturas();
                } else {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(data));
                    bw.write("");
                    bw.close();
                    vaciaFacturas();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean guardarObj(Vehiculo v) {
        List<Vehiculo> lista = buscaLista();

        Iterator<Vehiculo> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Vehiculo aux = (Vehiculo) iterator.next();
            if (aux.getMatricula().equals(v.getMatricula())) {
                return false;
            }
        }
        try {
            lista.add(v);
            BufferedWriter bw = new BufferedWriter(new FileWriter("data.dat"));
            bw.write("");
            bw.close();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
            oos.writeObject(lista);
            oos.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean eliminarObj(Vehiculo v) {
        List<Vehiculo> lista = buscaLista();

        try {
            for (int i = 0; i < lista.size(); i++) {
                Vehiculo aux = (Vehiculo) lista.get(i);
                if (aux.getMatricula().equals(v.getMatricula())) {
                    lista.remove(i);
                    BufferedWriter bw = new BufferedWriter(new FileWriter("data.dat"));
                    bw.write("");
                    bw.close();
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
                    oos.writeObject(lista);
                    oos.close();
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static List<Vehiculo> buscaLista() {
        ObjectInputStream ois = null;
        try {
            try {
                ois = new ObjectInputStream(new FileInputStream("data.dat"));
                ArrayList<Vehiculo> v = (ArrayList<Vehiculo>) ois.readObject();
                ois.close();
                return v;
            } catch (EOFException ex) {
                if (ois != null) {
                    ois.close();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public static void WriteDate(ObjectOutputStream oos) throws IOException {
        LocalDate ld = LocalDate.now();
        oos.writeInt(ld.getDayOfMonth());
        oos.writeInt(ld.getMonthOfYear());
        oos.close();
    }

    public static boolean analizaReinicio() throws IOException {
        File ingreso = new File("ingreso.dat");

        if (!ingreso.exists()) {
            ingreso.createNewFile();
            WriteDate(new ObjectOutputStream(new FileOutputStream("ingreso.dat")));
            return true;
        } else {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream("ingreso.dat"));
                int dia = ois.readInt();
                int mes = ois.readInt();
                ois.close();
                LocalDate lt = LocalDate.now();
                if (lt.getDayOfMonth() == dia && lt.getMonthOfYear() == mes) {
                    return false;
                } else {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("ingreso.dat"));
                    bw.write("");
                    bw.close();
                }
            } catch (EOFException ex) {
                if (ois != null) {
                    ois.close();
                }
            }
            WriteDate(new ObjectOutputStream(new FileOutputStream("ingreso.dat")));
            return true;
        }
    }

    public static void vaciaFacturas() throws IOException {
        File fac = new File("factura.dat");
        if (!fac.exists()) {
            fac.createNewFile();
        } else {
            BufferedWriter bw = new BufferedWriter(new FileWriter("factura.dat"));
            bw.write("");
            bw.close();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("factura.dat"));
        oos.writeChar('A');
        oos.writeInt(1);
        oos.close();
    }

    public static String creaNumFactura() throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("factura.dat"));
        char c = ois.readChar();
        int i = ois.readInt();
        String num = "";
        if (i < 10) {
            num = num.concat("0").concat(String.valueOf(i));
        } else {
            num = String.valueOf(i);
        }
        String s = String.valueOf(c).concat(" - ").concat(num);
        if (++i == 100) {
            i = 1;
            c++;
        }
        ois.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("factura.dat"));
        bw.write("");
        bw.close();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("factura.dat"));
        oos.writeChar(c);
        oos.writeInt(i);
        oos.close();
        return s;
    }
}
