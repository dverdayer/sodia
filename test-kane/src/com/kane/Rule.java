package com.kane;

import java.util.Random;

public interface Rule {
    default int randon(int len){
        Random rand = new Random();
        return rand.nextInt(len);
    }
    void procesWord();
    void procesRule();
}
