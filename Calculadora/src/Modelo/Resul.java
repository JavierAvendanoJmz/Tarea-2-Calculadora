/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Lista;

/**
 *
 * @author j4v13
 */
public class Resul {
    private Lista cociente;
    private Lista residuo;

    public Lista getCociente() {
        return cociente;
    }

    public void setCociente(Lista cociente) {
        this.cociente = cociente;
    }

    public Lista getResiduo() {
        return residuo;
    }

    public void setResiduo(Lista residuo) {
        this.residuo = residuo;
    }

    public Resul() {
        this.cociente = new Lista();
        this.residuo = new Lista();
    }

    public Resul(Lista cociente, Lista residuo) {
        this.cociente = cociente;
        this.residuo = residuo;
    }
        
}
