package com.kane;


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
        if(strRule.equals("<NOUN>")){
            Rule rule = new Noun();
            rule.procesRule();
        }else if(strRule.equals("<PREPOSITION>")){
            Rule rule = new Preposition();
            rule.procesRule();
        }else if(strRule.equals("<PRONOUN>")){
            Rule rule = new Pronoun();
            rule.procesRule();
        }
    }
    
    public static void main(String... arrPAram){
        Rule rule = new Line();
        for(int i=0; i<1000; i++){           
            rule.procesRule();
            System.out.println(KEY_WORD+" .... "+i);
        }
    }  
    
}
