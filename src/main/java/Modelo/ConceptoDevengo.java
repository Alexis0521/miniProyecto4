package Modelo;

public class ConceptoDevengo {

    private String codigo;
    private String nombre;
    private boolean hacenBase;
    private double valor;
    private String tipo;
    private double tarifa;
    private double cantidad;

    // Constructor
    public ConceptoDevengo(String codigo, String nombre, boolean hacenBase, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.hacenBase = hacenBase;
        this.valor = valor;
    }

    // Getters y setters
    // ...
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHacenBase() {
        return hacenBase;
    }

    public void setHacenBase(boolean hacenBase) {
        this.hacenBase = hacenBase;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    // Otros métodos y lógica relacionada con la gestión de ConceptoDevengo
    // ...
    @Override
    public String toString() {
        return "ConceptoDevengo{"
                + "codigo='" + codigo + '\''
                + ", nombre='" + nombre + '\''
                + ", hacenBase=" + hacenBase
                + ", valor=" + valor
                + '}';
    }
}
