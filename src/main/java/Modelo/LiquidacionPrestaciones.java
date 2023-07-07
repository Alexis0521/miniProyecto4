
package Modelo;

import java.util.Date;

public class LiquidacionPrestaciones {
    private Empleado empleado;
    private Date fecha;
    private double cesantias;
    private double interesCesantias;
    private double primas;
    private double vacaciones;

    public LiquidacionPrestaciones(Empleado empleado, Date fecha, double cesantias, double interesCesantias, double primas, double vacaciones) {
        this.empleado = empleado;
        this.fecha = fecha;
        this.cesantias = cesantias;
        this.interesCesantias = interesCesantias;
        this.primas = primas;
        this.vacaciones = vacaciones;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getCesantias() {
        return cesantias;
    }

    public double getInteresCesantias() {
        return interesCesantias;
    }

    public double getPrimas() {
        return primas;
    }

    public double getVacaciones() {
        return vacaciones;
    }
}
