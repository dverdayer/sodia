package com.kane.better;

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
        System.out.println("...   "+word);
        Line.STR_LINE = Line.STR_LINE+" "+word;
    }
    
    @Override
    public void procesRule() {        
        procesWord();
        String strRule = OPTIONS_RULE[randon(OPTIONS_RULE.length)];
        System.out.println("      ..."+strRule);
        this.process(strRule);        
    }
    
    public static void main(String... arrPAram){
        Rule rule = new Adjective();
        for(int i=0; i<10; i++){
            rule.procesWord();
            rule.procesRule();
        }
    }       
}