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
public class Lista {
    
    private Nodo inicio;
    
    public int comparar(Lista l) {
        int t = this.tamano();
        int t2 = l.tamano();
        if(t < t2) {
            return -1;            
        } else if(t > t2) {
            return 1;
        } else {
            Nodo aux = this.getInicio();
            Nodo aux2 = l.getInicio();
            while(aux != null && aux.getNumero() != aux2.getNumero()) {
                aux = aux.getSiguiente();
                aux2 = aux2.getSiguiente();
            }
            if(aux == null) {
                return 0;
            } else {
                return aux.getNumero() - aux2.getNumero();
            }
        }        
    }
    
    public Resul dividir(Lista l){        
        Lista dividendo = this.invertir();        
        Lista divisor = l.invertir();
        Resul resul = new Resul();    
        
        Nodo aux = dividendo.getInicio();
        Nodo aux2 = divisor.getInicio();
        boolean f = true;
        int t = divisor.tamano();
        int a;
        int b;
        int c;
        Lista r;        
        while(f) {
            Lista subDiv = new Lista();
            b = divisor.getInicio().getNumero();
            if (aux.getNumero() < b) {
                a = aux.getNumero()*10+aux.getSiguiente().getNumero();
                Nodo n = new Nodo(aux.getNumero());
                subDiv.agregarAdelante(n);
                aux = aux.getSiguiente();
            }
            else
                a = aux.getNumero();
            Nodo auxi = aux;
            for (int i = 0; i < t; i++) {
                subDiv.agregarAdelante(new Nodo(auxi.getNumero()));
                auxi = auxi.getSiguiente();
            }
//    System.out.println("subDiv: "+subDiv);
            c = a / b;
//    System.out.println("c: "+c);
            resul.getCociente().agregarAdelante(new Nodo(c));
            
            r = calculaR(divisor, c, subDiv);
       
//    System.out.println("r: "+r);
//    System.out.println(auxi);
        
            if(auxi == null) {
                resul.setResiduo(r);
                f = false;
            }
            while(auxi!= null) {
                Nodo n = new Nodo(auxi.getNumero());
                r.agregarAdelante(n);
                auxi = auxi.getSiguiente();
            }
            aux = r.getInicio();
        }
        return resul;
    }    
    
    private Lista calculaR(Lista divisor,int c,Lista subDiv) {
        divisor = divisor.invertir();
        subDiv = subDiv.invertir();
//    System.out.println("Multiplicar: "+divisor+" * "+c);
        Lista r = divisor.multiplicar(new Lista(new Nodo(c)));    
//    System.out.println("Paso 1->"+r);
        r = r.invertir();
//    System.out.println("Invertir->"+r);
//    System.out.println(subDiv+" restar "+r);
        r = subDiv.restar(r);
//    System.out.println("Restar>>"+r);
        return r;
    }
    
    public Lista multiplicar(Lista l) {
        Lista multi = new Lista();
        Lista producto;
        Nodo aux = l.getInicio();    
        int i = 0;
        while(aux!=null) {
            producto = multiplicar(aux.getNumero(),i);
            if(multi.getInicio()!=null) {
                if(producto.tamano()<multi.tamano()){
                    multi = multi.sumar(producto);
                } else {
                    multi = producto.sumar(multi);
                }
            } else {
                multi = producto;
            }
            aux = aux.getSiguiente();
            i++;            
        }        
        if(l.getInicio().getSiguiente()==null)
            multi = multi.invertir();
        return multi;
    }
    
    private Lista multiplicar(int b, int i) {
        Lista p = new Lista();
        Nodo aux = this.getInicio();    
        Nodo aux2;
        for (int j = 0; j < i; j++) {
            aux2 = new Nodo(0);            
            p.agregarAdelante(aux2);
        }
        int a;
        int c;
        int r = 0;
        while(aux!= null){
            a = aux.getNumero();
            c = a * b + r;
            if (c > 9) {
                r = c / 10;
                c = c % 10;
            } else {
                r = 0;
            }
            aux2 = new Nodo(c);
            p.agregarAdelante(aux2);
            if(aux.getSiguiente()==null && r!=0){
                aux2 = new Nodo(r);
                p.agregarAdelante(aux2);
            }
            aux = aux.getSiguiente();            
        }
        return p;
    }
    
