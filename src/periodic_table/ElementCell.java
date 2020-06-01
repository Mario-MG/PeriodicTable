
package periodic_table;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Mario
 */
public class ElementCell extends StackPane {
    
    // ATRIBUTOS
    private final int atomicNum, group, period ;
    private final String name, symbol, etymology, type, weight, abundance ;
    
    private final Border border = new Border(new BorderStroke(
            Color.BLACK,
            BorderStrokeStyle.SOLID,
            new CornerRadii(2.0),
            new BorderWidths(1.0)
    )) ;
    private Insets insets = new Insets(0.0,2.0,2.0,2.0) ;
    private final Text symbolTxt ;
    private final Text nameTxt ;
    private final Text atomicNumTxt ;
    
    private boolean clicked = false ;
    private ElementCell cell ;
    private Element element ;
    private static ArrayList<ElementCell> cellList = new ArrayList() ;
    
    private final EventHandler<MouseEvent> mouseEnterEH = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            PeriodicTable.enterCell(element, cell) ;
        }
    } ;
    
    private final EventHandler<MouseEvent> mouseExitEH = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            PeriodicTable.exitCell(cell) ;
        }
    } ;
    
    private final EventHandler<MouseEvent> mouseClickEH = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            PeriodicTable.clickCell(element, cell) ;
        }
    } ;
    
    
    // CONSTRUCTORES
    public ElementCell(Element element) {
        
        name = element.name ;
        symbol = element.symbol ;
        type = element.type ;
        group = element.group ;
        period = element.period ;
        atomicNum = element.Z ;
        etymology = "" ;
        weight = "" ;
        abundance = "" ;
        
        cell = this ;
        this.element = element ;
        
        this.symbolTxt = new Text();
        this.nameTxt = new Text();
        this.atomicNumTxt = new Text();
        setSymbolTxt(24) ;
        setNameTxt(8) ;
        setAtomicNumTxt() ;
        
        setBorder(border) ;
        setPrefSize(59, 59) ;
        setMaxWidth(59) ;
        setPadding(insets);
        setBackground(getElementBG(false)) ;
        addEventFilter(MouseEvent.MOUSE_ENTERED, mouseEnterEH) ;
        addEventFilter(MouseEvent.MOUSE_EXITED, mouseExitEH) ;
        addEventFilter(MouseEvent.MOUSE_CLICKED, mouseClickEH) ;
        
        cellList.add(this) ;
        
        // EL PRASEODIMIO SE SALE
        
    }
    
    
    // GETTERS Y SETTERS
    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    
    public void setBig() {
        setPadding(new Insets(4.0,4.0,4.0,4.0)) ;
        setSymbolTxt(36) ;
        setNameTxt(16) ;
        removeEventFilter(MouseEvent.MOUSE_ENTERED, mouseEnterEH);
        removeEventFilter(MouseEvent.MOUSE_EXITED, mouseExitEH);
        removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseClickEH);
        setMaxWidth(USE_COMPUTED_SIZE);
    }
    
    
    
    // MÉTODOS
    private Color getElementColor(String elementType, boolean mouseOver) {
        
        Color colorNotOver, colorOver ;
        switch ( elementType ) {
            case "Reactive nonmetal":
                colorNotOver = Color.YELLOW ;
                colorOver = Color.rgb(255, 255, 150) ;
                break ;
            case "Noble gas":
                colorNotOver = Color.LIGHTBLUE ;
                colorOver = Color.ALICEBLUE ;
                break ;
            case "Alkali metal":
                colorNotOver = Color.RED ;
                colorOver = Color.TOMATO ;
                break ;
            case "Alkaline earth metal":
                colorNotOver = Color.ORANGE ;
                colorOver = Color.GOLD ;
                break ;
            case "Post-transition metal":
                colorNotOver = Color.BURLYWOOD ;
                colorOver = Color.BEIGE ;
                break ;
            case "Metalloid":
                colorNotOver = Color.GREEN ;
                colorOver = Color.YELLOWGREEN ;
                break ;
            case "Transition metal":
                colorNotOver = Color.CADETBLUE ;
                colorOver = Color.LIGHTSKYBLUE ;
                break ;
            case "Lanthanide":
                colorNotOver = Color.BLUEVIOLET ;
                colorOver = Color.MEDIUMPURPLE ;
                break ;
            case "Actinide":
                colorNotOver = Color.VIOLET ;
                colorOver = Color.PINK ;
                break ;
            default:
                colorNotOver = Color.GREY ;
                colorOver = Color.DARKGRAY ;
                break ;
        }
        
        if ( !mouseOver ) return colorNotOver ;
        else return colorOver ;
        
    }
    
    private Background getElementBG(boolean mouseOver) {
        
        Background BG = new Background(new BackgroundFill(
                getElementColor(type, mouseOver), 
                new CornerRadii(2.0), 
                Insets.EMPTY
        )) ;
        
        return BG ;
        
    }
    
    public void setElementBG(boolean mouseOver) {
        setBackground(getElementBG(mouseOver)) ;
    }
    
    private void setSymbolTxt(int size) {
        symbolTxt.setStyle(
                "-fx-font-weight: bold;"
                +"-fx-font-size: " + size + "px;"
        ) ;
        symbolTxt.setText(symbol) ;
        if ( !getChildren().contains(symbolTxt) ) getChildren().add(symbolTxt);
    }
    
    public void clearSymbolTxt() {
        symbolTxt.setText("") ;
    }
    
    public static void clearAllSymbols() {
        for ( ElementCell cell : cellList ) {
            if ( !cell.isBig() ) cell.clearSymbolTxt() ;
        }
    }
    
    private void setNameTxt(int size) {
        nameTxt.setStyle(
                "-fx-font-size: " + size + "px"
        ) ;
        nameTxt.setText(name) ;
        if ( !getChildren().contains(nameTxt) ) getChildren().add(nameTxt) ;
        StackPane.setAlignment(nameTxt, Pos.BOTTOM_CENTER) ;
    }
    
    public void clearNameTxt() {
        nameTxt.setText("") ;
    }
    
    public static void clearAllNames() {
        for ( ElementCell cell : cellList ) {
            if ( !cell.isBig() ) cell.clearNameTxt() ;
        }
    }
    
    private void setAtomicNumTxt() {
        atomicNumTxt.setText(String.valueOf(atomicNum)) ;
        getChildren().add(atomicNumTxt) ;
        StackPane.setAlignment(atomicNumTxt, Pos.TOP_LEFT) ;
    }
    
    private void clearCell() {
        clearSymbolTxt() ;
        clearNameTxt() ;
    }
    
    public static void clearAllCells() {
        for ( ElementCell cell : cellList ) {
            if ( !cell.isBig() ) cell.clearCell() ;
        }
    }
    
    public void fillCell() {
        setSymbolTxt(24) ;
        setNameTxt(8) ;
    }
    
    public void removeZ() {
        atomicNumTxt.setText("") ;
    }
    
    public static void fillAllCells() {
        for ( ElementCell cell : cellList ) {
            if ( !cell.isBig() ) cell.fillCell() ;
        }
    }
    
    public static void fillAllSymbols() {
        for ( ElementCell cell : cellList ) {
            if ( !cell.isBig() ) cell.setSymbolTxt(24) ;
        }
    }
    
    public static void fillAllNames() {
        for ( ElementCell cell : cellList ) {
            if ( !cell.isBig() ) cell.setNameTxt(8) ;
        }
    }
    
    private boolean isBig() {
        return getMaxWidth() == USE_COMPUTED_SIZE ;
    }
    
    public Element getElement() {
        return element ;
    }
    
}
