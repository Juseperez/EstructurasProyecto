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
        String tipo_tel;
        String num_tel;
        System.out.println("1. Agregar una persona");
        System.out.println("2. Agregar una empresa");
        System.out.println("Intgrese su opción:");
        int opcion = scanner.nextInt();
        if(opcion==1){
            System.out.println("Ingresar nombre: ");
            nombre = scanner.nextLine();
            System.out.println("Ingresar el número de teléfono: ");
            num_tel = scanner.nextLine();
            System.out.println("¿Qué tipo de telefono es? (De trabajo, casa...): ");
            tipo_tel = scanner.nextLine();
            telef.put(tipo_tel, num_tel);
            
            
        }else if (opcion ==2){
            
        }
        //Contacto contacto
        //contactos.addLast(contacto);
        //System.out.println("Contacto agregado: " + contacto);
    }
    

}
