/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

import java.io.File;
import listlinked.ListLinked;

/**
 * Esta clase es la base de los arboles binarios.
 * @author Brian Wagemans Alvarado
 * @param <T> Clase del objeto
 */
public class Nodo<T> {
    private Nodo nodoIzq;
    private Nodo nodoDer;
    private T valor;
    private ListLinked<File> repeticiones;
    /**
     * crea un nodo con los parametros ingresados
     * @param valor 
     */
    public Nodo(T valor){
        this.valor = valor;
        this.nodoDer = null;
        this.nodoIzq = null;
    }
    /**
     * crea un nodo con los parametros ingresados
     * @param valor valor del nodo
     * @param hijoIzq Nodo Izq de este
     * @param hijoDer  Nodo Der de este
     */
    public Nodo(T valor,Nodo<T> hijoIzq, Nodo<T> hijoDer){
        this.valor = valor;
        this.nodoDer = hijoIzq;
        this.nodoIzq = hijoDer;
    }
    /**
     * retorna el hijo izquierdo del nodo
     * @return nodoIzq
     */
    public Nodo getNodoIzquierdo(){
        return this.nodoIzq;
    }
    /**
     * crea un nodo izquierdo con el valor ingresado
     * @param valor valor del nodo Izquierdo 
     */
    public void setNodoIzquierdo(T valor){
        this.nodoIzq = new Nodo(valor);
    }
    /**
     * retorna el hijo derecho del nodo
     * @return nodoDer
     */
    public Nodo getNodoDerecho(){
        return this.nodoDer;
    }
    /**
     * crea un Nodo Derecho con el valor ingresado
     * @param valor nuevo valor
     */
    public void setNodoDerecho(T valor){
        this.nodoDer = new Nodo(valor);
    }
    /**
     * retorna el valor del nodo
     * @return el valor de este nodo
     */
    public T getValor(){
        return this.valor;
    }
    /**
     * La funcion cambia el valor del nodo
     * @param valorNuevo es el nuevo valor del Nodo
     */
    public void setValor(T valorNuevo){
        this.valor = valorNuevo;
    }
    /**
     * funcion que consigue la lista de repeticiones
     * @return la lista de repeticiones
     */
    public ListLinked<File> getReferencias(){
        return repeticiones;
    }
    /**
     * Agrega un archivo a las repeticiones
     * @param archivo archivo a agregar.
     */
    public void addReferencias(File archivo){
        repeticiones.añadirFinal(archivo);
    }
}
