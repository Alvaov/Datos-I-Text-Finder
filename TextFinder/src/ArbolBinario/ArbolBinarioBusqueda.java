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
    Nodo<T> raiz;
    /**
     * initizalices the Tree
     */
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
    /**
     * 
     * @param toFind
     * @return 
     */
    public T find(T toFind){
        Nodo<T> temp = raiz;
        byte[] bytesToFind = toFind.toString().getBytes();
        while(temp != null){
            byte[] bytesToCompare = temp.getValor().toString().getBytes();
            for(int i=0;i<bytesToCompare.length;i++){
                if(i == bytesToCompare.length-1){
                    if(bytesToCompare.length == bytesToFind.length){
                       temp.addReferencias(toFind);
                    }else{
                        
                    }
                }
            }
        }
        if(temp == null){
            return null;
        }
        return temp.getValor();
    }
    
}
