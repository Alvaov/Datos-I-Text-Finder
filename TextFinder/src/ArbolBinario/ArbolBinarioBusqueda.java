/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;
/**
 * 
 * @author Brayan
 * @param <T> clase del arbol
 */
public class ArbolBinarioBusqueda<T> {
    Nodo raiz;
    public ArbolBinarioBusqueda(){
        raiz = null;
    }
    /**
     * retorna el valor minimo del arbol
     * @return valor minimo del arbol
     */
    public T findMin(){
        Nodo<T> temp = raiz;
        while(temp!=null){
            temp = temp.getNodoIzquierdo();
        }
        return temp.getValor();
    }
    /**
     * retorna el valor maximo del arbol
     * @return valor maximo de arbol
     */
    public T findMax(){
        Nodo<T> temp = raiz;
        while(temp!=null){
            temp = temp.getNodoDerecho();
        }
        return temp.getValor();
    }
    
    public void añadirElemento(T elemento){
        
        if(raiz == null){
            raiz = new Nodo(elemento);
            return;
        }
        
        Nodo actual = raiz;
        
        Nodo nodo = new Nodo(elemento);
        
        byte[] nuevoNodoBytes = nodo.getValor().toString().getBytes();
        byte[] actualNodoBytes = actual.getValor().toString().getBytes();
        
        int i = 0;
        
        while(true){
            if(nuevoNodoBytes[i] > actualNodoBytes[i]){
                
                if(actual.getNodoDerecho() != null){
                    actual = actual.getNodoDerecho();
                    actualNodoBytes = actual.getValor().toString().getBytes();
                    i = 0;
                }else{
                    actual.setNodoDerecho(nodo);
                    System.out.println("derecha");
                    return;
                }
            }else if(nuevoNodoBytes[i] < actualNodoBytes[i]){
                if(actual.getNodoIzquierdo() != null){
                    actual = actual.getNodoIzquierdo();
                    actualNodoBytes = actual.getValor().toString().getBytes();
                    i = 0;
                }else{
                    actual.setNodoIzquierdo(nodo);
                    System.out.println("izquierda");
                    return;
                }
            }else{
                i++;
                if(i == actualNodoBytes.length && i == nuevoNodoBytes.length){
                    System.out.println("iguales");
                    actual.addReferencias(nodo);
                    return;
                        
                }else if(i+1 > actualNodoBytes.length){
                    if(actual.getNodoDerecho() != null){
                        actual = actual.getNodoDerecho();
                        actualNodoBytes = actual.getValor().toString().getBytes();
                        i = 0;
                    }else{
                        actual.setNodoDerecho(nodo);
                        System.out.println("Derecha impura");
                        return;
                    }
                        
                }else if(i+1 > nuevoNodoBytes.length){
                    if(actual.getNodoIzquierdo() != null){
                        actual = actual.getNodoIzquierdo();
                        actualNodoBytes = actual.getValor().toString().getBytes();
                        i = 0;
                    }else{
                        System.out.println("Izquierda impura");
                        actual.setNodoIzquierdo(nodo);
                        return;
                    }
                }
            }
        }
    }
    
    public Object retornarElemento(T elemento){
        
        if(raiz == null){
            return -1;
        }
        
        Nodo actual = raiz;
        
        Nodo nodo = new Nodo(elemento);
        
        byte[] nuevoNodoBytes = nodo.getValor().toString().getBytes();
        byte[] actualNodoBytes = actual.getValor().toString().getBytes();
        
        int i = 0;
        
        while(true){
            if(nuevoNodoBytes[i] > actualNodoBytes[i]){
                
                if(actual.getNodoDerecho() != null){
                    actual = actual.getNodoDerecho();
                    actualNodoBytes = actual.getValor().toString().getBytes();
                    i = 0;
                }else{
                    System.out.println("no retorna");
                    return -1;
                }
            }else if(nuevoNodoBytes[i] < actualNodoBytes[i]){
                if(actual.getNodoIzquierdo() != null){
                    actual = actual.getNodoIzquierdo();
                    actualNodoBytes = actual.getValor().toString().getBytes();
                    i = 0;
                }else{
                    System.out.println("no retorna");
                    return -1;
                }
            }else{
                i++;
                if(i == actualNodoBytes.length && i == nuevoNodoBytes.length){
                    System.out.println("retorna");
                    return actual;
                        
                }else if(i+1 > actualNodoBytes.length){
                    if(actual.getNodoDerecho() != null){
                        actual = actual.getNodoDerecho();
                        actualNodoBytes = actual.getValor().toString().getBytes();
                        i = 0;
                    }else{
                        System.out.println("no retorna");
                        return -1;
                    }
                        
                }else if(i+1 > nuevoNodoBytes.length){
                    if(actual.getNodoIzquierdo() != null){
                        actual = actual.getNodoIzquierdo();
                        actualNodoBytes = actual.getValor().toString().getBytes();
                        i = 0;
                    }else{
                        System.out.println("no retorna");
                        return -1;
                    }
                }
            }
        }
    }
}
