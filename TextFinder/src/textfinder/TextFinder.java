/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfinder;

import ArbolBinario.ArbolBinarioBusqueda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Brayan
 */
public class TextFinder extends Application {
    
    static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        this.stage = stage;
        Scene scene = new Scene(root);
        stage.setTitle("Text Finder");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
        arbol.añadirElemento("efe");
        arbol.añadirElemento("largo");
        arbol.añadirElemento("lejos");
        arbol.añadirElemento("maní");
        System.out.println(arbol.findMin());
        System.out.println(arbol.findMax());
       // arbol.retornarElemento("lejos");
       // arbol.retornarElemento("que tal");
        launch(args);
    }
    public static Stage getStage(){
        return stage;
    }
}
