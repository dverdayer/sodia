/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kane.better;

/**
 *
 * @author diego
 */
public class EnginePoems {
    public static String[] poem; 
    
    public static void main (String... arrParam){        
        int numberLines = 10;
        poem = new String[numberLines];
        Rule rule = new Line();
        for(int i=0; i<numberLines; i++){           
            rule.procesRule();
            System.out.println(Line.KEY_WORD+" .... "+i);
            poem[i] = Line.STR_LINE;
            Line.STR_LINE = "";
        }
        
        for(int i=0; i<poem.length; i++){                       
            System.out.println(poem[i]+" .... "+i);
        }
        
    }
}
