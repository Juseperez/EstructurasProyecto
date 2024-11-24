/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ricky
 */
public class Empresa extends Contacto implements Serializable{
    
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
    // Mostrar información del director si existe
    if (this.getContactoDirector() != null) {
        System.out.println("Director:");
        this.getContactoDirector().mostrarInformacion();
    } else {
        System.out.println("No se ha asignado un director a esta empresa.");
    }
    }
    
    // Método para editar la información de la empresa
    public void editarInformacionEmpresa(String nuevoNombre, String nuevaDireccionTrabajo, HashMap<String, String> nuevosTelefonos, HashMap<String, String> nuevosEmails) {
        setNombre(nuevoNombre);
        setDireccionTrabajo(nuevaDireccionTrabajo);
        getTelef().clear();
        getTelef().putAll(nuevosTelefonos);
        getEmails().clear();
        getEmails().putAll(nuevosEmails);
    }
    
    // Método para editar la información del director
    public void editarContactoDirector(Contacto nuevoDirector) {
        setContactoDirector(nuevoDirector);
    }

    // Método para editar teléfonos de la empresa
    public void editarTelefonosEmpresa(HashMap<String, String> nuevosTelefonos) {
        getTelef().clear();
        getTelef().putAll(nuevosTelefonos);
    }

    // Método para editar emails de la empresa
    public void editarEmailsEmpresa(HashMap<String, String> nuevosEmails) {
        getEmails().clear();
        getEmails().putAll(nuevosEmails);
    }

    // Método para editar teléfonos del director
    public void editarTelefonosDirector(HashMap<String, String> nuevosTelefonos) {
        if (contactoDirector != null) {
            contactoDirector.getTelef().clear();
            contactoDirector.getTelef().putAll(nuevosTelefonos);
        }
    }

    // Método para editar emails del director
    public void editarEmailsDirector(HashMap<String, String> nuevosEmails) {
        if (contactoDirector != null) {
            contactoDirector.getEmails().clear();
            contactoDirector.getEmails().putAll(nuevosEmails);
        }
    }


    
}
