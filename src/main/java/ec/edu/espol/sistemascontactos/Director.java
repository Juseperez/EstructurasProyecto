/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

/**
 *
 * @author ricky
 */
import java.util.HashMap;

public class Director extends Persona {
    private String cargo; // Cargo específico del director (Ejemplo: "Gerente General")

    // Constructor con solo nombre
    public Director(String nombre) {
        super(nombre); // Heredado de Persona
    }

    // Constructor completo
    public Director(String nombre, String cargo, 
                    HashMap<String, String> telefonos, HashMap<String, String> emails) {
        super(nombre); // Inicializa desde la clase Persona
        this.cargo = cargo;
        this.getTelef().putAll(telefonos);
        this.getEmails().putAll(emails);
    }

    // Getter y Setter para el cargo
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método para mostrar informacion del director
    @Override
    public void mostrarInformacion() {
       System.out.println("Nombre: " + this.getNombre());
       System.out.println("Cargo: " + (this.cargo != null ? this.cargo : "No especificado"));

    // Mostrar teléfonos
         if (!this.getTelef().isEmpty()) {
            System.out.println("Telefonos:");
            for (String tipo : this.getTelef().keySet()) {
                System.out.println("  " + tipo + ": " + this.getTelef().get(tipo));
        }
        } else {
        System.out.println("No hay telefonos registrados.");
    }

    // Mostrar emails
        if (!this.getEmails().isEmpty()) {
             System.out.println("Emails:");
        for (String tipo : this.getEmails().keySet()) {
            System.out.println("  " + tipo + ": " + this.getEmails().get(tipo));
            }
        } else {
        System.out.println("No hay emails registrados.");
        }
    }
}
