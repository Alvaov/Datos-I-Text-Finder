/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfinder;

import ArbolBinario.ArbolBinarioBusqueda;
import ArbolBinario.Nodo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import listlinked.ListLinked;

/**
 *
 * @author Brayan
 */
public class TextFinder extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBinarioBusqueda<String> arbol = new ArbolBinarioBusqueda();
        arbol.añadirElemento("pito");
        
        
        arbol.eliminate("pito");
        
        ListLinked lista= arbol.inOrden();
        for(int i = 0;i<lista.getSize();i++){
            System.out.println(lista.buscarElemento(i).getValor());
        }
        launch(args);
    }   
}
