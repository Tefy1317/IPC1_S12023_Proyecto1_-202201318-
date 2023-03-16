public class Municipios{
    private String codigodepartamento;
    private String nombremunicipio;

    public Municipios(String codigodepartamento, String nombremunicipio){
        this.codigodepartamento = codigodepartamento;
        this.nombremunicipio = nombremunicipio;
    }

    public void setNombremunicipio(String nombre) {
        this.nombremunicipio = nombre;
    }

    public String getNombremunicipio() {
        return nombremunicipio;
    }

    public String getCodigodepartamento() {
        return codigodepartamento;
    }

    public void setCodigodepartamento(String codigodepartamento) {
        this.codigodepartamento = codigodepartamento;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "Codigo departamento='" + codigodepartamento + '\'' +
                ", nombre='" + nombremunicipio +
                '}';
    }
}
