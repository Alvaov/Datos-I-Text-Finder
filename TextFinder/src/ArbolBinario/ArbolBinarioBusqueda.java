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
    public boolean find(T toFind){
        Nodo<T> node = raiz;
        byte[] NodeBytes = node.getValor().toString().getBytes();
        byte[] toFindBytes = toFind.toString().getBytes();
        int i = 0;
        while(true){
            if(NodeBytes[i] > toFindBytes[i]){
                if(node.getNodoDerecho() != null){
                    node = node.getNodoDerecho();
                    NodeBytes = node.getValor().toString().getBytes();
                }else{
                    return false;
                }
            }else if(NodeBytes[i] < toFindBytes[i]){
                if(node.getNodoIzquierdo() != null){
                    node = node.getNodoIzquierdo();
                    NodeBytes = node.getValor().toString().getBytes();
                }else{
                    return false;
                }
            }else{
                i++;
                if(i == toFindBytes.length && i == NodeBytes.length){
                    return true;
                        
                }else{
                    return false;
                }
            }
        }
    }
    
}