    public Lista restar(Lista l) {
        Lista resta = new Lista();
        Nodo n;
        Nodo aux = inicio;        
        Nodo aux2 = l.getInicio();
        int a;                
        int b;
        int c;
        while (aux != null) {
            a = aux.getNumero();
            if(aux2 != null)
                b = aux2.getNumero();                
            else 
                b = 0;
            c = a - b;
            if (c < 0) {
                c = c + 10;
                Nodo aux4 = aux.getSiguiente();
                while(aux4.getNumero()==0) {
                    aux4.setNumero(9);
                    aux4 = aux4.getSiguiente();
                }
                aux4.disminuye();
            }       
            n = new Nodo(c);
            resta.agregarAtras(n);
            aux = aux.getSiguiente();
            if(aux2 != null) {
                aux2 = aux2.getSiguiente();
            }
        }
        if(resta.getInicio().getNumero()==0) {
            resta.quitarC();
        }
        return resta;
    }
    
    public Lista sumar(Lista l) {
        Lista suma = new Lista();
        Nodo n;
        Nodo aux = inicio;        
        Nodo aux2 = l.getInicio();
        int a;                
        int b;
        int c;
        while (aux != null) {
            a = aux.getNumero();
            if(aux2 != null)
                b = aux2.getNumero();                
            else 
                b = 0;
            c = a + b;
            if (c >= 10) {
                c = c -10;
                if (aux.getSiguiente() != null) {
                    aux.getSiguiente().setNumero(aux.getSiguiente().getNumero() + 1);                                
                } else {
                    n = new Nodo(1);
                    aux.setSiguiente(n);
                }                
            }       
            n = new Nodo(c);
            suma.agregarAtras(n);
            aux = aux.getSiguiente();
            if(aux2 != null) {
                aux2 = aux2.getSiguiente();
            }
        }
        return suma;
    }
    
    public void agregarAdelante(Nodo n) {
        Nodo aux = inicio;
        Nodo ant = null;
        if(aux == null)
            inicio = n;
        else {
            while(aux!=null){
                ant = aux;
                aux = aux.getSiguiente();
            }
            ant.setSiguiente(n);
        }
    }
    
    public void agregarAtras(Nodo n) {
        if(inicio == null)
            inicio = n;
        else {
            inicio.setAnterior(n);
            n.setSiguiente(inicio);
            inicio = n;
        }
    }
    
    public void quitarC() {
        Nodo aux = inicio;
        while(aux!=null && aux.getNumero() == 0) {
            Nodo sig = aux.getSiguiente();
            if(sig!= null) {
                inicio = sig;
                sig.setAnterior(null);
                aux.setSiguiente(null);
            }
            aux = null;
            aux = sig;
        }
    }
    
    public Lista clonar() {
        Lista l = new Lista();
        Nodo aux = inicio;
        while(aux!=null) {
            Nodo n = new Nodo(aux.getNumero());
            l.agregarAdelante(n);
            aux = aux.getSiguiente();
        }
        return l;
    }
    
    public Lista invertir() {        
        Nodo aux = inicio;
        Lista l = new Lista();
        while(aux!=null){
            Nodo n = new Nodo(aux.getNumero());
            l.agregarAtras(n);
            aux = aux.getSiguiente();
        }
        return l;
    }
    
    public int tamano() {
        Nodo aux = inicio;
        int i = 0;
        while(aux!=null) {
            i++;
            aux = aux.getSiguiente();
        }
        return i;
    }

    @Override
    public String toString() {
        Nodo aux = inicio;
        String s = new String();
        while(aux != null) {
            s += aux.getNumero() + " ";
            aux = aux.getSiguiente();
        }
        return s;
    }
    
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }
    
    public Lista() {
    }        

    public Lista(Nodo inicio) {
        this.inicio = inicio;
    }    
    
}
