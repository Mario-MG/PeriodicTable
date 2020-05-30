/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla_periodica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class Element {
    
    private final int atomicNum, group, period ;
    private final String element, name, symbol, etymology, type, weight/*, abundance*/ ;
    private final String[] elementData ;
    
    private static final File FICHERO = new File("elementos.txt") ;
    private static BufferedReader fbr ;
    private static ArrayList<Element> ElementList = new ArrayList<>() ;
    
    private Element() throws IOException {
        
        this.element = fbr.readLine() ;
        this.elementData = element.split("\t") ;
        
        this.atomicNum = AtomicNumber() ;
        this.symbol = Symbol() ;
        this.name = Name() ;
        this.group = Group() ;
        this.period = Period() ;
        this.weight = Weight() ;
        this.type = Type() ;
        this.etymology = Etymology() ;
        
    }
    
    public static void initReader() throws IOException {
        
        try {
            fbr = new BufferedReader(new FileReader(FICHERO)) ;
        } catch ( Exception ex )  {
            System.out.println("Error al leer.") ;
        }
        
        for ( int Z = 1 ; Z <= 118 ; Z++ ) {
            ElementList.add(new Element()) ;
        }
        
    }
    
    
    public static Element getElement(int Z) {
        return ElementList.get(Z-1) ;
    }

    public int getAtomicNum() {
        return atomicNum;
    }

    public int getGroup() {
        return group;
    }

    public int getPeriod() {
        return period;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getEtymology() {
        return etymology;
    }

    public String getType() {
        return type;
    }

    public String getWeight() {
        return weight;
    }

    /*public String getAbundance() {
        return abundance;
    }*/
    
    
    
    
    private int AtomicNumber() {
        return Integer.parseInt(elementData[0]) ;
    }
    
    private String Symbol() {
        return elementData[1] ;
    }
    
    private String Name() {
        return elementData[2] ;
    }
    
    private String Etymology() {
        return elementData[3] ;
    }
    
    private int Group() {
        String groupStr = elementData[4] ;
        if ( !groupStr.equals("n/a") ) return Integer.parseInt(groupStr) ;
        else return 0 ;
    }
    
    private int Period() {
        return Integer.parseInt(elementData[5]) ;
    }
    
    private String Weight() {
        return elementData[6] ;
    }
    
    private String Type() {
        return elementData[13] ;
    }
    
}
