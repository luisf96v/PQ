package Entities;

import java.io.Serializable;
import org.joda.time.DateTime;

/**
 *
 * @author luisf
 */
public class Vehiculo implements Serializable {

    public Vehiculo(DateTime ent, String tipo, String mat, String num) {
        this.ent = ent;
        this.tipo = tipo;
        this.mat = mat;
        this.num = num;
    }       
    
    public Vehiculo(String tipo, Double tot){
        this.tipo = tipo;
        this.tot = tot;
    }
    
    public DateTime getEntrada() {
        return ent;
    }

    public void setEntrada(DateTime ent) {
        this.ent = ent;
    }

    public DateTime getSalida() {
        return sal;
    }

    public void setSalida(DateTime sal) {
        this.sal = sal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return mat;
    }

    public void setMatricula(String mat) {
        this.mat = mat;
    }

    public String getNumFac() {
        return num;
    }

    public void setNumFac(String num) {
        this.num = num;
    }

    public Double getTotal() {
        return tot;
    }

    public void setTotal(Double tot) {
        this.tot = tot;
    }
    
    private DateTime ent;
    private DateTime sal;
    private String tipo;
    private String mat;
    private String num;
    private Double tot;
}
