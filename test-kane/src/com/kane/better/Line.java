package com.kane.better;


public class Line implements Rule{
    public static String STR_LINE = "";
    public final static String [] OPTIONS_RULE = {
        "<NOUN>"
        ,"<PREPOSITION>"
        ,"<PRONOUN>"
    };
    public final static String KEY_WORD = "$LINEBREAK";
    
    @Override
    public void procesWord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void procesRule() {       
        String strRule = OPTIONS_RULE[randon(OPTIONS_RULE.length)];
        System.out.println("      ..."+strRule);
        this.process(strRule);        
    }
    
    public static void main(String... arrPAram){
        Rule rule = new Line();
        for(int i=0; i<1000; i++){           
            rule.procesRule();
            System.out.println(KEY_WORD+" .... "+i);
        }
    }  
    
}
