package Modelo;

public abstract class PrestacionSocial {
    protected Empleado empleado;
    protected double valor;

    public PrestacionSocial(Empleado empleado, double valor) {
        this.empleado = empleado;
        this.valor = valor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public double getValor() {
        return valor;
    }

    public abstract String getNombrePrestacion();
}
