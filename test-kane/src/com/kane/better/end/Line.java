package com.kane.better.end;

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
        this.process(strRule);        
    }        
}
