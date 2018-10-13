package com.kane.better.end;

public class Adjective implements Rule{
    public final static String [] OPTIONS_WORD= {
        "black","white","dark","light"
        ,"bright","murky","muddy","clear"
    };
    public final static String [] OPTIONS_RULE = {
        "<NOUN>"
        ,"<ADJECTIVE>"
        ,"$END"
    };
    
    @Override
    public void procesWord() {        
        String word = OPTIONS_WORD[randon(OPTIONS_WORD.length)];
        Line.STR_LINE = Line.STR_LINE+" "+word;
    }
    
    @Override
    public void procesRule() {        
        procesWord();
        String strRule = OPTIONS_RULE[randon(OPTIONS_RULE.length)];
        this.process(strRule);        
    }            
}