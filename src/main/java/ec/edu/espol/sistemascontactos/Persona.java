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
    public String identificacion;
    public HashMap<String,String> redesSociales;
    
    public Persona(String nombre){
        super(nombre);
    }
    
    //Constructor de la clase persona
    public Persona(String nombre,String identificacion, Date fechaNacimiento){
        
        super(nombre);
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.redesSociales = new HashMap<> ();
    }
    
    // Metodos de la clase persona
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
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
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre de la persona: " + getNombre()+" \n");
        
        System.out.println("Identificacion de la persona: "+ identificacion+" \n");
        
        System.out.println("Fecha de nacimiento: " + fechaNacimiento+" \n");
        
        
        // Muestra los teléfonos
        System.out.println("Telefonos:");
        getTelef().forEach((tipo, numero) -> System.out.println(tipo + ": " + numero));

        
        System.out.println("Emails:");
        getEmails().forEach((tipo, email) -> System.out.println(tipo + ": " + email));
        
        
        System.out.println("Redes Sociales:");
        redesSociales.forEach((plataforma, usuario) -> {
            System.out.println(plataforma + ": " + usuario);
        });
        
    }
    
    @Override
    public String getIdentificador() {
        return identificacion; // Retorna la identificación única
    }
    
}
