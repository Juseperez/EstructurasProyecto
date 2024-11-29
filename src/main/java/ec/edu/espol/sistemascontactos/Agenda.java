/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        // Solicitar al usuario el número de teléfono del contacto a eliminar
        System.out.println("Ingrese el numero de telefono del contacto a eliminar:");
        String telefono = scanner.nextLine();

        // Verificar si la lista de contactos está vacía
        if (contactos == null || contactos.mostrarPosicionContactoActual() == null) {
            System.out.println("No hay contactos en la agenda para eliminar.");
            return;
        }

        // Variable para indicar si se encontró y eliminó el contacto
        boolean eliminado = false;

        // Recorremos la lista circular para buscar el contacto
        NodoCircularDoble<Contacto> actual = contactos.miCabecera; // Obtenemos la cabeza de la lista
        if (actual == null) {
            System.out.println("No hay contactos en la lista.");
            return;
        }

        do {
            Contacto contacto = actual.dato; // Obtenemos el contacto del nodo actual

            // Verificamos si alguno de los números en el HashMap coincide con el teléfono ingresado
            if (contacto.getTelef().containsValue(telefono)) {
                // Eliminamos el contacto
                eliminado = contactos.eliminar(contacto);
                break; // Salimos del bucle después de eliminar
            }

            actual = actual.siguiente; // Avanzamos al siguiente nodo
        } while (actual != contactos.miCabecera); // Mientras no completemos el recorrido

        // Mostramos el resultado al usuario
        if (eliminado) {
            System.out.println("El contacto fue eliminado con exito.");
        } else {
            System.out.println("No se encontro un contacto con ese numero de telefono.");
        }
    }
    public void crearContactoPersona() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la persona:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd):");
        Date fechaNacimiento;
        try {
            fechaNacimiento = java.sql.Date.valueOf(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Formato de fecha invalido. Intente de nuevo.");
            return;
        }

        // Crear la instancia de Persona
        Persona persona = new Persona(nombre, fechaNacimiento);

        // Agregar numeros de telefono
        System.out.println("Desea agregar numeros de telefono (s/n):");
        String respuesta = sc.nextLine();
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el tipo de telefono (Ej: movil, casa, trabajo):");
            String tipo = sc.nextLine();
            System.out.println("Ingrese el numero de telefono:");
            String numero = sc.nextLine();
            persona.getTelef().put(tipo, numero);

            System.out.println("Desea agregar otro numero de telefono (s/n):");
            respuesta = sc.nextLine();
        }
        
        // Agregar direccion
        System.out.println("Desea agregar una direccion (s/n):");
        String direccion = sc.nextLine();
        while (direccion.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el tipo de direccion(casa, trabajo, etc):");
            String tipo = sc.nextLine();
            System.out.println("Ingrese la direccion:");
            String numero = sc.nextLine();
            persona.getDirecciones().put(tipo, numero);

            System.out.println("Desea agregar otro numero de telefono (s/n):");
            direccion = sc.nextLine();
        }
        
        
       
        // Agregar correos electronicos
        System.out.println("Desea agregar correos electronicos (s/n):");
        respuesta = sc.nextLine();
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el tipo de correo (Ej: personal, trabajo):");
            String tipo = sc.nextLine();
            System.out.println("Ingrese el correo:");
            String correo = sc.nextLine();
            persona.getEmails().put(tipo, correo);

            System.out.println("Desea agregar otro correo (s/n):");
            respuesta = sc.nextLine();
        }

        // Agregar redes sociales
        System.out.println("Desea agregar redes sociales (s/n):");
        respuesta = sc.nextLine();
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese la plataforma (Ej: Instagram):");
            String plataforma = sc.nextLine();
            System.out.println("Ingrese el usuario:");
            String usuario = sc.nextLine();
            persona.agregarRedSocial(plataforma, usuario);

            System.out.println("Desea agregar otra red social (s/n):");
            respuesta = sc.nextLine();
        }

        System.out.println("Desea agregar fotos? (s/n):");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            do {
                System.out.println("Ruta de la foto:");
                String foto = sc.nextLine();
                persona.agregarFoto(foto);
                System.out.println("Desea agregar otra foto? (s/n):");
            } while (sc.nextLine().equalsIgnoreCase("s"));
        }
        
        System.out.println("Desea agregar contactos relacionados? (s/n):");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            do {
                Contacto contactoRelacionado = crearContactoPersonaRelacionado();
                persona.getContactosRelacionados().addLast(contactoRelacionado);
                System.out.println("Desea agregar otro contacto relacionado? (s/n):");
            } while (sc.nextLine().equalsIgnoreCase("s"));
        }
        System.out.println("Desea agregar fechas de interes? (s/n):");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            do {
                System.out.println("Descripción de la fecha:");
                String descripcion = sc.nextLine();
                System.out.println("Fecha:");
                String fecha = sc.nextLine();
                persona.agregarFechaDeInteres(descripcion, fecha);
                System.out.println("Desea agregar otra fecha? (s/n):");
            } while (sc.nextLine().equalsIgnoreCase("s"));
        }

        // Agregar el contacto a la lista
        contactos.addLast(persona);
        System.out.println("Contacto creado y agregado a la lista");
    }
    
