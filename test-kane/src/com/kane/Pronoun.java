package com.kane;

import static com.kane.Preposition.OPTIONS_WORD;

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
        System.out.println("...   "+word);
        Line.STR_LINE = Line.STR_LINE+" "+word;
    }
    
    @Override
    public void procesRule() {        
        procesWord();
        String strRule = OPTIONS_RULE[randon(OPTIONS_RULE.length)];
        System.out.println("      ..."+strRule);
        if(strRule.equals("<NOUN>")){
            Rule rule = new Noun();
            rule.procesRule();       
        }else if(strRule.equals("<ADJECTIVE>")){
            Rule rule = new Adjective();
            rule.procesRule();
        }
    }
    
    public static void main(String... arrPAram){
        Rule rule = new Pronoun();
        for(int i=0; i<10; i++){
            rule.procesRule();
        }
    }
}
