/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;

/**
 *
 * @author erick
 * @param <E>
 */
public class CustomListaCircularEnlazadaDoble<E> implements Serializable{
    
    public NodoCircularDoble<Contacto> miCabecera;
    private NodoCircularDoble<Contacto> nodoNavegacion;
    private int tamanio;
    
    public CustomListaCircularEnlazadaDoble(){
        
        this.miCabecera = null;
        this.nodoNavegacion = null;
        this.tamanio = 0;
        
    }
    
    //Metodo para agregar un contacto
    public void addLast(Contacto contacto){
        
        NodoCircularDoble<Contacto> nuevoNodo = new NodoCircularDoble(contacto);
        
        if(miCabecera == null){
            
            miCabecera = nuevoNodo;
            miCabecera.siguiente = miCabecera;
            miCabecera.anterior = miCabecera;
            nodoNavegacion = miCabecera;
        }else{
            NodoCircularDoble<Contacto> ultimoNodo = miCabecera.anterior;
            
            ultimoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimoNodo;
            nuevoNodo.siguiente = miCabecera;
            miCabecera.anterior = nuevoNodo;
            
        }
        tamanio++;
        
    }

   // Método para eliminar un contacto específico
    public boolean eliminar(Contacto contacto) {
        if (miCabecera == null) {
            System.out.println("La lista esta vacia. No se puede eliminar.");
            return false;
        }

        NodoCircularDoble<Contacto> actual = miCabecera;

        // Recorremos la lista buscando el nodo con el contacto
        do {
            if (actual.dato.equals(contacto)) { // Comparamos por igualdad
                if (actual == miCabecera && tamanio == 1) {
                    // Si solo hay un elemento en la lista
                    miCabecera = null;
                    nodoNavegacion = null;
                } else {
                    // Ajustamos los enlaces para eliminar el nodo
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;

                    // Si el nodo a eliminar es la cabeza, ajustamos miCabecera
                    if (actual == miCabecera) {
                        miCabecera = actual.siguiente;
                    }

                    // Si el nodo a eliminar es el nodoNavegacion, lo actualizamos
                    if (actual == nodoNavegacion) {
                        nodoNavegacion = actual.siguiente;
                    }
                }
                tamanio--;
                System.out.println("Contacto eliminado: " + contacto.getNombre());
                return true;
            }
            actual = actual.siguiente; // Avanzamos al siguiente nodo
        } while (actual != miCabecera);

        System.out.println("Contacto no encontrado.");
        return false;
    } 
    // Metodos para poder navegar por la lista
    
    public void avanzar(){
        if(nodoNavegacion != null){
            nodoNavegacion = nodoNavegacion.siguiente;
        }else{
            System.out.println("La lista no tiene elementos");
        }
    }
    
    public void anterior(){
        if(nodoNavegacion!= null){
            nodoNavegacion = nodoNavegacion.anterior;
        }else{
            System.out.println("La lista no tiene elementos");
        }
        
    }
    
    public Contacto mostrarPosicionContactoActual() {
        if (nodoNavegacion != null) {
            return nodoNavegacion.dato;
        } else {
            return null; // Lista vacía o nodoNavegacion no inicializado
        }
    }
    
    public void mostrarContactos(){
        if (miCabecera == null) {
            System.out.println("La lista esta vacia");
            return;
        }
        NodoCircularDoble<Contacto> actual = miCabecera;
        do {
            actual.dato.mostrarInformacion();
            actual = actual.siguiente;
        } while (actual != miCabecera);
        System.out.println("cabeza");
    }

    public NodoCircularDoble<Contacto> getMiCabecera() {
        return miCabecera;
    }

    public int size(){
        return tamanio;
    }
    public void ordenar(Comparator<Contacto> comparador) {
        if (miCabecera == null || miCabecera.siguiente == miCabecera) {
            // La lista está vacía o tiene solo un elemento
            return;
        }

        boolean intercambiar;
        do {
            intercambiar = false;
            NodoCircularDoble<Contacto> actual = miCabecera;
            do {
                NodoCircularDoble<Contacto> siguiente = actual.siguiente;
                if (comparador.compare(actual.dato, siguiente.dato) > 0) {
                    Contacto temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    intercambiar = true;
                }
                actual = siguiente;
            } while (actual.siguiente != miCabecera); // Recorrer hasta el último nodo
        } while (intercambiar);
    }
    
    public CustomListaCircularEnlazadaDoble<E> filtrarNombre(String nombre){
        CustomListaCircularEnlazadaDoble<E> filtrar=new CustomListaCircularEnlazadaDoble<>();
        if(miCabecera==null){
            return filtrar;
        }
        NodoCircularDoble<Contacto> actual=miCabecera;
        do{
            if(actual.dato.getNombre().equalsIgnoreCase(nombre))
                filtrar.addLast(actual.dato);
            actual=actual.siguiente;
        }while(actual != miCabecera);
        return filtrar;
    }
    
    public CustomListaCircularEnlazadaDoble<E> filtrarDireccion(String direccion){
        CustomListaCircularEnlazadaDoble<E> filtrar=new CustomListaCircularEnlazadaDoble<>();
        if(miCabecera==null){
            return filtrar;
        }
        NodoCircularDoble<Contacto> actual=miCabecera;
        do{
            boolean esEmpresa = actual.dato instanceof Empresa;
            if(esEmpresa){
                Empresa empresa = (Empresa) actual.dato;
                if(empresa.getDireccionTrabajo().equalsIgnoreCase(direccion))
                    filtrar.addLast(actual.dato);
            }
            actual=actual.siguiente;
            }while(actual != miCabecera);
        return filtrar;
    }
    
    public CustomListaCircularEnlazadaDoble<E> filtrarCumple(int mes){
        CustomListaCircularEnlazadaDoble<E> filtrar=new CustomListaCircularEnlazadaDoble<>();
        if(miCabecera==null){
            return filtrar;
        }
        NodoCircularDoble<Contacto> actual=miCabecera;
        do{
            boolean esPersona = actual.dato instanceof Persona;
            if(esPersona){
                Persona persona = (Persona) actual.dato;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(persona.getFechaNacimiento());
                int mesNacimiento = calendar.get(Calendar.MONTH);
                if(mesNacimiento == mes)
                    filtrar.addLast(actual.dato);
            }
            actual=actual.siguiente;
            }while(actual != miCabecera);
        return filtrar;
    }
    
    public CustomListaCircularEnlazadaDoble<E> filtroDoble(String nombre, int mes){
        CustomListaCircularEnlazadaDoble<E> filtrar=new CustomListaCircularEnlazadaDoble<>();
        if(miCabecera==null){
            return filtrar;
        }
        NodoCircularDoble<Contacto> actual=miCabecera;
        do{
            boolean esPersona = actual.dato instanceof Persona;
            if(esPersona){
                Persona persona = (Persona) actual.dato;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(persona.getFechaNacimiento());
                int mesNacimiento = calendar.get(Calendar.MONTH);
                if(mesNacimiento == mes && actual.dato.getNombre().equalsIgnoreCase(nombre))
                    filtrar.addLast(actual.dato);
            }
            actual=actual.siguiente;
            }while(actual != miCabecera);
        return filtrar;
    }

}


