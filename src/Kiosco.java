public class Kiosco {
    private String codigokiosco;
    private String nombrekiosco;
    private String codigoregion;

    public Kiosco(String codigokiosco, String nombrekiosco, String codigoregion) {
        this.codigokiosco = codigokiosco;
        this.nombrekiosco = nombrekiosco;
        this.codigoregion = codigoregion;
    }

    public void setCodigokiosco(String codigokiosco) {
        this.codigokiosco = codigokiosco;
    }

    public void setCodigoregion(String codigoregion) {
        this.codigoregion = codigoregion;
    }

    public void setNombrekiosco(String nombrekiosco) {
        this.nombrekiosco = nombrekiosco;
    }

    public String getCodigokiosco() {
        return codigokiosco;
    }

    public String getCodigoregion() {
        return codigoregion;
    }

    public String getNombrekiosco() {
        return nombrekiosco;
    }
}
