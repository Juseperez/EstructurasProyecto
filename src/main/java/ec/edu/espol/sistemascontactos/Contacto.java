/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.util.HashMap;

/**
 *
 */
public abstract class Contacto {
       private String nombre;
       private HashMap<String,String> telef;
       private HashMap<String,Direccion> direccion;
       private HashMap<String, Contacto> contactosRelacionados;
       private HashMap<String,String> emails;
       private HashMap<String, String> redesSociales;
       private ArrayListPropio<String> fotos;
       private HashMap<String,String> fechasDeInteres;
       

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telef = new HashMap<>();
        this.direccion = new HashMap<>();
        this.contactosRelacionados = new HashMap<>();
        this.emails = new HashMap<>();
        this.redesSociales = new HashMap<>();
        this.fotos = new ArrayListPropio<>();
        this.fechasDeInteres = new HashMap<>();
    }
       
       

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, String> getTelef() {
        return telef;
    }

    public HashMap<String, Direccion> getDireccion() {
        return direccion;
    }

    public HashMap<String, Contacto> getContactosRelacionados() {
        return contactosRelacionados;
    }

    public HashMap<String, String> getEmails() {
        return emails;
    }

    public HashMap<String, String> getRedesSociales() {
        return redesSociales;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void agregarFoto(String ruta) {
        fotos.add(ruta);
    }
    public void mostrarFotos() {
        System.out.println("Fotos:");
        for (int i = 0; i < fotos.size(); i++) {
            System.out.println(i + ": " + fotos.get(i));
        }
    }
    public String eliminarFoto(int indice) {
        try {
            return fotos.remove(indice);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice de foto inválido.");
            return null;
        }
    }
    public void agregarFechaDeInteres(String descripcion, String fecha) {
        fechasDeInteres.put(descripcion,fecha);
    }
    public void eliminarFechaDeInteres(String descripcion) {
        fechasDeInteres.remove(descripcion);
    }
    public abstract void mostrarInformacion();
    public abstract String getIdentificador();   
    
}
