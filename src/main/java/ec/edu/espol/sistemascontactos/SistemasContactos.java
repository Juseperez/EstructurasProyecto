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
        int ordenarPor;

        while (true) {
            System.out.println("--------------------- Bienvenido al sistema de gestión de contactos -----------------------");
            System.out.println("1. Agregar Persona");
            System.out.println("2. Agregar Empresa");
            System.out.println("3. Mostrar Contactos Adelante");
            System.out.println("4. Mostrar Contactos Atras");
            System.out.println("5. Ordenar Lista");
            System.out.println("6. Filtrar y mostrar lista");
            System.out.println("7. Editar los datos de la Persona");
            System.out.println("8. Editar los datos de la Empresa");
            System.out.println("9. Eliminar Contacto");
            System.out.println("10. Guardar Contactos");
            System.out.println("11. Salir");
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
                    System.out.println("1. Ordenar por nombre");
                    System.out.println("2. Ordenar por Direccion de Trabajo");
                    System.out.println("3. Ordenar por fecha de nacimiento");
                    System.out.print("Seleccione una opcion:");
                    ordenarPor = scanner.nextInt();
                    switch(ordenarPor){
                        case 1:
                            gestor.ordenarContactos(new ComparadorPorNombre());
                            System.out.println("Lista ordenada:");
                            gestor.mostrar();
                            break;
                        case 2:
                            gestor.ordenarContactos(new ComparadorPorDireccionTrabajo());
                            System.out.println("Lista ordenada:");
                            gestor.mostrar();
                            break;
                        case 3:
                            gestor.ordenarContactos(new ComparadorPorCumple());
                            System.out.println("Lista ordenada:");
                            gestor.mostrar();
                            break;
                        default:
                            System.out.println("Opción no encontrada");
                    }
                    System.out.println("---------------------------------------------------------");
                    break;
                case 6:
                    CustomListaCircularEnlazadaDoble<Contacto> filtrado;
                    System.out.println("1. Filtrar por nombre");
                    System.out.println("2. Filtrar por Direccion de Trabajo");
                    System.out.println("3. Filtrar por mes de fecha de nacimiento");
                    System.out.println("4. Filtrar por nombre y mes de nacimiento");
                    System.out.print("Seleccione una opcion:");
                    ordenarPor = scanner.nextInt();
                    switch(ordenarPor){
                        case 1:
                            System.out.print("Ingresar nombre que quiere filtrar: ");
                            String nombre=scanner.next();
                            filtrado=gestor.filtrarPorNombre(nombre);
                            System.out.println("Lista filtrada:");
                            filtrado.mostrarContactos();
                            break;
                        case 2:
                            System.out.print("Ingresar dirección que quiere filtrar: ");
                            String direccion=scanner.next();
                            filtrado=gestor.filtrarPorDireccion(direccion);
                            System.out.println("Lista filtrada:");
                            filtrado.mostrarContactos();
                            break;
                        case 3:
                            System.out.print("Ingresar mes que quiere filtrar(1 a 12): ");
                            int mes=scanner.nextInt()-1;
                            filtrado=gestor.filtrarPorMes(mes);
                            System.out.println("Lista filtrada:");
                            filtrado.mostrarContactos();
                            break;
                        case 4:
                            System.out.print("Ingresar nombre que quiere filtrar: ");
                            String nombre1=scanner.next();
                            System.out.print("Ingresar mes que quiere filtrar(1 a 12): ");
                            int mes1=scanner.nextInt()-1;
                            filtrado=gestor.busquedaAvanzada(nombre1,mes1);
                            System.out.println("Lista filtrada:");
                            filtrado.mostrarContactos();
                            break;
                        default:
                            System.out.println("Opción no encontrada");
                    }
                    System.out.println("---------------------------------------------------------");
                    break;
                case 7:
                    gestor.editarDatosPersona();
                    
                    break;
                case 8:
                    gestor.editarDatosEmpresa();
                    
                    break;  
                case 9:
                    gestor.eliminarContacto();
                    
                    break;
                case 10:
                    gestor.guardarContactos("contactos.txt");
                   
                    break;
                case 11:
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