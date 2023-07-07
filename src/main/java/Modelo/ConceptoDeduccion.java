package Modelo;

public class ConceptoDeduccion {
    private String codigo;
    private String nombre;
    private double valor;

    public ConceptoDeduccion(String codigo, String nombre, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
    }

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Otros métodos y lógica relacionada con la gestión de ConceptoDeduccion
    // ...

    @Override
    public String toString() {
        return "ConceptoDeduccion{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}
