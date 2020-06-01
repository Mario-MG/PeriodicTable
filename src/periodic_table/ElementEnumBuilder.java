/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodic_table;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Mario
 */
public class ElementEnumBuilder {
    public static void main(String[] args) {
        File in = new File("elementos.txt") ;
        File out = new File("elementenums.txt") ;
        BufferedReader fbr = null ;
        BufferedWriter fbw = null ;
        
        try {
            fbr = new BufferedReader(new FileReader(in)) ;
            fbw = new BufferedWriter(new FileWriter(out)) ;
            out.createNewFile() ;
            
            String element = fbr.readLine() ;
            while ( element != null ) {
                String[] elementData = element.split("\t") ;
        
                String atomicNum = elementData[0] ;
                String symbol = elementData[1] ;
                String name = elementData[2] ;
                String etymology = elementData[3] ;
                String group = elementData[4].equals("n/a") ? "0" : elementData[4] ;
                String period = elementData[5] ;
                String type = elementData[13] ;
                String weight = elementData[6] ;
                
                String all = symbol.toUpperCase() + "(" + atomicNum + ", \"" + name + "\", " + 
                        group + ", " + period + ", \"" + type + "\", \"" + weight + "\", \"" + 
                        etymology + "\"),\n" ;
                System.out.println(all) ;
                fbw.write(all) ;
                
                element = fbr.readLine() ;
            }
            fbr.close() ;
            fbw.close() ;
        } catch ( Exception ex )  {
            ex.printStackTrace() ;
        }
    }
}
