/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.sistemascontactos;

/**
 *
 * @author erick
 */
public class CustomListaCircularEnlazadaDoble<E> {
    
    private NodoCircularDoble<E> miCabecera;
    private int tamanio;
    
    public CustomListaCircularEnlazadaDoble(){
        
        this.miCabecera = null;
        this.tamanio = 0;
        
    }
    
    
    public void addLast(E elemento){
        
        NodoCircularDoble<E> nuevoNodo = new NodoCircularDoble(elemento);
        
        if(miCabecera == null){
            
            miCabecera = nuevoNodo;
            miCabecera.siguiente = miCabecera;
            miCabecera.anterior = miCabecera;
        }else{
            NodoCircularDoble<E> ultimoNodo = miCabecera.anterior;
            
            ultimoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimoNodo;
            nuevoNodo.siguiente = miCabecera;
            miCabecera.anterior = nuevoNodo;
        }
        tamanio++;
        
    }
    
    
}
