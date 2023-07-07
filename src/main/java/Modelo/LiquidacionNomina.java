package Modelo;

import java.util.Date;
import java.util.List;

public class LiquidacionNomina {

    private int id;
    private Date fecha;
    private Empleado empleado;
    private List<ConceptoDevengo> devengos;
    private List<ConceptoDeduccion> deducciones;
    private LiquidacionPrestaciones liquidacionPrestaciones;

    public LiquidacionNomina(int id, Date fecha, Empleado empleado, List<ConceptoDevengo> devengos, List<ConceptoDeduccion> deducciones) {
        this.id = id;
        this.fecha = fecha;
        this.empleado = empleado;
        this.devengos = devengos;
        this.deducciones = deducciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<ConceptoDevengo> getDevengos() {
        return devengos;
    }

    public void setDevengos(List<ConceptoDevengo> devengos) {
        this.devengos = devengos;
    }

    public List<ConceptoDeduccion> getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(List<ConceptoDeduccion> deducciones) {
        this.deducciones = deducciones;
    }

    // Método para agregar un concepto de devengo a la lista
    public void agregarDevengo(ConceptoDevengo devengo) {
        devengos.add(devengo);
    }

    // Método para agregar un concepto de deducción a la lista
    public void agregarDeduccion(ConceptoDeduccion deduccion) {
        deducciones.add(deduccion);
    }

    // Método para calcular el total de devengos
    public double calcularTotalDevengos() {
        double total = 0.0;
        for (ConceptoDevengo devengo : devengos) {
            total += devengo.getValor();
        }
        return total;
    }
    
    public double getCesantias() {
        if (liquidacionPrestaciones != null) {
            return liquidacionPrestaciones.getCesantias();
        }
        return 0.0;
    }

    public double getInteresCesantias() {
        if (liquidacionPrestaciones != null) {
            return liquidacionPrestaciones.getInteresCesantias();
        }
        return 0.0;
    }

    public double getPrimas() {
        if (liquidacionPrestaciones != null) {
            return liquidacionPrestaciones.getPrimas();
        }
        return 0.0;
    }

    public double getVacaciones() {
        if (liquidacionPrestaciones != null) {
            return liquidacionPrestaciones.getVacaciones();
        }
        return 0.0;
    }
    
     
    // Método para calcular el total de deducciones
    public double calcularTotalDeducciones() {
        double total = 0.0;
        for (ConceptoDeduccion deduccion : deducciones) {
            total += deduccion.getValor();
        }
        return total;
    }

    // Método para calcular el salario neto
    public double calcularSalarioNeto() {
        double devengosTotales = calcularTotalDevengos();
        double deduccionesTotales = calcularTotalDeducciones();
        return devengosTotales - deduccionesTotales;
    }

    public LiquidacionPrestaciones calcularPrestacionesSociales() {
        double sumatoriaDevengosBase = calcularSumatoriaDevengosBase(devengos);

        double cesantias = sumatoriaDevengosBase * 0.0833;
        double interesCesantias = sumatoriaDevengosBase * 0.01;
        double primas = sumatoriaDevengosBase * 0.0833;
        double vacaciones = sumatoriaDevengosBase * 0.0417;

        liquidacionPrestaciones = new LiquidacionPrestaciones(empleado, new Date(), cesantias, interesCesantias, primas, vacaciones);

        return liquidacionPrestaciones;
    }
    
    

    public double calcularSumatoriaDevengosBase(List<ConceptoDevengo> devengos) {
        double sumatoria = 0.0;
        for (ConceptoDevengo devengo : devengos) {
            if (devengo.getTipo().equals("Cruda")) {
                sumatoria += devengo.getTarifa() * devengo.getCantidad();
            } else if (devengo.getTipo().equals("Quemada")) {
                sumatoria += devengo.getTarifa() * devengo.getCantidad();
            }
        }
        return sumatoria;
    }

    public LiquidacionPrestaciones getPrestacionesSociales() {
        return liquidacionPrestaciones;
    }
    
    

    // Otros métodos y lógica relacionada con la liquidación de nómina
    // ...
    @Override
    public String toString() {
        return "LiquidacionNomina{"
                + "id=" + id
                + ", fecha=" + fecha
                + ", empleado=" + empleado
                + ", devengos=" + devengos
                + ", deducciones=" + deducciones
                + '}';
    }
}
