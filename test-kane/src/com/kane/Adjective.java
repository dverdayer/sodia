package com.kane;

import java.util.Random;

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
        if(strRule.equals("<NOUN>")){
            Rule rule = new Noun();
            rule.procesRule();
        }else if(strRule.equals("<ADJECTIVE>")){            
            this.procesRule();
        }
    }
    
    public static void main(String... arrPAram){
        Rule rule = new Adjective();
        for(int i=0; i<10; i++){
            rule.procesWord();
            rule.procesRule();
        }
    }       
}


//POEM: <LINE> <LINE> <LINE> <LINE> <LINE>
//ADJECTIVE: black","white","dark","light","bright","murky","muddy","clear <NOUN>","<ADJECTIVE>","$END
//NOUN:heart","sun","moon","thunder","fire","time","wind","sea","river","flavor","wave","willow","rain","tree","flowe
//r","field","meadow","pasture","harvest","water","father","mother","brother","sister
//<VERB>","<PREPOSITION>","$END
//PRONOUN: my","your","his","her <NOUN>","<ADJECTIVE>
//VERB:
//runs","walks","stands","climbs","crawls","flows","flies","transcends","ascends","descends","sinks
//<PREPOSITION>","<PRONOUN>","$END
//PREPOSITION:
//"above","across","against","along","among","around","before","behind","beneath","beside","between","beyond","during","inside","onto","outside","under","underneath","upon","with","without","through"
//<NOUN>","<PRONOUN>","<ADJECTIVE>