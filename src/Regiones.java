import javax.swing.*;

public class Regiones {
    private String codigoregion;
    private String nombre;
    private double precioespecial;
    private double precioestandar;
    public Regiones(String codigoregion, String nombre, double precioestandar, double precioespecial) {
        this.codigoregion = codigoregion;
        this.nombre = nombre;
        this.precioestandar = precioestandar;
        this.precioespecial = precioespecial;
    }
    public void setCodigoregion(String codigoregion) {
        this.codigoregion = codigoregion;
    }

    public String getCodigoregion() {
        return codigoregion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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
                ", nombre='" + nombre + '\'' +
                ", precio estandar=" + precioestandar +'\'' +
                ", precio especial=" + precioespecial+
                '}';
    }
}

