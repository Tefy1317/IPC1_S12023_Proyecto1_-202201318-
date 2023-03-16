public class Tarjetas {
    private String nombretarjeta;
    private String numerotarjeta;
    private String fechavencimiento;

    public Tarjetas(String nombretarjeta, String numerotarjeta, String fechavencimiento){
        this.nombretarjeta = nombretarjeta;
        this.numerotarjeta = numerotarjeta;
        this.fechavencimiento = fechavencimiento;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getNombretarjeta() {
        return nombretarjeta;
    }

    public void setNombretarjeta(String nombretarjeta) {
        this.nombretarjeta = nombretarjeta;
    }

    public String getNumerotarjeta() {
        return numerotarjeta;
    }

    public void setNumerotarjeta(String numerotarjeta) {
        this.numerotarjeta = numerotarjeta;
    }

    @Override
    public String toString() {
        String cadenatarjeta = this.numerotarjeta;
        int tamano = cadenatarjeta.length();
        String digitos = cadenatarjeta.substring(tamano-4);
        String caracteres = "";
        for(int i =0; i<cadenatarjeta.length()-4; i++){
            caracteres = caracteres + "X";
        }
        cadenatarjeta = caracteres + digitos;

        return "TARJETA{" +
                "Nombre='" + nombretarjeta + '\'' +
                ", número tarjeta='" + cadenatarjeta+'\'' +
                ", fecha de vencimiento=" + fechavencimiento+
                '}';
    }
}
