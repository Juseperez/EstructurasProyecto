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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar Persona");
            System.out.println("2. Agregar Empresa");
            System.out.println("3. Mostrar Contactos Adelante");
            System.out.println("4. Mostrar Contactos Atras");
            System.out.println("5. Eliminar Contacto");
            System.out.println("6. Guardar Contactos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

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
                    gestor.eliminarContacto();
                    break;
                case 6:
                    gestor.guardarContactos("contactos.txt");
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    gestor.guardarContactos("contactos.txt");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}