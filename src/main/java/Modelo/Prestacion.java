
package Modelo;

public class Prestacion {
    private String tipo;
    private double porcentaje;

    public Prestacion(String tipo, double porcentaje) {
        this.tipo = tipo;
        this.porcentaje = porcentaje;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
