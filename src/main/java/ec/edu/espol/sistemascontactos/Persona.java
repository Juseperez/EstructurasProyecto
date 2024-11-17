/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author erick
 */
public class Persona extends Contacto{
    
    //Atributos de la clase persona
    public Date fechaNacimiento;
    public HashMap<String,String> redesSociales;
    
    //Constructor de la clase persona
    public Persona(String nombre, HashMap<String, String> telef, HashMap<String, Direccion> direccion, HashMap<String, Contacto> contactosRelacionados, HashMap<String, String> emails, HashMap<String, String> redesSociales, Date fechaNacimiento){
        
        super(nombre,telef,direccion,contactosRelacionados,emails,redesSociales);
        this.fechaNacimiento = fechaNacimiento;
        this.redesSociales = new HashMap<> ();
    }
    
    // Metodos de la clase persona
    
    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    public void setFechanacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void agregarRedSocial(String plataforma, String usuario){
        redesSociales.put(plataforma, usuario);
    }
    
    public void elminarRedSocial(String plataforma){
        redesSociales.remove(plataforma);
    }
    
    public void mostrarInformacionPersona() {
        System.out.println("Nombre de la persona: " + getNombre()+" \n");
        
        System.out.println("Fecha de nacimiento: " + fechaNacimiento+" \n");
        
        
        // Muestra los teléfonos
        System.out.println("Teléfonos:");
        getTelef().forEach((tipo, numero) -> System.out.println(tipo + ": " + numero));

        
        System.out.println("Emails:");
        getEmails().forEach((tipo, email) -> System.out.println(tipo + ": " + email));
        
        
        System.out.println("Redes Sociales:");
        redesSociales.forEach((plataforma, usuario) -> {
            System.out.println(plataforma + ": " + usuario);
        });
        
    }
    
    
}
