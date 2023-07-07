
package Modelo;

public class CorteCana {
    private String tipoCana;
    private String tipoDia;
    private double tarifa;
    private double toneladas;

    public CorteCana(String tipoCana, String tipoDia, double tarifa, double toneladas) {
        this.tipoCana = tipoCana;
        this.tipoDia = tipoDia;
        this.tarifa = tarifa;
        this.toneladas = toneladas;
    }

    public String getTipoCana() {
        return tipoCana;
    }

    public void setTipoCana(String tipoCana) {
        this.tipoCana = tipoCana;
    }

    public String getTipoDia() {
        return tipoDia;
    }

    public void setTipoDia(String tipoDia) {
        this.tipoDia = tipoDia;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getToneladas() {
        return toneladas;
    }

    public void setToneladas(double toneladas) {
        this.toneladas = toneladas;
    }

    @Override
    public String toString() {
        return "CorteCana{" +
                "tipoCana='" + tipoCana + '\'' +
                ", tipoDia='" + tipoDia + '\'' +
                ", tarifa=" + tarifa +
                ", toneladas=" + toneladas +
                '}';
    }
}
