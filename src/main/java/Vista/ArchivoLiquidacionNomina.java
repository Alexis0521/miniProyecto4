/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.LiquidacionNomina;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoLiquidacionNomina {

    private static final String ARCHIVO_LIQUIDACIONES = "liquidaciones.txt";

    public static void guardarLiquidaciones(List<LiquidacionNomina> liquidaciones) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_LIQUIDACIONES))) {
            for (LiquidacionNomina liquidacion : liquidaciones) {
                String linea = liquidacion.getId() + ";" + liquidacion.getFecha().getTime() + ";" + liquidacion.getEmpleado().getIdentificacion() + "\n";
                writer.write(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
