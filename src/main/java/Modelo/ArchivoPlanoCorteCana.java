package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoPlanoCorteCana {
    private String nombreArchivo;
    private List<CorteCana> cortes;

    public ArchivoPlanoCorteCana(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.cortes = new ArrayList<>();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public List<CorteCana> getCortes() {
        return cortes;
    }

    public void setCortes(List<CorteCana> cortes) {
        this.cortes = cortes;
    }

    public void cargarDatos() {
        try {
            File archivo = new File(nombreArchivo);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");

                if (datos.length == 4) {
                    String tipoCana = datos[0];
                    String tipoDia = datos[1];
                    double tarifa = Double.parseDouble(datos[2]);
                    double toneladas = Double.parseDouble(datos[3]);

                    CorteCana corte = new CorteCana(tipoCana, tipoDia, tarifa, toneladas);
                    cortes.add(corte);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
 