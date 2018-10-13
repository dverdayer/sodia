package com.kane.better.end;

public class Pronoun implements Rule{
    public final static String [] OPTIONS_WORD= {
        "my","your","his","her"
    };
    public final static String [] OPTIONS_RULE = {
        "<NOUN>"
        ,"<ADJECTIVE>"
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
