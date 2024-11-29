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
        
        
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
       
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

        System.out.println("Fechas de interes:");
        getFechasDeInteres().forEach((descripcion, fecha) -> {
            System.out.println(descripcion + ": " + fecha);
        });
    }
    
    public void editarContactosAsociadosDePersona(Persona persona) {
        Scanner scanner = new Scanner(System.in);

        boolean continuarEdicion = true;
        while (continuarEdicion) {
            System.out.println("\nQue desea editar en el contacto asociado?");
            System.out.println("1. Nombre");
            System.out.println("2. Telefonos");
            System.out.println("3. Emails");
            System.out.println("4. Redes Sociales");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre del contacto:");
                    String nuevoNombre = scanner.nextLine();
                    persona.setNombre(nuevoNombre);
                    System.out.println("Nombre actualizado.");
                    break;
                case 2:
                    HashMap<String, String> nuevosTelefonos = new HashMap<>();
                    System.out.println("Ingrese el tipo de telefono (Movil, Oficina, etc.):");
                    String tipoTelefono = scanner.nextLine();
                    System.out.println("Ingrese el numero de telefono:");
                    String numeroTelefono = scanner.nextLine();
                    nuevosTelefonos.put(tipoTelefono, numeroTelefono);
                    persona.getTelef().clear();  // Limpiar los teléfonos actuales
                    persona.getTelef().putAll(nuevosTelefonos);
                    System.out.println("Telefonos actualizados.");
                    break;
                case 3:
                    HashMap<String, String> nuevosEmails = new HashMap<>();
                    System.out.println("Ingrese el tipo de email (Personal, Trabajo, etc.):");
                    String tipoEmail = scanner.nextLine();
                    System.out.println("Ingrese el email:");
                    String email = scanner.nextLine();
                    nuevosEmails.put(tipoEmail, email);
                    persona.getEmails().clear();  // Limpiar los emails actuales
                    persona.getEmails().putAll(nuevosEmails);
                    System.out.println("Emails actualizados.");
                    break;
                case 4:
                    // Solo permitir editar redes sociales si el contacto es de tipo Persona
                    if (persona instanceof Persona) {
                        Persona personaContacto = (Persona) persona;
                        System.out.println("Ingrese la plataforma de la red social (Ej: Instagram, Twitter, etc.):");
                        String plataforma = scanner.nextLine();
                        System.out.println("Ingrese el usuario:");
                        String usuario = scanner.nextLine();
                        personaContacto.agregarRedSocial(plataforma, usuario);
                        System.out.println("Red social agregada.");
                    } else {
                        System.out.println("Este contacto no tiene redes sociales.");
                    }
                    break;
                case 5:
                    continuarEdicion = false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }    
}
