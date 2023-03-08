public class Cliente {
   private String correo;
   private String nombre;
   private String apellido;
   private String passwordcliente;
   private String DPI;
   private String fechadenacimiento;
   private String Genero;
   private String nacionalidad; //COMBO BOX
   private String alias;
   private int telefono;
   private String rol; //COMBO BOX

   public Cliente(String correo, String nombre, String apellido, String passwordcliente, String DPI, String fechadenacimiento, String Genero, String nacionalidad, String alias, int telefono, String rol){
      this.correo = correo;
      this.nombre = nombre;
      this.apellido = apellido;
      this.passwordcliente = passwordcliente;
      this.DPI = DPI;
      this.alias = alias;
      this.fechadenacimiento = fechadenacimiento;
      this.telefono = telefono;
   }

   public void setCorreo(String correo) {
      this.correo = correo;
   }

   public String getCorreo() {
      return correo;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getNombre() {
      return nombre;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public String getApellido() {
      return apellido;
   }

   public void setPasswordcliente(String passwordcliente) {
      this.passwordcliente = passwordcliente;
   }

   public String getPasswordcliente() {
      return passwordcliente;
   }

   public void setDPI(String DPI) {
      this.DPI = DPI;
   }

   public String getDPI() {
      return DPI;
   }

   public void setfechadenacimiento(String fechadenacimiento) {
      this.fechadenacimiento = fechadenacimiento;
   }

   public String getfechadenacimiento() {
      return fechadenacimiento;
   }

   public void setAlias(String alias) {
      this.alias = alias;
   }

   public String getAlias() {
      return alias;
   }

   public void setTelefono(int telefono) {
      this.telefono = telefono;
   }

   public int getTelefono() {
      return telefono;
   }
}
