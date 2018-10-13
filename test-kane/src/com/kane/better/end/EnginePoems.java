/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kane.better.end;

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
            poem[i] = Line.STR_LINE;
            Line.STR_LINE = "";
        }
        
        for (String poem1 : poem) {
            System.out.println(poem1);
        }
        
    }
}
