/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author j4v13
 */
public class Nodo {
    
    private int numero;
    private Nodo anterior;
    private Nodo siguiente;
    
    public void disminuye() {
        numero--;
    }

    @Override
    public String toString() {
        return "Nodo{" + "numero=" + numero + '}';
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }        

    public Nodo(int numero) {
        this.numero = numero;
    }        

    public Nodo() {
    }        
    
}
