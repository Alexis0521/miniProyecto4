package Modelo;

public class ConfiguracionEmpresa {
    private String nit;
    private String razonSocial;
    private String telefono;
    private String direccion;
    private String representanteLegal;
    private String correoContacto;
    private String arlCodigo;
    private String cajaCompensacionCodigo;
    private double salarioMinimoLegalVigente;
    private double auxilioTransporte;
    

    // Constructor
    public ConfiguracionEmpresa(String nit, String razonSocial, String telefono, String direccion, String representanteLegal,
                                String correoContacto, String arlCodigo, String cajaCompensacionCodigo,
                                double salarioMinimoLegalVigente, double auxilioTransporte) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
        this.representanteLegal = representanteLegal;
        this.correoContacto = correoContacto;
        this.arlCodigo = arlCodigo;
        this.cajaCompensacionCodigo = cajaCompensacionCodigo;
        this.salarioMinimoLegalVigente = salarioMinimoLegalVigente;
        this.auxilioTransporte = auxilioTransporte;
    }

    // Getters y setters
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getArlCodigo() {
        return arlCodigo;
    }

    public void setArlCodigo(String arlCodigo) {
        this.arlCodigo = arlCodigo;
    }

    public String getCajaCompensacionCodigo() {
        return cajaCompensacionCodigo;
    }

    public void setCajaCompensacionCodigo(String cajaCompensacionCodigo) {
        this.cajaCompensacionCodigo = cajaCompensacionCodigo;
    }

    public double getSalarioMinimoLegalVigente() {
        return salarioMinimoLegalVigente;
    }

    public void setSalarioMinimoLegalVigente(double salarioMinimoLegalVigente) {
        this.salarioMinimoLegalVigente = salarioMinimoLegalVigente;
    }

    public double getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(double auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    // Otros métodos y lógica relacionada con la gestión de ConfiguracionEmpresa
    // ...

    @Override
    public String toString() {
        return "ConfiguracionEmpresa{" +
                "nit='" + nit + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", representanteLegal='" + representanteLegal + '\'' +
                ", correoContacto='" + correoContacto + '\'' +
                ", arlCodigo='" + arlCodigo + '\'' +
                ", cajaCompensacionCodigo='" + cajaCompensacionCodigo + '\'' +
                ", salarioMinimoLegalVigente=" + salarioMinimoLegalVigente +
                ", auxilioTransporte=" + auxilioTransporte +
                '}';
    }
}
