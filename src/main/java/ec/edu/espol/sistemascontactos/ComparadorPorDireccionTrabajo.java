/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;
import java.util.Comparator;
/**
 *
 * @author JUAN PEREZ
 */
public class ComparadorPorDireccionTrabajo implements Comparator<Contacto> {
    public int compare(Contacto c1,Contacto c2){
        boolean esEmpresa1 = c1 instanceof Empresa;
        boolean esEmpresa2 = c2 instanceof Empresa;
        
        if (esEmpresa1 && !esEmpresa2) {
            return -1; // Se pone Empresa antes de Persona
        } else if (!esEmpresa1 && esEmpresa2) {
            return 1; // Se pone Persona después de Empresa
        }
        if(esEmpresa1 && esEmpresa2){
            Empresa e1 = (Empresa) c1;
            Empresa e2 = (Empresa) c2;
            return e1.getDireccionTrabajo().compareToIgnoreCase(e2.getDireccionTrabajo());
        }
        return 0;
    }
}
