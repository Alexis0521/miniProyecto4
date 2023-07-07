package Modelo;

public class Vacaciones extends PrestacionSocial {

    public Vacaciones(Empleado empleado, double valor) {
        super(empleado, valor);
    }

    @Override
    public String getNombrePrestacion() {
        return "Vacaciones";
    }
}
