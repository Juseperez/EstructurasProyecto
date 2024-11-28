/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 */
public abstract class Contacto implements Serializable{
       private String nombre;
       private HashMap<String,String> telef;
       private CustomListaCircularEnlazadaDoble<Contacto> contactosRelacionados;
       private HashMap<String,String> emails;
       private HashMap<String, String> redesSociales;
       private ArrayListPropio<String> fotos;
       private HashMap<String,String> fechasDeInteres;
       private static final long serialVersionUID = 1L;
       

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telef = new HashMap<>();
        this.contactosRelacionados = new CustomListaCircularEnlazadaDoble<>();
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

    public CustomListaCircularEnlazadaDoble<Contacto> getContactosRelacionados() {
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



    public ArrayListPropio<String> getFotos() {
        return fotos;
    }

    public HashMap<String, String> getFechasDeInteres() {
        return fechasDeInteres;
    }

    public void agregarContactoAsociado(Contacto contacto) {
        if (contacto != null && !this.getNombre().equals(contacto.getNombre())) {
            this.contactosRelacionados.addLast(contacto);
            contacto.agregarContactoAsociado(this); // Relación bidireccional
        }
    }

    public void mostrarContactosAsociados() {
        NodoCircularDoble<Contacto> actual = this.contactosRelacionados.getMiCabecera();
        for (int i = 0; i < this.contactosRelacionados.size(); i++) {
            System.out.println(actual.dato.getNombre());
            actual = actual.siguiente;
        }
    }
}
