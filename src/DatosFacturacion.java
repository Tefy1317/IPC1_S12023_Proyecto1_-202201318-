public class DatosFacturacion {
    String nombre;
    String direccion;
    String NIT;

    public DatosFacturacion(String nombre, String direccion, String NIT){
        this.nombre = nombre;
        this.direccion = direccion;
        this.NIT = NIT;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNIT() {
        return NIT;
    }

    @Override
    public String toString() {
        return "Datos facturación{" +
                "Nombre completo: " + nombre + '\'' +
                ", dirección: '" + direccion + '\'' +
                ", NIT: " + NIT+
                '}';
    }
}
