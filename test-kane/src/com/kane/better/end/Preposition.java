package com.kane.better.end;

public class Preposition implements Rule{
    public final static String [] OPTIONS_WORD= {
        "above","across","against","along","among"
        ,"around","before","behind","beneath","beside"
        ,"between","beyond","during","inside","onto"
        ,"outside","under","underneath","upon","with"
        ,"without","through"
    };
    
    public final static String [] OPTIONS_RULE = {
        "<NOUN>"
        ,"<PRONOUN>"
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