/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

/**
 *
 * @author erick
 * @param <E>
 */
public class CustomListaCircularEnlazadaDoble<E> {
    
    private NodoCircularDoble<Contacto> miCabecera;
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
    public boolean eliminar(E contacto) {
        if (miCabecera == null) {
            System.out.println("La lista está vacía. No se puede eliminar.");
            return false;
        }

        NodoCircularDoble<Contacto> actual = miCabecera;

        // Recorremos la lista buscando el nodo con el contacto
        do {
            if (actual.dato.equals(contacto)) {
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
                System.out.println("Contacto eliminado: " + contacto);
                return true;
            }
            actual = actual.siguiente;
        } while (actual != miCabecera);

        System.out.println("Contacto no encontrado: " + contacto);
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
    
    public Contacto mostrarPosicionContactoActual(){
        
        if(nodoNavegacion != null){
            return nodoNavegacion.dato;
        }
        return null;
    }
    
    public void mostrarContactos(){
        if (miCabecera == null) {
            System.out.println("La lista está vacía");
            return;
        }
        NodoCircularDoble<Contacto> actual = miCabecera;
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != miCabecera);
        System.out.println("(cabeza)");
    }

}

    

