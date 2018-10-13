package com.kane.better.end;

import java.util.Random;

public interface Rule {
    default void process(String strRule){
        Rule rule;
        if(strRule.equals("<NOUN>")){
            rule = new Noun();            
        }else if(strRule.equals("<ADJECTIVE>")){ 
            if(this instanceof Adjective){
                rule = this;
            }else{
                rule = new Adjective();
            }
        }else if(strRule.equals("<PREPOSITION>")){
            rule = new Preposition();
        }else if(strRule.equals("<PRONOUN>")){
            rule = new Pronoun();
        }else  if(strRule.equals("<VERB>")){
            rule = new Verb();
        }else{
            return;
        }
        rule.procesRule();
    }
    
    default int randon(int len){
        Random rand = new Random();
        return rand.nextInt(len);
    }
    void procesWord();
    void procesRule();
}
