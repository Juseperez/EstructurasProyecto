/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.util.Date;
import java.util.Scanner;
import java.util.HashMap;
/**
 *
 */
public class Agenda {
    Scanner scanner = new Scanner(System.in);
    private CustomListaCircularEnlazadaDoble<Contacto> contactos;
    
    public Agenda(){
        this.contactos = new CustomListaCircularEnlazadaDoble<>();
    }
    
    public void agregarContacto() {
        HashMap <String,String> telef=null;
        String nombre;
        String tipo;
        String value;
        HashMap<String,Direccion> direccion=null;
        HashMap<String, Contacto> contactosRelacionados=null;
        HashMap<String,String> emails=null;
        HashMap<String, String> redesSociales=null;
        int otro;
        System.out.println("1. Agregar una persona");
        System.out.println("2. Agregar una empresa");
        System.out.println("Intgrese su opción:");
        int opcion = scanner.nextInt();
        if(opcion==1){
            System.out.println("Ingresar nombre: ");
            nombre = scanner.nextLine();
            do{
            System.out.println("Ingresar el numero de telefono: ");
            value = scanner.nextLine();
            System.out.println("¿Qué tipo de telefono es? (De trabajo, casa...): ");
            tipo = scanner.nextLine();
            telef.put(tipo, value);
            System.out.println("¿Va a ingresar otro número?: (1 Si sí, cualquier otro número no) ");
            otro = scanner.nextInt();
            }while(otro==1);
            do{
            System.out.println("Ingrese su correo: ");
            value = scanner.nextLine();
            System.out.println("¿Qué tipo de correo es? (De trabajo, casa...): ");
            tipo = scanner.nextLine();
            emails.put(tipo, value);
            System.out.println("¿Va a ingresar otro email?: (1 Si sí, cualquier otro número no) ");
            otro = scanner.nextInt();
            }while(otro==1);
            do{
            System.out.println("Ingrese una red social (Youtube, LinkedIn,etc): ");
            tipo = scanner.nextLine();
            System.out.println("Ingrese el link del contacto: ");
            value = scanner.nextLine();
            redesSociales.put(tipo, value);
            System.out.println("¿Va a ingresar otra red social?: (1 Si sí, cualquier otro número no) ");
            otro = scanner.nextInt();
            }while(otro==1);
            
            
            
        }else if (opcion ==2){
            
        }
        //Contacto contacto
        //contactos.addLast(contacto);
        //System.out.println("Contacto agregado: " + contacto);
    }
    public void agregarEmpresa(){
        
    };
    public void mostrarContactosAdelante() {
        if (contactos == null || contactos.mostrarPosicionContactoActual() == null) {
            System.out.println("La lista no tiene elementos.");
            return;
        }
        contactos.avanzar();
        Contacto contactoActual = contactos.mostrarPosicionContactoActual();

        if (contactoActual != null) {
            contactoActual.mostrarInformacion();
        } else {
            System.out.println("No hay un contacto actual para mostrar.");
        }
    }
    public void mostrarContactosAtras() {
        // Verificar si la lista está vacía
        if (contactos == null || contactos.mostrarPosicionContactoActual() == null) {
            System.out.println("La lista no tiene elementos.");
            return;
        }

        // Retroceder en la lista y mostrar información del contacto actual
        contactos.anterior();
        Contacto contactoActual = contactos.mostrarPosicionContactoActual();

        if (contactoActual != null) {
            contactoActual.mostrarInformacion();
        } else {
            System.out.println("No hay un contacto actual para mostrar.");
        }
    }
    public void eliminarContacto() {
        // Solicitar al usuario el identificador del contacto
        System.out.println("Ingrese el nombre o identificacion del contacto a eliminar:");
        String identificador = scanner.nextLine();

        // Verificamos si la lista de contactos está vacía
        if (contactos == null || contactos.mostrarPosicionContactoActual() == null) {
            System.out.println("No hay contactos en la agenda para eliminar.");
            return;
        }

        // Variable para indicar si se encontró y eliminó el contacto
        boolean eliminado = false;

        // Recorremos la lista circular para buscar el contacto
        NodoCircularDoble<Contacto> actual = contactos.miCabecera; // Nodo actual
        do {
            Contacto contacto = actual.dato; // Obtenemos el contacto del nodo actual

            // Verificamos si el identificador coincide (nombre o identificación única)
            if (contacto.getNombre().equalsIgnoreCase(identificador) || 
                contacto.getIdentificador().equals(identificador)) {

                // Llamamos al método eliminar de CustomListaCircularEnlazadaDoble
                eliminado = contactos.eliminar(contacto);
                break; // Salimos del bucle después de eliminar
            }
            actual = actual.siguiente; // Avanzamos al siguiente nodo
        } while (actual != contactos.miCabecera); // Mientras no completemos el recorrido

        // Mostramos el resultado al usuario
        if (eliminado) {
            System.out.println("El contacto fue eliminado con exito.");
        } else {
            System.out.println("El contacto no fue encontrado.");
        }
    }
    // Crear un contacto de tipo Persona
    public void crearContactoPersona() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la persona:");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese su identificacion:");
        String identificacion = sc.nextLine();
        

        System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd):");
        Date fechaNacimiento;
        try {
            fechaNacimiento = java.sql.Date.valueOf(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Formato de fecha invalido. Intente de nuevo.");
            return;
        }

        Persona persona = new Persona(nombre, identificacion, fechaNacimiento);

        System.out.println("Desea agregar redes sociales (s/n):");
        String respuesta = sc.nextLine();
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese la plataforma (Ej: Instagram):");
            String plataforma = sc.nextLine();
            System.out.println("Ingrese el usuario:");
            String usuario = sc.nextLine();
            persona.agregarRedSocial(plataforma, usuario);

            System.out.println("Desea agregar otra red social (s/n):");
            respuesta = sc.nextLine();
        }

        System.out.println("¿Desea agregar fotos? (s/n):");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            do {
                System.out.println("Ruta de la foto:");
                String foto = sc.nextLine();
                persona.agregarFoto(foto);
                System.out.println("¿Desea agregar otra foto? (s/n):");
            } while (sc.nextLine().equalsIgnoreCase("s"));
        }

        // Agregar el contacto a la lista
        contactos.addLast(persona);
        System.out.println("Contacto creado y agregado a la lista");
    }
    
   public void añadirContactoEmpresa() {
    Scanner scanner = new Scanner(System.in);

    // Solicitar datos de la empresa
    System.out.println("Ingrese el nombre de la empresa:");
    String nombreEmpresa = scanner.nextLine();

    System.out.println("Ingrese la dirección del trabajo:");
    String direccionEmpresa = scanner.nextLine();

    // Solicitar teléfono de la empresa
    HashMap<String, String> telefonosEmpresa = new HashMap<>();
    System.out.println("Ingrese el tipo de teléfono de la empresa (Móvil, Oficina):");
    String tipoTelf = scanner.nextLine();
    System.out.println("Ingrese el número de teléfono:");
    String numTelf = scanner.nextLine();
    telefonosEmpresa.put(tipoTelf, numTelf);

    // Solicitar email de la empresa
    HashMap<String, String> emailsEmpresa = new HashMap<>();
    System.out.println("Ingrese el tipo de email de la empresa (Ejecutivo):");
    String tipoEmail = scanner.nextLine();
    System.out.println("Ingrese el correo electrónico:");
    String correoEmail = scanner.nextLine();
    emailsEmpresa.put(tipoEmail, correoEmail);

    System.out.println("¿Desea asignar un director a esta empresa? (s/n):");
    String respuesta = scanner.nextLine();

    Director director = null; // Inicializamos como null para verificar más adelante

    if (respuesta.equalsIgnoreCase("s")) {
 
        System.out.println("Ingrese el nombre del director:");
        String nombreDirector = scanner.nextLine();

        System.out.println("Ingrese el cargo del director:");
        String cargoDirector = scanner.nextLine();

        // Solicitar telefonos del director
        HashMap<String, String> telefonosDirector = new HashMap<>();
        System.out.println("Ingrese el tipo de teléfono del director (Personal, Ejecutivo):");
        String tipoTelfDirector = scanner.nextLine();
        System.out.println("Ingrese el número de teléfono del director:");
        String numTelfDirector = scanner.nextLine();
        telefonosDirector.put(tipoTelfDirector, numTelfDirector);

        // Solicitar emails del director
        HashMap<String, String> emailsDirector = new HashMap<>();
        System.out.println("Ingrese el tipo de email del director (Personal, Ejecutivo):");
        String tipoEmailDirector = scanner.nextLine();
        System.out.println("Ingrese el correo electrónico del director:");
        String correoEmailDirector = scanner.nextLine();
        emailsDirector.put(tipoEmailDirector, correoEmailDirector);

        // Crear instancia de Director
        director = new Director(nombreDirector, cargoDirector, telefonosDirector, emailsDirector);
    }

    // Crear objeto Empresa
    Empresa empresa;
    if (director != null) {
        empresa = new Empresa(nombreEmpresa, direccionEmpresa, director);
    } else {
        empresa = new Empresa(nombreEmpresa, direccionEmpresa);
    }

    empresa.getTelef().putAll(telefonosEmpresa);
    empresa.getEmails().putAll(emailsEmpresa);

    contactos.addLast(empresa);
    System.out.println("Empresa añadida exitosamente.");
}

}
