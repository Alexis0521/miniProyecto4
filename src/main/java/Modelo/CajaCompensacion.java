package Modelo;

public class CajaCompensacion {
    private String codigo;
    private String nombre;

    // Constructor
    public CajaCompensacion(String codigo, String nombre) {
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

    // Otros métodos y lógica relacionada con la gestión de CajaCompensacion
    // ...

    @Override
    public String toString() {
        return "CajaCompensacion{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
