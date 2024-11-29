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
    public HashMap<String, String> direcciones;
    public HashMap<String,String> redesSociales;
    
    public Persona(String nombre){
        super(nombre);
    }
    
    //Constructor de la clase persona
    public Persona(String nombre, Date fechaNacimiento){
        
        super(nombre);
        this.fechaNacimiento = fechaNacimiento;
        this.redesSociales = new HashMap<> ();
        this.direcciones = new HashMap<> ();
    }
    
    // Metodos de la clase persona

    @Override
    public HashMap<String, String> getRedesSociales() {
        return redesSociales;
    }
    
    

    public HashMap<String, String> getDirecciones() {
        return direcciones;
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
            System.out.println("\n¿Qué desea editar en el contacto asociado?");
            System.out.println("1. Nombre");
            System.out.println("2. Teléfonos");
            System.out.println("3. Emails");
            System.out.println("4. Redes Sociales");
            System.out.println("5. Direcciones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

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
                    System.out.println("¿Qué desea hacer con los teléfonos?");
                    System.out.println("1. Agregar teléfono");
                    System.out.println("2. Editar teléfono existente");
                    System.out.println("3. Eliminar teléfono");
                    int opcionTelefono = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionTelefono) {
                        case 1:
                            // Agregar teléfono
                            System.out.println("Ingrese el tipo de teléfono (Móvil, Oficina, etc.):");
                            String tipoTelefono = scanner.nextLine();
                            System.out.println("Ingrese el número de teléfono:");
                            String numeroTelefono = scanner.nextLine();
                            persona.getTelef().put(tipoTelefono, numeroTelefono);  // Agregar teléfono
                            System.out.println("Teléfono agregado.");
                            break;
                        case 2:
                            // Editar teléfono existente
                            System.out.println("Ingrese el tipo de teléfono a editar:");
                            String tipoTelefonoEditar = scanner.nextLine();
                            if (persona.getTelef().containsKey(tipoTelefonoEditar)) {
                                System.out.println("Ingrese el nuevo número de teléfono:");
                                String nuevoNumeroTelefono = scanner.nextLine();
                                persona.getTelef().put(tipoTelefonoEditar, nuevoNumeroTelefono);  // Editar teléfono
                                System.out.println("Teléfono editado.");
                            } else {
                                System.out.println("No se encontró el tipo de teléfono para editar.");
                            }
                            break;
                        case 3:
                            // Eliminar teléfono
                            System.out.println("Ingrese el tipo de teléfono a eliminar:");
                            String tipoTelefonoEliminar = scanner.nextLine();
                            if (persona.getTelef().remove(tipoTelefonoEliminar) != null) {
                                System.out.println("Teléfono eliminado.");
                            } else {
                                System.out.println("No se encontró el tipo de teléfono para eliminar.");
                            }
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 3:
                    System.out.println("¿Qué desea hacer con los emails?");
                    System.out.println("1. Agregar email");
                    System.out.println("2. Editar email existente");
                    System.out.println("3. Eliminar email");
                    int opcionEmail = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionEmail) {
                        case 1:
                            // Agregar email
                            System.out.println("Ingrese el tipo de email (Personal, Trabajo, etc.):");
                            String tipoEmail = scanner.nextLine();
                            System.out.println("Ingrese el email:");
                            String email = scanner.nextLine();
                            persona.getEmails().put(tipoEmail, email);  // Agregar email
                            System.out.println("Email agregado.");
                            break;
                        case 2:
                            // Editar email existente
                            System.out.println("Ingrese el tipo de email a editar:");
                            String tipoEmailEditar = scanner.nextLine();
                            if (persona.getEmails().containsKey(tipoEmailEditar)) {
                                System.out.println("Ingrese el nuevo email:");
                                String nuevoEmail = scanner.nextLine();
                                persona.getEmails().put(tipoEmailEditar, nuevoEmail);  // Editar email
                                System.out.println("Email editado.");
                            } else {
                                System.out.println("No se encontró el tipo de email para editar.");
                            }
                            break;
                        case 3:
                            // Eliminar email
                            System.out.println("Ingrese el tipo de email a eliminar:");
                            String tipoEmailEliminar = scanner.nextLine();
                            if (persona.getEmails().remove(tipoEmailEliminar) != null) {
                                System.out.println("Email eliminado.");
                            } else {
                                System.out.println("No se encontró el tipo de email para eliminar.");
                            }
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 4:
                    // Editar redes sociales
                    System.out.println("¿Qué desea hacer con las redes sociales?");
                    System.out.println("1. Agregar red social");
                    System.out.println("2. Editar red social existente");
                    System.out.println("3. Eliminar red social");
                    int opcionRedes = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionRedes) {
                        case 1:
                            // Agregar red social
                            System.out.println("Ingrese la plataforma de la red social (Ej: Instagram, Twitter, etc.):");
                            String plataforma = scanner.nextLine();
                            System.out.println("Ingrese el usuario:");
                            String usuario = scanner.nextLine();
                            persona.agregarRedSocial(plataforma, usuario);  // Agregar red social
                            System.out.println("Red social agregada.");
                            break;
                        case 2:
                            // Editar red social existente
                            System.out.println("Ingrese la plataforma de la red social a editar:");
                            String plataformaEditar = scanner.nextLine();
                            if (persona.getRedesSociales().containsKey(plataformaEditar)) {
                                System.out.println("Ingrese el nuevo usuario:");
                                String nuevoUsuario = scanner.nextLine();
                                persona.getRedesSociales().put(plataformaEditar, nuevoUsuario);  // Editar red social
                                System.out.println("Red social editada.");
                            } else {
                                System.out.println("No se encontró la plataforma para editar.");
                            }
                            break;
                        case 3:
                            // Eliminar red social
                            System.out.println("Ingrese la plataforma de la red social a eliminar:");
                            String plataformaEliminar = scanner.nextLine();
                            if (persona.getRedesSociales().remove(plataformaEliminar) != null) {
                                System.out.println("Red social eliminada.");
                            } else {
                                System.out.println("No se encontró la red social para eliminar.");
                            }
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 5:
                    // Editar direcciones
                    System.out.println("¿Qué desea hacer con las direcciones?");
                    System.out.println("1. Agregar dirección");
                    System.out.println("2. Editar dirección existente");
                    System.out.println("3. Eliminar dirección");
                    int opcionDireccion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionDireccion) {
                        case 1:
                            // Agregar dirección
                            System.out.println("Ingrese el tipo de dirección (Casa, Oficina, etc.):");
                            String tipoDireccion = scanner.nextLine();
                            System.out.println("Ingrese la dirección:");
                            String direccion = scanner.nextLine();
                            persona.getDirecciones().put(tipoDireccion, direccion);  // Agregar dirección
                            System.out.println("Dirección agregada.");
                            break;
                        case 2:
                            // Editar dirección existente
                            System.out.println("Ingrese el tipo de dirección a editar:");
                            String tipoDireccionEditar = scanner.nextLine();
                            if (persona.getDirecciones().containsKey(tipoDireccionEditar)) {
                                System.out.println("Ingrese la nueva dirección:");
                                String nuevaDireccion = scanner.nextLine();
                                persona.getDirecciones().put(tipoDireccionEditar, nuevaDireccion);  // Editar dirección
                                System.out.println("Dirección editada.");
                            } else {
                                System.out.println("No se encontró el tipo de dirección para editar.");
                            }
                            break;
                        case 3:
                            // Eliminar dirección
                            System.out.println("Ingrese el tipo de dirección a eliminar:");
                            String tipoDireccionEliminar = scanner.nextLine();
                            if (persona.getDirecciones().remove(tipoDireccionEliminar) != null) {
                                System.out.println("Dirección eliminada.");
                            } else {
                                System.out.println("No se encontró el tipo de dirección para eliminar.");
                            }
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 6:
                    continuarEdicion = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
