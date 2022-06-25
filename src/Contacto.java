public class Contacto {

    private int id;
    private String apellido;
    private String nombre;
    private String telefono;

    public Contacto() {
    }

    public Contacto(String nombre,String apellido,String telefono) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String setApellido(String apellido) {
        return apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String muestraContacto() {
        return " @ "+nombre+" "+apellido+"\n";
    }

}
