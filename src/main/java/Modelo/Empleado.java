package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empleado {

    private String identificacion;
    private String codigo;
    private String apellidos;
    private String nombres;
    private String direccion;
    private String epsCodigo;
    private String fppCodigo;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private Date fechaRetiro;
    private String tipoTrabajador;
    private String tipoSalario;
    private String numeroCuentaBancaria;
    private Map<String, Double> devengos;
    private Map<String, Double> deducciones;
    private List<ArchivoPlanoCorteCana> cortesCaña;

    // Constructor
    public Empleado(String identificacion, String apellidos, String nombres, String direccion,
            String epsCodigo, String fppCodigo, Date fechaNacimiento, Date fechaIngreso, Date fechaRetiro,
            String tipoTrabajador, String tipoSalario, String numeroCuentaBancaria) {
        this.identificacion = identificacion;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.direccion = direccion;
        this.epsCodigo = epsCodigo;
        this.fppCodigo = fppCodigo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.tipoTrabajador = tipoTrabajador;
        this.tipoSalario = tipoSalario;
        this.numeroCuentaBancaria = numeroCuentaBancaria;
        this.devengos = new HashMap<>();
        this.deducciones = new HashMap<>();
        cortesCaña = new ArrayList<>();
    }

    // Getters y setters
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEpsCodigo() {
        return epsCodigo;
    }

    public void setEpsCodigo(String epsCodigo) {
        this.epsCodigo = epsCodigo;
    }

    public String getFppCodigo() {
        return fppCodigo;
    }

    public void setFppCodigo(String fppCodigo) {
        this.fppCodigo = fppCodigo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public String getTipoSalario() {
        return tipoSalario;
    }

    public void setTipoSalario(String tipoSalario) {
        this.tipoSalario = tipoSalario;
    }

    public String getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    public void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }

    // Métodos para manipular los devengos y deducciones
    public void agregarDevengo(String concepto, double valor) {
        devengos.put(concepto, valor);
    }

    public void agregarDeduccion(String concepto, double valor) {
        deducciones.put(concepto, valor);
    }
    
    public void agregarCorteCaña(ArchivoPlanoCorteCana corte) {
        cortesCaña.add(corte);
    }

    public double calcularTotalDevengos() {
        double total = 0;
        for (double valor : devengos.values()) {
            total += valor;
        }
        return total;
    }

    public double calcularTotalDeducciones() {
        double total = 0;
        for (double valor : deducciones.values()) {
            total += valor;
        }
        return total;
    }
    
    
    

    // Otros métodos y lógica relacionada con la gestión de empleados
    // ...
    @Override
    public String toString() {
        return "Empleado{"
                + "identificacion='" + identificacion + '\''
                + ", codigo='" + codigo + '\''
                + ", apellidos='" + apellidos + '\''
                + ", nombres='" + nombres + '\''
                + ", direccion='" + direccion + '\''
                + ", epsCodigo='" + epsCodigo + '\''
                + ", fppCodigo='" + fppCodigo + '\''
                + ", fechaNacimiento=" + fechaNacimiento
                + ", fechaIngreso=" + fechaIngreso
                + ", fechaRetiro=" + fechaRetiro
                + ", tipoTrabajador='" + tipoTrabajador + '\''
                + ", tipoSalario='" + tipoSalario + '\''
                + ", numeroCuentaBancaria='" + numeroCuentaBancaria + '\''
                + ", devengos=" + devengos
                + ", deducciones=" + deducciones
                + '}';
    }
}
