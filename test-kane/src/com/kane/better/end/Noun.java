package com.kane.better.end;

public class Noun implements Rule{
    
    public final static String [] OPTIONS_WORD = {
        "heart","sun","moon","thunder","fire"
        ,"time","wind","sea","river","flavor"
        ,"wave","willow","rain","tree","flower"
        ,"field","meadow","pasture","harvest"
        ,"water","father","mother","brother","sister"
    };
    public final static String [] OPTIONS_RULE = {
        "<VERB>"
        ,"<PREPOSITION>"
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
