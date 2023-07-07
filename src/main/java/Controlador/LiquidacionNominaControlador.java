package Controlador;

import Modelo.ConceptoDevengo;
import Modelo.ConceptoDeduccion;
import Modelo.Empleado;
import Modelo.LiquidacionNomina;
import DatosDAO.LiquidacionNominaDAO;

import java.util.Date;
import java.util.List;

public class LiquidacionNominaControlador {

    private LiquidacionNominaDAO liquidacionNominaDAO;
    private List<Empleado> empleados;

    public LiquidacionNominaControlador() {
        this.liquidacionNominaDAO = new LiquidacionNominaDAO();
    }

    public void agregarLiquidacionNomina(int id, Date fecha, Empleado empleado, List<ConceptoDevengo> devengos, List<ConceptoDeduccion> deducciones) {
        LiquidacionNomina liquidacionNomina = new LiquidacionNomina(id, fecha, empleado, devengos, deducciones);
        liquidacionNominaDAO.agregarLiquidacion(liquidacionNomina);
    }

    private Empleado obtenerEmpleadoPorIdentificacion(String identificacion) {
        // Aquí asumimos que tienes una lista de empleados preexistente llamada "empleados"
        for (Empleado empleado : empleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return empleado;
            }
        }
        return null; // Si no se encuentra ningún empleado con la identificación proporcionada
    }

    public void eliminarLiquidacionNomina(LiquidacionNomina liquidacionNomina) {
        liquidacionNominaDAO.eliminarLiquidacion(liquidacionNomina);
    }

    public LiquidacionNomina buscarLiquidacionNomina(int id) {
        return liquidacionNominaDAO.buscarLiquidacion(id);
    }

    public List<LiquidacionNomina> obtenerTodasLasLiquidacionesNomina() {
        return liquidacionNominaDAO.obtenerTodasLasLiquidaciones();
    }

    public double calcularTotalDevengos(LiquidacionNomina liquidacionNomina) {
        return liquidacionNomina.calcularTotalDevengos();
    }

    public double calcularTotalDeducciones(LiquidacionNomina liquidacionNomina) {
        return liquidacionNomina.calcularTotalDeducciones();
    }

    public double calcularSalarioNeto(LiquidacionNomina liquidacionNomina) {
        return liquidacionNomina.calcularSalarioNeto();
    }

    public double calcularDeduccionSalud(LiquidacionNomina liquidacionNomina) {
        double devengosBase = calcularTotalDevengos(liquidacionNomina);
        double salarioMinimoVigente = obtenerSalarioMinimoVigente();

        if (devengosBase < salarioMinimoVigente) {
            return salarioMinimoVigente * 0.04;
        } else {
            return devengosBase * 0.04;
        }
    }

    public double calcularDeduccionPension(LiquidacionNomina liquidacionNomina) {
        double devengosBase = calcularTotalDevengos(liquidacionNomina);
        double salarioMinimoVigente = obtenerSalarioMinimoVigente();

        if (devengosBase < salarioMinimoVigente) {
            return salarioMinimoVigente * 0.04;
        } else {
            return devengosBase * 0.04;
        }
    }

    // Otros métodos y lógica relacionada con el controlador de liquidaciones de nómina
    // ...
    private double obtenerSalarioMinimoVigente() {
        return 1300606.0; // Valor del salario mínimo vigente proporcionado: 1.300.606
    }

    @Override
    public String toString() {
        return "LiquidacionNominaControlador{"
                + "liquidacionNominaDAO=" + liquidacionNominaDAO
                + '}';
    }
}
