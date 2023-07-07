package DatosDAO;

import Modelo.Empleado;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    private List<Empleado> empleados;

    private int obtenerIndiceEmpleado(String identificacion) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getIdentificacion().equals(identificacion)) {
                return i;
            }
        }
        return -1;
    }

    // Constructor
    public EmpleadoDAO() {
        this.empleados = new ArrayList<>();
    }

    // Métodos de acceso a datos
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(String identificacion) {
        // Buscar el empleado por su identificación
        Empleado empleado = buscarEmpleado(identificacion);

        if (empleado != null) {
            // Remover el empleado de la lista
            empleados.remove(empleado);
        }
    }
    
    public Empleado obtenerEmpleadoPorIdentificacion(String identificacion) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return empleado;
            }
        }
        return null;
    }

    public Empleado buscarEmpleado(String identificacion) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                return empleado;
            }
        }
        return null;
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleados;
    }

    public boolean editarEmpleado(Empleado empleado) {
        int index = obtenerIndiceEmpleado(empleado.getIdentificacion());
        if (index != -1) {
            empleados.set(index, empleado);
            return true; // Indicar éxito
        } else {
            return false; // Indicar fracaso
        }
    }

    // Otros métodos y lógica relacionada con el acceso a datos de Empleado
    // ...
    @Override
    public String toString() {
        return "EmpleadoDAO{"
                + "empleados=" + empleados
                + '}';
    }
}
