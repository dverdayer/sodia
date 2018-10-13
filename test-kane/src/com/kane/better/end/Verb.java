package com.kane.better.end;

public class Verb implements Rule{
    public final static String [] OPTIONS_WORD= {
        "runs","walks","stands","climbs","crawls"
        ,"flows","flies","transcends","ascends","descends"
        ,"sinks"
    };
    public final static String [] OPTIONS_RULE = {
        "<PREPOSITION>"
        ,"<PRONOUN>"
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
