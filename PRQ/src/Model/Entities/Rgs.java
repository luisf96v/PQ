/*
 *  PRQ PROYECT 
 *   Made by: Luis Fernando V�squez Quir�s 
 *      - Github: luisf96v
 *      - Email  : luis96v@gmail.com 
 */
package Model.Entities;

import java.io.Serializable;
import org.joda.time.DateTime;

/**
 *
 * @author luisf
 */
public final class Rgs implements Serializable {

    public Rgs(String mat, DateTime in, int type, int num) {
        this.mat = mat;
        this.in = in;
        this.setType(type);
        this.num = num;
    }

    public Rgs(String mat, DateTime in, String type, int num) {
        this.mat = mat;
        this.in = in;
        this.type = type;
        this.num = num;
    }

    public Rgs(int type, Double tot) {
        this.setType(type);
        this.tot = tot;
    }

    public Rgs() {
    }

    public String getMatricula() {
        return mat;
    }

    public void setMatricula(String mat) {
        this.mat = mat;
    }

    public Double getTotal() {
        return tot;
    }

    public void setTotal(Double tot) {
        this.tot = tot;
    }

    public DateTime getIn() {
        return in;
    }

    public void setIn(DateTime in) {
        this.in = in;
    }

    public DateTime getOut() {
        return out;
    }

    public void setOut(DateTime out) {
        this.out = out;
    }

    public String getType() {
        return type;
    }

    public void setType(int type) {
        switch (type) {
            case 1:
                this.type = "Automóvil";
                break;
            case 2:
                this.type = "Motocicleta";
                break;
            case 3:
                this.type = "Discapacitado";
                break;
            default:
                this.type = "Otro";
                break;
        }
    }

    public int toIntType() {
        switch (this.type) {
            case "Automóvil":
            case "Automóvil Act":
                return 1;
            case "Motocicleta":
                return 2;
            case "Discapacitado":
                return 3;
            case "Otro":
                return 4;
        }
        return -1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private DateTime in;
    private DateTime out;
    private String type;
    private String mat;
    private Double tot;
    private int num;
}
