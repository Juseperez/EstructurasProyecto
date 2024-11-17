/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ricky
 */
public class Empresa extends Contacto{
    
    private String direccionTrabajo;
    private Contacto contactoDirector;
    
    public Empresa(String nombre, String direccionTrabajo){
        super(nombre);
        setNombre(nombre);
        this.direccionTrabajo = direccionTrabajo;
    }
    
     public Empresa(String nombre, String direccionTrabajo, Contacto contactoDirector) {
        super(nombre);
        setNombre(nombre);
        this.direccionTrabajo = direccionTrabajo;
        this.contactoDirector = contactoDirector;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public Contacto getContactoDirector() {
        return contactoDirector;
    }

    public void setContactoDirector(Contacto contactoDirector) {
        this.contactoDirector = contactoDirector;
    }
    
    public void mostrarInformacionEmpresa() {
        System.out.println("Nombre de la Empresa: /n" + getNombre());
        
        System.out.println("Dirección de Trabajo: /n" + direccionTrabajo);
        
        
        // Muestra los teléfonos
        System.out.println("Telefonos:");
        getTelef().forEach((tipo, numero) -> System.out.println(tipo + ": " + numero));

        System.out.println("Emails:");
        getEmails().forEach((tipo, email) -> System.out.println(tipo + ": " + email));

        
        if (contactoDirector != null) {
            System.out.println("Director:");
            System.out.println("Nombre: " + contactoDirector.getNombre());
            contactoDirector.getTelef().forEach((tipo, numero) -> System.out.println(tipo + " Telefono: " + numero));
            contactoDirector.getEmails().forEach((tipo, email) -> System.out.println(tipo + " Email: " + email));
        }
    }
  
    @Override
    public void mostrarInformacion() {
    System.out.println("Empresa:");
    System.out.println("Nombre: " + this.getNombre());
    System.out.println("Direccion: " + this.getDireccionTrabajo());
    
    // Mostrar teléfonos
    System.out.println("Telefonos:");
    for (String tipo : this.getTelef().keySet()) {
        System.out.println("  " + tipo + ": " + this.getTelef().get(tipo));
    }

    // Mostrar emails
    System.out.println("Emails:");
    for (String tipo : this.getEmails().keySet()) {
        System.out.println("  " + tipo + ": " + this.getEmails().get(tipo));
    }

    // Mostrar Fotos
    System.out.println("Fotos:");
        mostrarFotos();

    // Mostrar Fechas de interés
    System.out.println("Fechas de interés:");
    getFechasDeInteres().forEach((descripcion, fecha) -> {
        System.out.println(descripcion + ": " + fecha);
    });

    // Mostrar información del director si existe
    if (this.getContactoDirector() != null) {
        System.out.println("Director:");
        this.getContactoDirector().mostrarInformacion();
    } else {
        System.out.println("No se ha asignado un director a esta empresa.");
    }
    }

    @Override
    public String getIdentificador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
