import javax.swing.*;

public class Regiones {
    private String codigoregion;
    private String nombreregion;
    private double precioespecial;
    private double precioestandar;
    public int numeroenviosregiones = 0 ;
    public Regiones(String codigoregion, String nombre, double precioestandar, double precioespecial) {
        this.codigoregion = codigoregion;
        this.nombreregion = nombre;
        this.precioestandar = precioestandar;
        this.precioespecial = precioespecial;
    }
    public void setCodigoregion(String codigoregion) {
        this.codigoregion = codigoregion;
    }

    public String getCodigoregion() {
        return codigoregion;
    }

    public void setNombreregion(String nombre) {
        this.nombreregion = nombre;
    }

    public String getNombreregion() {
        return nombreregion;
    }

    public void setPrecioespecial(double precioespecial) {
        this.precioespecial = precioespecial;
    }

    public double getPrecioespecial() {
        return precioespecial;
    }

    public void setPrecioestandar(double precioestandar) {
        this.precioestandar = precioestandar;
    }

    public double getPrecioestandar() {
        return precioestandar;
    }

   @Override
    public String toString() {
        return "Region{" +
                "Codigo='" + codigoregion + '\'' +
                ", nombre='" + nombreregion + '\'' +
                ", precio estandar=" + precioestandar +'\'' +
                ", precio especial=" + precioespecial+
                '}';
    }
}

