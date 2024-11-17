/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.util.Scanner;
import java.util.HashMap;
/**
 *
 */
public class Agenda {
    Scanner scanner = new Scanner(System.in);
    private CustomListaCircularEnlazadaDoble<Contacto> contactos;

    
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
            System.out.println("Ingresar el número de teléfono: ");
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
    

}
