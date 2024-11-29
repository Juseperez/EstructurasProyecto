/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.sistemascontactos;

import java.util.Scanner;

/**
 *
 */
public class SistemasContactos{
    public static void main(String[] args) {
        Agenda gestor = new Agenda();
        gestor.cargarContactos("contactos.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------- Bienvenido al sistema de gestión de contactos -----------------------");
            System.out.println("1. Agregar Persona");
            System.out.println("2. Agregar Empresa");
            System.out.println("3. Mostrar Contactos Adelante");
            System.out.println("4. Mostrar Contactos Atras");
            System.out.println("5. Editar los datos de la Persona");
            System.out.println("6. Editar los datos de la Empresa");
            System.out.println("7. Eliminar Contacto");
            System.out.println("8. Guardar Contactos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion:");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println("---------------------------------------------------------");
            
            switch (opcion) {
                case 1:
                    gestor.crearContactoPersona();
                   
                    break;
                case 2:
                    gestor.añadirContactoEmpresa();
                    
                    break;
                case 3:
                    gestor.mostrarContactosAdelante();
                   
                    break;
                case 4:
                    gestor.mostrarContactosAtras();
                    
                    break;
                case 5:
                    gestor.editarDatosPersona();
                    
                    break;
                case 6:
                    gestor.editarDatosEmpresa();
                    
                    break;  
                case 7:
                    gestor.eliminarContacto();
                    
                    break;
                case 8:
                    gestor.guardarContactos("contactos.txt");
                   
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    gestor.guardarContactos("contactos.txt");
                    System.out.println("\n");
                    return;
                default:
                    System.out.println("Opción invalida.");
            }
        }
    }
}