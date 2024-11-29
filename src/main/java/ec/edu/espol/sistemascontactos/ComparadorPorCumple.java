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
public class ComparadorPorCumple implements Comparator<Contacto>{
    @Override
    public int compare(Contacto c1,Contacto c2) {
        boolean esPersona1 = c1 instanceof Persona;
        boolean esPersona2 = c2 instanceof Persona;
        
        if (esPersona1 && !esPersona2) {
            return -1; // Se pone Persona antes de Empresa
        } else if (!esPersona1 && esPersona2) {
            return 1; // Se pone Empresa después de Persona
        } else if(esPersona1 && esPersona2) {
            Persona p1 = (Persona) c1;
            Persona p2 = (Persona) c2;
            return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
        }
        return 0;
    }
}