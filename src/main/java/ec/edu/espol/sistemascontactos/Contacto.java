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

    public Contacto(String nombre, HashMap<String, String> telef, HashMap<String, Direccion> direccion, HashMap<String, Contacto> contactosRelacionados, HashMap<String, String> emails, HashMap<String, String> redesSociales) {
        this.nombre = nombre;
        this.telef = telef;
        this.direccion = direccion;
        this.contactosRelacionados = contactosRelacionados;
        this.emails = emails;
        this.redesSociales = redesSociales;
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
       
    
}
