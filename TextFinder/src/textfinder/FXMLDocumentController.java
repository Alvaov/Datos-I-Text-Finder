/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfinder;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

/**
 *
 * @author Brian Wagemans Alvarado/Alejandro Vásquez Oviedo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    MenuItem añadirBibliotecaArchivo;
    
    @FXML
    MenuItem añadirBibliotecaCarpeta;
    
    @FXML
    TreeView<File> biblioteca;
    
    @FXML
    TextField buscaTexto;
    
    @FXML
    Button buscar;
            
    
    String ruta;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        añadirBibliotecaArchivo.setOnAction(Event ->{
            System.out.println("menú");
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt","*.pdf","*.docx"));

            File selectedFile = fileChooser.showOpenDialog(TextFinder.getStage());
            
            if (selectedFile != null) {
                ruta = selectedFile.getAbsolutePath();

                }
    
        });
        buscar.setOnAction(event ->{
            String busqueda = buscaTexto.getText();
            //arbolote.buscarElemento(busqueda);
            //TODO
        });
        
        }
    
}
