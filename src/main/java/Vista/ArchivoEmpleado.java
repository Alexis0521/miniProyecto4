package Vista;

import Modelo.Empleado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArchivoEmpleado {

    private static final String ARCHIVO_EMPLEADOS = "empleados.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void guardarEmpleados(List<Empleado> empleados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_EMPLEADOS))) {
            for (Empleado empleado : empleados) {
                String linea = empleado.getIdentificacion() + ";" + empleado.getNombres() + ";" + empleado.getApellidos() + ";" +
                        empleado.getDireccion() + ";" + empleado.getEpsCodigo() + ";" + empleado.getFppCodigo() + ";" +
                        dateFormat.format(empleado.getFechaNacimiento()) + ";" + dateFormat.format(empleado.getFechaIngreso()) + ";" +
                        dateFormat.format(empleado.getFechaRetiro()) + ";" + empleado.getTipoTrabajador() + ";" +
                        empleado.getTipoSalario() + ";" + empleado.getNumeroCuentaBancaria() + "\n";
                writer.write(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Empleado> cargarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_EMPLEADOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(";");
                String identificacion = campos[0];
                String nombres = campos[1];
                String apellidos = campos[2];
                String direccion = campos[3];
                String eps = campos[4];
                String fondoPension = campos[5];
                Date fechaNacimiento = parseFecha(campos[6]);
                Date fechaIngreso = parseFecha(campos[7]);
                Date fechaRetiro = parseFecha(campos[8]);
                String tipoTrabajador = campos[9];
                String tipoSalario = campos[10];
                String numeroCuenta = campos[11];

                Empleado empleado = new Empleado(identificacion, apellidos, nombres, direccion, eps, fondoPension, fechaNacimiento, fechaIngreso, fechaRetiro, tipoTrabajador, tipoSalario, numeroCuenta);
                empleados.add(empleado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empleados;
    }

    private static Date parseFecha(String fechaStr) {
        try {
            return dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

