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
public class NodoCircularDoble<E> {
    
    public E dato;
    public NodoCircularDoble<E> siguiente;
    public NodoCircularDoble<E> anterior;
    
    public NodoCircularDoble(E dato){
        
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
        
    }
    
}
