/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla_periodica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Mario
 */
public class TablaPeriodica extends Application {
    
    
    private static final GridPane GRID = new GridPane();

    private static boolean clicked = false ;
    
    private static ElementCell currentElementCell ;
    
    private static String mode = "Inicio" ;
    
    private static ArrayList<Integer> clickedZ = new ArrayList() ;
    
    public static String getMode() {
        return mode ;
    }
    
    private static void generateRandomBigCell() {
        Random random = new Random() ;
        int bigZ ;
        do {
            bigZ = random.nextInt(118)+1 ;
        } while ( clickedZ.size() != 118 && clickedZ.contains(bigZ) ) ;
        clickedZ.add(bigZ) ;
        Element bigElement = Element.getElement(bigZ) ;
        bigCell(bigElement) ;
    }
    
    public static void clickCell(Element elemento, ElementCell cell) {
        switch ( mode ) {
            case "Símbolo" :
            case "Nombre" :
            case "Colocar" :
                if ( bigCell != null && bigCell.getElement().equals(elemento) ) {
                    cell.fillCell() ;
                    if ( clickedZ.size() != 118 ) generateRandomBigCell() ;
                    else {
                        GRID.getChildren().remove(bigCell) ;
                        mode = "Inicio" ;
                        clickedZ.clear() ;
                    }
                } else if ( bigCell == null ) generateRandomBigCell() ;
                break ;
            default :
                if ( clicked ) {
                    GRID.getChildren().remove(bigCell) ;
                    bigCell(elemento) ;
                    unclick() ;
                } else {
                    currentElementCell = cell ;
                    cell.setClicked(true) ;
                }
                clicked = !clicked ;
                break ;
        }
        
    }
    
    public static void enterCell(Element elemento, ElementCell cell) {
        if ( !cell.isClicked() ) cell.setElementBG(true) ;
        if ( !clicked && mode.equals("Inicio") ) TablaPeriodica.bigCell(elemento) ;
    }
    
    public static void exitCell(ElementCell cell) {
        if ( !cell.isClicked() ) cell.setElementBG(false) ;
        if ( !clicked && mode.equals("Inicio") ) GRID.getChildren().remove(bigCell) ;
    }
    
    private static ElementCell bigCell ;
    private static void bigCell(Element elemento) {

        if ( !clicked ) GRID.getChildren().remove(bigCell) ;
        
        bigCell = new ElementCell(elemento) ;
        bigCell.setBig() ;
        if ( !mode.equals("Inicio") ) bigCell.removeZ() ;
        if ( mode.equals("Nombre") ) bigCell.clearSymbolTxt() ;
        if ( mode.equals("Símbolo") ) bigCell.clearNameTxt() ;
        GRID.add(bigCell,6,0,2,2) ;
        
    }
    
    private void buildStack(int Z) {
        
        Element elemento = Element.getElement(Z) ;
        ElementCell cell = new ElementCell(elemento) ;
        int group = elemento.getGroup() ;
        int period = elemento.getPeriod() ;
        
        
        if ( group != 0 ) {
            GRID.add(cell,group-1,period-1) ;
        } else if ( period == 6 ) {
            GRID.add(cell,Z-55,8) ;
        } else if ( period == 7 ) {
            GRID.add(cell,Z-87,9) ;
        }
        
        GridPane.setMargin(cell, new Insets(1)) ;
        
    }
    
    private static void unclick() {
        if ( currentElementCell != null ) {
            currentElementCell.setClicked(false) ;
            currentElementCell.setElementBG(false) ;
        }
    }
    
    private final EventHandler<ActionEvent> accionPrueba = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            ElementCell.clearAllCells() ;
            mode = "Colocar" ;
            generateRandomBigCell() ;
        }
    } ;
    
    private final EventHandler<ActionEvent> accionCancelar = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            ElementCell.fillAllCells() ;
            mode = "Inicio" ;
            GRID.getChildren().remove(bigCell) ;
        }
    } ;
    
    private final EventHandler<ActionEvent> accionNombre = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            ElementCell.clearAllNames() ;
            ElementCell.fillAllSymbols() ;
            mode = "Nombre" ;
            generateRandomBigCell() ;
        }
    } ;
    
    private final EventHandler<ActionEvent> accionSimbolo = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            ElementCell.clearAllSymbols() ;
            ElementCell.fillAllNames() ;
            mode = "Símbolo" ;
            generateRandomBigCell() ;
        }
    } ;
    
    private Scene initScene() throws IOException {
        
        Element.initReader() ;
        
        for ( int Z = 1 ; Z <= 118 ; Z++ ) buildStack(Z) ;
        Button botonPrueba = new Button("Colocar") ;
        botonPrueba.setOnAction(accionPrueba) ;
        Button botonCancelar = new Button("Cancelar") ;
        botonCancelar.setOnAction(accionCancelar) ;
        Button botonNombre = new Button("Nombre") ;
        botonNombre.setOnAction(accionNombre) ;
        Button botonSimbolo = new Button("Símbolo") ;
        botonSimbolo.setOnAction(accionSimbolo) ;
        
        Group group = new Group() ;
        group.getChildren().add(GRID) ;
        GRID.add(botonPrueba,1,10) ;
        GRID.add(botonCancelar,2,10,2,1) ;
        GRID.add(botonNombre,4,10,2,1) ;
        GRID.add(botonSimbolo,6,10,2,1) ;
        
        GRID.add(new StackPane(new Text("Rare Earths")),3,7,14,1) ;
        
        StackPane root = new StackPane() ;
        root.getChildren().add(group) ;
        
        return new Scene(root);
        
    }
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        primaryStage.setTitle("Tabla Periódica");
        primaryStage.setScene(initScene());
        //primaryStage.sizeToScene() ;  // Para ajustar el tamaño a la Scene
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
