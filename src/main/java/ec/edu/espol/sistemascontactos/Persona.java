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

        // Comprobamos si la persona tiene contactos asociados
        if (persona.getContactosRelacionados() == null || persona.getContactosRelacionados().miCabecera == null) {
            System.out.println("No hay contactos asociados para editar.");
            return;
        }

        // Mostrar los contactos asociados
        System.out.println("Contactos asociados de " + persona.getNombre() + ":");
        persona.mostrarContactosAsociados(); // Asumimos que este método muestra la lista de contactos asociados

        System.out.println("Ingrese el nombre del contacto asociado que desea editar:");
        String nombreContacto = scanner.nextLine();

        NodoCircularDoble<Contacto> actual = persona.getContactosRelacionados().miCabecera;
        Contacto contactoEncontrado = null;

        // Recorrer la lista de contactos asociados
        do {
            if (actual.dato.getNombre().equalsIgnoreCase(nombreContacto)) {
                contactoEncontrado = actual.dato;
                break;
            }
            actual = actual.siguiente;
        } while (actual != persona.getContactosRelacionados().miCabecera);

        if (contactoEncontrado == null) {
            System.out.println("No se encontro un contacto asociado con ese nombre.");
            return;
        }

        // Si el contacto es encontrado, se pueden editar sus datos
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
                    contactoEncontrado.setNombre(nuevoNombre);
                    System.out.println("Nombre actualizado.");
                    break;
                case 2:
                    HashMap<String, String> nuevosTelefonos = new HashMap<>();
                    System.out.println("Ingrese el tipo de teléfono (Movil, Oficina, etc.):");
                    String tipoTelefono = scanner.nextLine();
                    System.out.println("Ingrese el numero de telefono:");
                    String numeroTelefono = scanner.nextLine();
                    nuevosTelefonos.put(tipoTelefono, numeroTelefono);
                    contactoEncontrado.getTelef().clear();  // Limpiar los teléfonos actuales
                    contactoEncontrado.getTelef().putAll(nuevosTelefonos);
                    System.out.println("Telefonos actualizados.");
                    break;
                case 3:
                    HashMap<String, String> nuevosEmails = new HashMap<>();
                    System.out.println("Ingrese el tipo de email (Personal, Trabajo, etc.):");
                    String tipoEmail = scanner.nextLine();
                    System.out.println("Ingrese el email:");
                    String email = scanner.nextLine();
                    nuevosEmails.put(tipoEmail, email);
                    contactoEncontrado.getEmails().clear();  // Limpiar los emails actuales
                    contactoEncontrado.getEmails().putAll(nuevosEmails);
                    System.out.println("Emails actualizados.");
                    break;
                case 4:
                    // Solo permitir editar redes sociales si el contacto es de tipo Persona
                    if (contactoEncontrado instanceof Persona) {
                        Persona personaContacto = (Persona) contactoEncontrado;
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
