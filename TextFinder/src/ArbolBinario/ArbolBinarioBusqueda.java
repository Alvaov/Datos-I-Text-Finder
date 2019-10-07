/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

import listlinked.ListLinked;

/**
 * 
 * @author Brayan
 * @param <T> clase del arbol
 */
public class ArbolBinarioBusqueda<T> {
    private Nodo<T> raiz;
    private long size;
    /**
     * initizalices the Tree
     */
    public ArbolBinarioBusqueda(){
        raiz = null;
        size = 0;
    }
    public ArbolBinarioBusqueda(Nodo<T> rootValue){
        raiz = rootValue;
        size = 0;
    }
    /**
     * retorna el valor minimo del arbol
     * @return valor minimo del arbol
     */
    public T findMin(){
        Nodo<T> temp = raiz;
        while(temp.getNodoIzquierdo()!=null){
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
        while(temp.getNodoDerecho()!=null){
            temp = temp.getNodoDerecho();
        }
        return temp.getValor();
    }
    /**
     * 
     * @param root
     * @return 
     */
    private Nodo<T> findMinNode(Nodo<T> root){
        Nodo<T> temp = root;
        while(temp.getNodoIzquierdo()!=null){
            temp = temp.getNodoIzquierdo();
        }
        return temp;
    }
    /**
     * 
     * @param root
     * @return 
     */
    private Nodo<T> findMaxNode(Nodo<T> root){
        Nodo<T> temp = root;
        while(temp.getNodoDerecho()!=null){
            temp = temp.getNodoDerecho();
        }
        return temp;
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
    
    
    public void añadirElemento(T elemento){
        
        if(raiz == null){
            raiz = new Nodo(elemento);
            size++;
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
                    size++;
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
                    size++;
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
                        size++;
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
                        size++;
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
    public void eliminate(T value){
        if( raiz.getNodoDerecho() ==null && raiz.getNodoIzquierdo()==null){
            raiz = null;
            return;
        }
        T root = raiz.getValor();
        byte[] toFindBytes = value.toString().getBytes();
        ListLinked<T> list = inOrden();
        for(int i = 0;i<=list.getSize();i++){
            byte[] NodeBytes = list.buscarElemento(i).getValor().toString().getBytes();
            if(toFindBytes.length == NodeBytes.length){
                int igualdades =0;
                for(int j = 0; j<toFindBytes.length;j++){
                    if(igualdades<toFindBytes.length){
                        if (toFindBytes[j]==NodeBytes[j]){
                            igualdades++;
                        }
                    }
                }if(igualdades == toFindBytes.length){
                    if (root == value){
                        try{
                            root = list.getValor(i+2);
                        }catch(Exception e){
                            root = list.getValor(i-1);
                        }
                    }
                    list.eliminarEnPosición(i+1);
                }
            }
        }
        
        Nodo<T> node = new Nodo(root);
        raiz = node;
        ArbolBinarioBusqueda<T> arbol = new ArbolBinarioBusqueda(node);
        arbol.añadirElemento(root);
        for(int k=0;k<list.getSize();k++){
            if(list.getValor(k) != root){
              arbol.añadirElemento(list.getValor(k));
            }
        }
    }
    public ListLinked<T> inOrden(){
       System.out.println("****************");
       ListLinked<T> list = new ListLinked();
       return inOrdenAux(raiz,list);
    }
    private ListLinked<T> inOrdenAux(Nodo<T> root,ListLinked<T> list){
        if(root==null){
            return list;
        }else{
            if(root.getNodoIzquierdo() != null){
                inOrdenAux(root.getNodoIzquierdo(),list);
            }
            list.añadirFinal(root.getValor());
            
            if(root.getNodoDerecho() != null){
                inOrdenAux(root.getNodoDerecho(),list);
            }
        }
        return list;
    }
    public Nodo<T> getRoot(){
        return raiz;
    }
}
