/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class InteresCesantias extends PrestacionSocial {
    public InteresCesantias(Empleado empleado, double valor) {
        super(empleado, valor);
    }

    @Override
    public String getNombrePrestacion() {
        return "Interés de Cesantías";
    }
}