public void editarDatosPersona() {
    if (contactos == null || contactos.mostrarPosicionContactoActual() == null) {
        System.out.println("No hay contactos disponibles para editar.");
        return;
    }

    System.out.println("Ingrese el nombre de la persona que desea editar:");
    String nombrePersona = scanner.nextLine();
    Contacto contactoEncontrado = null;

    NodoCircularDoble<Contacto> actual = contactos.miCabecera;
    if (actual == null) {
        System.out.println("No hay contactos en la lista.");
        return;
    }

    do {
        if (actual.dato instanceof Persona && actual.dato.getNombre().equalsIgnoreCase(nombrePersona)) {
            contactoEncontrado = actual.dato;
            break;
        }
        actual = actual.siguiente;
    } while (actual != contactos.miCabecera);

    if (contactoEncontrado == null) {
        System.out.println("No se encontro una persona con el nombre especificado.");
        return;
    }

    Persona persona = (Persona) contactoEncontrado;
    boolean continuarEdicion = true;

    while (continuarEdicion) {
        System.out.println("\nQue desea editar?");
        System.out.println("1. Nombre de la persona");
        System.out.println("2. Fecha de nacimiento");
        System.out.println("3. Telefonos de la persona");
        System.out.println("4. Emails de la persona");
        System.out.println("5. Redes sociales");
        System.out.println("6. Direccion");
        System.out.println("7. Fotos asociadas");
        System.out.println("8. Contactos asociados");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opcion: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de linea

        switch (opcion) {
            case 1:
                // Editar nombre
                System.out.println("Ingrese el nuevo nombre de la persona:");
                String nuevoNombre = scanner.nextLine();
                persona.setNombre(nuevoNombre);
                break;
            case 2:
                // Editar fecha de nacimiento
                System.out.println("Ingrese la nueva fecha de nacimiento (yyyy-MM-dd):");
                try {
                    Date nuevaFechaNacimiento = java.sql.Date.valueOf(scanner.nextLine());
                    persona.setFechanacimiento(nuevaFechaNacimiento);
                } catch (Exception e) {
                    System.out.println("Formato de fecha invalido. Intente de nuevo.");
                }
                break;
            case 3:
                // Editar telefonos
                System.out.println("Que desea hacer con los telefonos?");
                System.out.println("1. Agregar telefono");
                System.out.println("2. Editar telefono existente");
                System.out.println("3. Eliminar telefono");
                int opcionTelefono = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de linea

                switch (opcionTelefono) {
                    case 1:
                        System.out.println("Ingrese el tipo de telefono (Movil, Oficina, etc.):");
                        String tipoTelefono = scanner.nextLine();
                        System.out.println("Ingrese el numero de telefono:");
                        String numeroTelefono = scanner.nextLine();
                        persona.getTelef().put(tipoTelefono, numeroTelefono);  // Agregar telefono
                        break;
                    case 2:
                        System.out.println("Ingrese el tipo de telefono a editar:");
                        String tipoTelefonoEditar = scanner.nextLine();
                        if (persona.getTelef().containsKey(tipoTelefonoEditar)) {
                            System.out.println("Ingrese el nuevo numero de telefono:");
                            String nuevoNumeroTelefono = scanner.nextLine();
                            persona.getTelef().put(tipoTelefonoEditar, nuevoNumeroTelefono);  // Editar telefono
                        } else {
                            System.out.println("No se encontro el tipo de telefono para editar.");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el tipo de telefono a eliminar:");
                        String tipoTelefonoEliminar = scanner.nextLine();
                        if (persona.getTelef().remove(tipoTelefonoEliminar) != null) {
                            System.out.println("Telefono eliminado.");
                        } else {
                            System.out.println("No se encontro el telefono para eliminar.");
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
                break;
            case 4:
                // Editar emails
                System.out.println("Que desea hacer con los emails?");
                System.out.println("1. Agregar email");
                System.out.println("2. Editar email existente");
                System.out.println("3. Eliminar email");
                int opcionEmail = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de linea

                switch (opcionEmail) {
                    case 1:
                        System.out.println("Ingrese el tipo de email (Personal, Trabajo, etc.):");
                        String tipoEmail = scanner.nextLine();
                        System.out.println("Ingrese el email:");
                        String email = scanner.nextLine();
                        persona.getEmails().put(tipoEmail, email);  // Agregar email
                        break;
                    case 2:
                        System.out.println("Ingrese el tipo de email a editar:");
                        String tipoEmailEditar = scanner.nextLine();
                        if (persona.getEmails().containsKey(tipoEmailEditar)) {
                            System.out.println("Ingrese el nuevo email:");
                            String nuevoEmail = scanner.nextLine();
                            persona.getEmails().put(tipoEmailEditar, nuevoEmail);  // Editar email
                        } else {
                            System.out.println("No se encontro el tipo de email para editar.");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el tipo de email a eliminar:");
                        String tipoEmailEliminar = scanner.nextLine();
                        if (persona.getEmails().remove(tipoEmailEliminar) != null) {
                            System.out.println("Email eliminado.");
                        } else {
                            System.out.println("No se encontro el email para eliminar.");
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
                break;
            case 5:
                // Editar redes sociales
                System.out.println("Que desea hacer con las redes sociales?");
                System.out.println("1. Agregar red social");
                System.out.println("2. Editar red social existente");
                System.out.println("3. Eliminar red social");
                int opcionRedes = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de linea

                switch (opcionRedes) {
                    case 1:
                        System.out.println("Ingrese la plataforma de la red social (Ej: Instagram, Twitter, etc.):");
                        String plataforma = scanner.nextLine();
                        System.out.println("Ingrese el usuario:");
                        String usuario = scanner.nextLine();
                        persona.agregarRedSocial(plataforma, usuario);  // Agregar red social
                        break;
                    case 2:
                        System.out.println("Ingrese la plataforma de la red social a editar:");
                        String plataformaEditar = scanner.nextLine();
                        if (persona.getRedesSociales().containsKey(plataformaEditar)) {
                            System.out.println("Ingrese el nuevo usuario:");
                            String nuevoUsuario = scanner.nextLine();
                            persona.getRedesSociales().put(plataformaEditar, nuevoUsuario);  // Editar red social
                        } else {
                            System.out.println("No se encontro la red social para editar.");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese la plataforma de la red social a eliminar:");
                        String plataformaEliminar = scanner.nextLine();
                        if (persona.getRedesSociales().remove(plataformaEliminar) != null) {
                            System.out.println("Red social eliminada.");
                        } else {
                            System.out.println("No se encontro la red social para eliminar.");
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
                break;
            case 6:
                // Editar direccion
                System.out.println("Que desea hacer con las direcciones?");
                System.out.println("1. Agregar direccion");
                System.out.println("2. Editar direccion existente");
                System.out.println("3. Eliminar direccion");
                int opcionDireccion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de linea

                switch (opcionDireccion) {
                    case 1:
                        // Agregar direccion
                        System.out.println("Ingrese el tipo de direccion (Casa, Oficina, etc.):");
                        String tipoDireccion = scanner.nextLine();
                        System.out.println("Ingrese la direccion:");
                        String direccion = scanner.nextLine();
                        persona.getDirecciones().put(tipoDireccion, direccion);  // Agregar direccion
                        break;
                    case 2:
                        // Editar direccion existente
                        System.out.println("Ingrese el tipo de direccion a editar:");
                        String tipoDireccionEditar = scanner.nextLine();
                        if (persona.getDirecciones().containsKey(tipoDireccionEditar)) {
                            System.out.println("Ingrese la nueva direccion:");
                            String nuevaDireccion = scanner.nextLine();
                            persona.getDirecciones().put(tipoDireccionEditar, nuevaDireccion);  // Editar direccion
                        } else {
                            System.out.println("No se encontro el tipo de direccion para editar.");
                        }
                        break;
                    case 3:
                        // Eliminar direccion
                        System.out.println("Ingrese el tipo de direccion a eliminar:");
                        String tipoDireccionEliminar = scanner.nextLine();
                        if (persona.getDirecciones().remove(tipoDireccionEliminar) != null) {
                            System.out.println("Direccion eliminada.");
                        } else {
                            System.out.println("No se encontro la direccion para eliminar.");
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
                break;
            case 7:
                // Editar fotos asociadas
                System.out.println("Que desea hacer con las fotos asociadas?");
                System.out.println("1. Agregar foto");
                System.out.println("2. Eliminar foto");
                int opcionFotos = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de linea

                switch (opcionFotos) {
                    case 1:
                        System.out.println("Ingrese la URL de la foto:");
                        String urlFoto = scanner.nextLine();
                        persona.agregarFoto(urlFoto);  // Agregar foto
                        break;
                    case 2:
                        System.out.println("Ingrese el indice de la foto a eliminar:");
                        persona.mostrarFotos();
                        int urlFotoEliminar = scanner.nextInt();
                        persona.eliminarFoto(urlFotoEliminar);  // Eliminar foto
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
                break;
            case 8:
                // Gestionar los contactos asociados
                editarContactosAsociadosDePersona(persona);
                break;
            case 9:
                continuarEdicion = false;
                break;
            default:
                System.out.println("Opcion no valida.");
        }
    }
}

    
   public void añadirContactoEmpresa() {
    Scanner scanner = new Scanner(System.in);

    // Solicitar datos de la empresa
    System.out.println("Ingrese el nombre de la empresa:");
    String nombreEmpresa = scanner.nextLine();

    System.out.println("Ingrese la direccion del trabajo:");
    String direccionEmpresa = scanner.nextLine();

    // Solicitar teléfono de la empresa
    HashMap<String, String> telefonosEmpresa = new HashMap<>();
    System.out.println("Ingrese el tipo de telefono de la empresa (Movil, Oficina):");
    String tipoTelf = scanner.nextLine();
    System.out.println("Ingrese el numero de telefono:");
    String numTelf = scanner.nextLine();
    telefonosEmpresa.put(tipoTelf, numTelf);

    // Solicitar email de la empresa
    HashMap<String, String> emailsEmpresa = new HashMap<>();
    System.out.println("Ingrese el tipo de email de la empresa (Ejecutivo):");
    String tipoEmail = scanner.nextLine();
    System.out.println("Ingrese el correo electronico:");
    String correoEmail = scanner.nextLine();
    emailsEmpresa.put(tipoEmail, correoEmail);

    System.out.println("Desea asignar un director a esta empresa? (s/n):");
    String respuesta = scanner.nextLine();

    Director director = null; // Inicializamos como null para verificar más adelante

    if (respuesta.equalsIgnoreCase("s")) {
 
        System.out.println("Ingrese el nombre del director:");
        String nombreDirector = scanner.nextLine();

        System.out.println("Ingrese el cargo del director:");
        String cargoDirector = scanner.nextLine();

        // Solicitar telefonos del director
        HashMap<String, String> telefonosDirector = new HashMap<>();
        System.out.println("Ingrese el tipo de telefono del director (Personal, Ejecutivo):");
        String tipoTelfDirector = scanner.nextLine();
        System.out.println("Ingrese el numero de telefono del director:");
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
    System.out.println("Empresa agregada exitosamente.");
}

    public void guardarContactos(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            NodoCircularDoble<Contacto> actual = contactos.miCabecera;
            if (actual != null) {
                do {
                    oos.writeObject(actual.dato);
                    actual = actual.siguiente;
                } while (actual != contactos.miCabecera);
            }
            System.out.println("Contactos guardados exitosamente como binarios.");
        } catch (IOException e) {
            System.err.println("Error al guardar contactos: " + e.getMessage());
        }
    }

    public void cargarContactos(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                try {
                    Contacto contacto = (Contacto) ois.readObject();
                    contactos.addLast(contacto);
                } catch (EOFException e) {
                    break; // Fin del archivo
                }
            }
            System.out.println("Contactos cargados exitosamente desde archivo binario.");
        } catch (IOException | ClassNotFoundException e) {
            //System.err.println("Error al cargar contactos: " + e.getMessage());
        }
    }
    
    public void editarDatosEmpresa() {
        if (contactos == null || contactos.mostrarPosicionContactoActual() == null) {
            System.out.println("No hay contactos disponibles para editar.");
            return;
        }

        System.out.println("Ingrese el nombre de la empresa que desea editar:");
        String nombreEmpresa = scanner.nextLine();
        Contacto contactoEncontrado = null;

        NodoCircularDoble<Contacto> actual = contactos.miCabecera;
        if (actual == null) {
            System.out.println("No hay contactos en la lista.");
            return;
        }

        do {
            if (actual.dato instanceof Empresa && actual.dato.getNombre().equalsIgnoreCase(nombreEmpresa)) {
                contactoEncontrado = actual.dato;
                break;
            }
            actual = actual.siguiente;
        } while (actual != contactos.miCabecera);

        if (contactoEncontrado == null) {
            System.out.println("No se encontro una empresa con el nombre especificado.");
            return;
        }

        Empresa empresa = (Empresa) contactoEncontrado;
        boolean continuarEdicion = true;

        while (continuarEdicion) {
            System.out.println("\nQue desea editar?");
            System.out.println("1. Nombre de la empresa");
            System.out.println("2. Direccion de la empresa");
            System.out.println("3. Telefonos de la empresa");
            System.out.println("4. Emails de la empresa");
            System.out.println("5. Información del director");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre de la empresa:");
                    String nuevoNombre = scanner.nextLine();
                    empresa.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese la nueva direccion de la empresa:");
                    String nuevaDireccion = scanner.nextLine();
                    empresa.setDireccionTrabajo(nuevaDireccion);
                    break;
                case 3:
                    HashMap<String, String> nuevosTelefonos = new HashMap<>();
                    System.out.println("Ingrese el tipo de telefono (Móvil, Oficina, etc.):");
                    String tipo = scanner.nextLine();
                    System.out.println("Ingrese el numero de telefono:");
                    String numero = scanner.nextLine();
                    nuevosTelefonos.put(tipo, numero);
                    empresa.editarTelefonosEmpresa(nuevosTelefonos);
                    break;
                case 4:
                    HashMap<String, String> nuevosEmails = new HashMap<>();
                    System.out.println("Ingrese el tipo de email (Ejecutivo, Personal, etc.):");
                    String tipoEmail = scanner.nextLine();
                    System.out.println("Ingrese el email:");
                    String email = scanner.nextLine();
                    nuevosEmails.put(tipoEmail, email);
                    empresa.editarEmailsEmpresa(nuevosEmails);
                    break;
                case 5:
                    if (empresa.getContactoDirector() != null) {
                        System.out.println("\nQue desea editar del director?");
                        System.out.println("1. Nombre del director");
                        System.out.println("2. Cargo del director");
                        System.out.println("3. Telefonos del director");
                        System.out.println("4. Emails del director");
                        System.out.println("5. Regresar");
                        System.out.print("Seleccione una opción: ");

                        int opcionDirector = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        switch (opcionDirector) {
                            case 1:
                                System.out.println("Ingrese el nuevo nombre del director:");
                                String nuevoNombreDirector = scanner.nextLine();
                                empresa.getContactoDirector().setNombre(nuevoNombreDirector);
                                break;
                            case 2:
                                if (empresa.getContactoDirector() instanceof Director) {
                                    System.out.println("Ingrese el nuevo cargo del director:");
                                    String nuevoCargo = scanner.nextLine();
                                    ((Director) empresa.getContactoDirector()).setCargo(nuevoCargo);
                                }
                                break;
                            case 3:
                                HashMap<String, String> nuevosTelefonosDirector = new HashMap<>();
                                System.out.println("Ingrese el tipo de teléfono del director (Personal, Ejecutivo, etc.):");
                                String tipoTelefonoDirector = scanner.nextLine();
                                System.out.println("Ingrese el número de teléfono:");
                                String numeroTelefonoDirector = scanner.nextLine();
                                nuevosTelefonosDirector.put(tipoTelefonoDirector, numeroTelefonoDirector);
                                empresa.editarTelefonosDirector(nuevosTelefonosDirector);
                                break;
                            case 4:
                                HashMap<String, String> nuevosEmailsDirector = new HashMap<>();
                                System.out.println("Ingrese el tipo de email del director (Personal, Ejecutivo, etc.):");
                                String tipoEmailDirector = scanner.nextLine();
                                System.out.println("Ingrese el email:");
                                String emailDirector = scanner.nextLine();
                                nuevosEmailsDirector.put(tipoEmailDirector, emailDirector);
                                empresa.editarEmailsDirector(nuevosEmailsDirector);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                        }
                    } else {
                        System.out.println("No se ha asignado un director a esta empresa.");
                    }
                    break;
                case 6:
                    continuarEdicion = false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
    
    public void editarContactosAsociadosDePersona(Persona persona) {
    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;

    while (continuar) {
        System.out.println("\nQue desea hacer con los contactos asociados?");
        persona.mostrarContactosAsociados(); // Muestra los contactos asociados
        System.out.println("1. Eliminar un contacto asociado");
        System.out.println("2. Editar un contacto asociado");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (opcion) {
            case 1:
                // Eliminar un contacto asociado
                System.out.println("Ingrese el nombre del contacto asociado que desea eliminar:");
                String nombreEliminar = scanner.nextLine();
                NodoCircularDoble<Contacto> actual = persona.getContactosRelacionados().miCabecera;
                boolean encontrado = false;
                do {
                    if (actual.dato.getNombre().equalsIgnoreCase(nombreEliminar)) {
                        persona.getContactosRelacionados().eliminar(actual.dato); // Eliminar el contacto asociado
                        System.out.println("Contacto eliminado.");
                        encontrado = true;
                        break;
                    }
                    actual = actual.siguiente;
                } while (actual != persona.getContactosRelacionados().miCabecera);

                if (!encontrado) {
                    System.out.println("No se encontro un contacto asociado con ese nombre.");
                }
                break;
            case 2:
                // Editar un contacto asociado
                System.out.println("Ingrese el nombre del contacto asociado que desea editar:");
                String nombreEditar = scanner.nextLine();
                NodoCircularDoble<Contacto> actualEditar = persona.getContactosRelacionados().miCabecera;
                boolean encontradoEditar = false;
                do {
                    if (actualEditar.dato.getNombre().equalsIgnoreCase(nombreEditar)) {
                        persona.editarContactosAsociadosDePersona((Persona) actualEditar.dato); 
                        System.out.println("Contacto asociado editado.");
                        encontradoEditar = true;
                        break;
                    }
                    actualEditar = actualEditar.siguiente;
                } while (actualEditar != persona.getContactosRelacionados().miCabecera);

                if (!encontradoEditar) {
                    System.out.println("No se encontro un contacto asociado con ese nombre.");
                }
                break;
            case 3:
                continuar = false;
                break;
            default:
                System.out.println("Opcion no valida.");
            }
        }   
    }
    
    //metodo para crear contactos asociados
    
    public Contacto crearContactoPersonaRelacionado() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la persona relacionada:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd):");
        Date fechaNacimiento;
        try {
            fechaNacimiento = java.sql.Date.valueOf(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Formato de fecha invalido. Intente de nuevo.");
            return null;
        }

        // Crear la instancia de Contacto
        Persona persona = new Persona(nombre, fechaNacimiento);

        // Agregar numeros de telefono
        System.out.println("Desea agregar numeros de telefono (s/n):");
        String respuesta = sc.nextLine();
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el tipo de telefono (Ej: movil, casa, trabajo):");
            String tipo = sc.nextLine();
            System.out.println("Ingrese el numero de telefono:");
            String numero = sc.nextLine();
            persona.getTelef().put(tipo, numero);

            System.out.println("Desea agregar otro numero de telefono (s/n):");
            respuesta = sc.nextLine();
        }

        // Agregar correos electronicos
        System.out.println("Desea agregar correos electronicos (s/n):");
        respuesta = sc.nextLine();
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el tipo de correo (Ej: personal, trabajo):");
            String tipo = sc.nextLine();
            System.out.println("Ingrese el correo:");
            String correo = sc.nextLine();
            persona.getEmails().put(tipo, correo);

            System.out.println("Desea agregar otro correo (s/n):");
            respuesta = sc.nextLine();
        }

        // Agregar redes sociales
        System.out.println("Desea agregar redes sociales (s/n):");
        respuesta = sc.nextLine();
        while (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese la plataforma (Ej: Instagram):");
            String plataforma = sc.nextLine();
            System.out.println("Ingrese el usuario:");
            String usuario = sc.nextLine();
            persona.agregarRedSocial(plataforma, usuario);

            System.out.println("Desea agregar otra red social (s/n):");
            respuesta = sc.nextLine();
        }

        System.out.println("Desea agregar fotos? (s/n):");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            do {
                System.out.println("Ruta de la foto:");
                String foto = sc.nextLine();
                persona.agregarFoto(foto);
                System.out.println("Desea agregar otra foto? (s/n):");
            } while (sc.nextLine().equalsIgnoreCase("s"));
        }
        
        return (Contacto) persona;
        
    }
    
}
