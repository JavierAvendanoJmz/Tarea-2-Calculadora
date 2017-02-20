/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author j4v13
 */
public class Controlador {
    
    public Lista sumar(Lista l, Lista l2) {
        return l.sumar(l2);
    }
    
    public Lista restar(Lista l, Lista l2) {
        return l.restar(l2);
    }
    
    public Lista multiplicar(Lista l, Lista l2) {
        return l.multiplicar(l2);
    }
    
    public Resul dividir(Lista l, Lista l2) {
        return l.dividir(l2);
    }
    
    public void guardar(File file, Lista l,Lista l2, Lista l3, Lista l4, Lista l5) throws IOException {
        FileWriter fw = new FileWriter (file);
        BufferedWriter bw = new BufferedWriter(fw);
        Nodo aux;
        aux = l.getInicio();        
        while(aux!=null) {            
            bw.write(aux.getNumero()+48);
            aux = aux.getSiguiente();
        }
        bw.write(13);
        bw.write(10);
        aux = l2.getInicio();        
        while(aux!=null) {            
            bw.write(aux.getNumero()+48);
            aux = aux.getSiguiente();
        }
        bw.write(13);
        bw.write(10);
        aux = l3.getInicio();        
        while(aux!=null) {            
            bw.write(aux.getNumero()+48);
            aux = aux.getSiguiente();
        }
        bw.write(13);
        bw.write(10);
        aux = l4.getInicio();        
        while(aux!=null) {            
            bw.write(aux.getNumero()+48);
            aux = aux.getSiguiente();
        }
        bw.write(13);
        bw.write(10);
        aux = l5.getInicio();        
        while(aux!=null) {            
            bw.write(aux.getNumero()+48);
            aux = aux.getSiguiente();
        }
        bw.close();
    }
    
    public void abrir(File file,Lista l, Lista l2) throws FileNotFoundException, IOException, Exception {
        FileReader fr = new FileReader (file);
        BufferedReader br = new BufferedReader(fr);
        int  aux =  br.read();
        while(aux!=13) {        
            Nodo n = new Nodo();
            if(aux-48<0 || aux-48>9)
                throw new Exception();
            n.setNumero(aux-48);
            l.agregarAtras(n);
            aux = br.read();
        }
        br.read();
        aux = br.read();
        while(aux!=-1 && aux!=13 & aux!=10) {
            Nodo n = new Nodo();
            if(aux-48<0 || aux-48>9)
                throw new Exception();
            n.setNumero(aux-48);
            l2.agregarAtras(n);
            aux = br.read();
        }
        br.close();
    }
    
}
