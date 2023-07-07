package Modelo;

public class FondoPension {
    private String codigo;
    private String nombre;

    // Constructor
    public FondoPension(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Otros métodos y lógica relacionada con la gestión de FondoPension
    // ...

    @Override
    public String toString() {
        return "FondoPension{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
