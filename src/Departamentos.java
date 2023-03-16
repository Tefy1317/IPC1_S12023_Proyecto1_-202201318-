public class Departamentos extends Regiones{
    private String nombredepartamento;
    private String codigodepartamento;

    public Departamentos(String codigoregion, String nombre, double precioestandar, double precioespecial, String nombredepartamento, String codigodepartamento){
       super(codigoregion,nombre, precioestandar, precioespecial);
        this.nombredepartamento = nombredepartamento;
        this.codigodepartamento = codigodepartamento;
    }

    public String getNombredepartamento() {
        return nombredepartamento;
    }

    public String getCodigodepartamento() {
        return codigodepartamento;
    }

    public void setNombredepartamento(String nombredepartamento) {
        this.nombredepartamento = nombredepartamento;
    }

    public void setCodigodepartamento(String codigodepartamento) {
        this.codigodepartamento = codigodepartamento;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "Codigo región='" + getCodigoregion() + '\'' +
                ", región='" + getNombreregion() + '\'' +
                ", nombre=" + nombredepartamento+ '\'' +
                ", código departamento='" + codigodepartamento +
                '}';
    }
}
