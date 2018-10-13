package com.kane;

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
        System.out.println("...   "+word);
        Line.STR_LINE = Line.STR_LINE+" "+word;
    }
    
    @Override
    public void procesRule() {        
        procesWord();
        String strRule = OPTIONS_RULE[randon(OPTIONS_RULE.length)];
        System.out.println("      ..."+strRule);
        if(strRule.equals("<VERB>")){
            Rule rule = new Verb();
            rule.procesRule();
        }else if(strRule.equals("<PREPOSITION>")){
            Rule rule = new Preposition();
            rule.procesRule();
        }
    }
    
    public static void main(String... arrPAram){
        Rule rule = new Noun();
        for(int i=0; i<10; i++){
            rule.procesWord();
            rule.procesRule();
        }
    }
	
}
