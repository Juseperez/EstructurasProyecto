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
public class ComparadorPorNombre implements Comparator<Contacto> {
    public int compare(Contacto c1,Contacto c2){
        return c1.getNombre().compareToIgnoreCase(c2.getNombre());
    }
}
