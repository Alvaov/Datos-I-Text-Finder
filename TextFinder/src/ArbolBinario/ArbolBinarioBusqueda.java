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
}
