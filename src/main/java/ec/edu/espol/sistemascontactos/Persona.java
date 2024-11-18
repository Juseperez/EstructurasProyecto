/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author erick
 */
public class Persona extends Contacto implements Serializable{
    
    //Atributos de la clase persona
    public Date fechaNacimiento;
    public HashMap<String,String> redesSociales;
    
    public Persona(String nombre){
        super(nombre);
    }
    
    //Constructor de la clase persona
    public Persona(String nombre, Date fechaNacimiento){
        
        super(nombre);
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
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre de la persona: " + getNombre()+" \n");
        
        
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
        
        System.out.println("Fotos:");
        mostrarFotos();

        System.out.println("Fechas de interés:");
        getFechasDeInteres().forEach((descripcion, fecha) -> {
            System.out.println(descripcion + ": " + fecha);
        });
    }
    
    
}
