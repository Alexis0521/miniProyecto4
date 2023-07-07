package Controlador;

import Modelo.Empleado;
import DatosDAO.EmpleadoDAO;

public class EmpleadoControlador {

    private EmpleadoDAO empleadoDAO;

    // Constructor
    public EmpleadoControlador() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    // Métodos de gestión de empleados
    public void agregarEmpleado(Empleado empleado) {
        empleadoDAO.agregarEmpleado(empleado);
    }

    public void eliminarEmpleado(String identificacion) {
        try {
            empleadoDAO.eliminarEmpleado(identificacion);
        } catch (Exception e) {
            e.printStackTrace();
            // Aquí puedes manejar el error de acuerdo a tus necesidades
        }
    }

    public Empleado buscarEmpleado(String identificacion) {
        return empleadoDAO.buscarEmpleado(identificacion);
    }

    public boolean editarEmpleado(Empleado empleado) {
        return empleadoDAO.editarEmpleado(empleado);
    }

    // Otros métodos y lógica relacionada con el controlador de empleados
    // ...
    @Override
    public String toString() {
        return "EmpleadoControlador{" +
                "empleadoDAO=" + empleadoDAO +
                '}';
    }
}
