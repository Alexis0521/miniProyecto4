package DatosDAO;

import Modelo.Empleado;
import Modelo.LiquidacionNomina;

import java.util.ArrayList;
import java.util.List;

public class LiquidacionNominaDAO {

    private List<LiquidacionNomina> liquidaciones;
    private List<Empleado> empleados;

    public LiquidacionNominaDAO() {
        this.liquidaciones = new ArrayList<>();
    }

    public void agregarLiquidacion(LiquidacionNomina liquidacion) {
        liquidaciones.add(liquidacion);
    }

    public void eliminarLiquidacion(LiquidacionNomina liquidacion) {
        liquidaciones.remove(liquidacion);
    }

    

    public LiquidacionNomina buscarLiquidacion(int id) {
        for (LiquidacionNomina liquidacion : liquidaciones) {
            if (liquidacion.getId() == id) {
                return liquidacion;
            }
        }
        return null;
    }

    public List<LiquidacionNomina> obtenerTodasLasLiquidaciones() {
        return liquidaciones;
    }

    // Otros métodos y lógica relacionada con el acceso a datos de LiquidacionNomina
    // ...
    @Override
    public String toString() {
        return "LiquidacionNominaDAO{"
                + "liquidaciones=" + liquidaciones
                + '}';
    }
}
