/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author erick
 */
public class Persona extends Contacto{
    
    //Atributos de la clase persona
    public Date fechaNacimiento;
    public HashMap<String,String> redesSociales;
    
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
    public void mostrarRedesSociales(){
        redesSociales.forEach(());
    }
    
    
}
