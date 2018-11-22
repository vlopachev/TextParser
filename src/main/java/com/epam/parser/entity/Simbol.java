package com.epam.parser.entity;

import java.util.HashMap;
import java.util.Map;

public class Simbol implements PartOfSentense{
    private char simbol;
    private static int LATIN_ALPHABET_NUMBER_START = 32;
    private static int LATIN_ALPHABET_NUMBER_END = 126;
    private static int CYRILLIC_ALPHABET_NUMBER_START = 1040;
    private static int CYRILLIC_ALPHABET_NUMBER_END = 1103;
    public static final Map<Character,Simbol> POOL = new HashMap<>();

    static {
        for (int i = LATIN_ALPHABET_NUMBER_START; i <= LATIN_ALPHABET_NUMBER_END; i++) {
            char simb = (char)i;
            POOL.put(simb, new Simbol(simb));
        }
        for (int i = CYRILLIC_ALPHABET_NUMBER_START; i <= CYRILLIC_ALPHABET_NUMBER_END; i++) {
            char simb = (char)i;
            POOL.put(simb, new Simbol(simb));
        }
        POOL.put('Ё', new Simbol('Ё'));
        POOL.put('ё', new Simbol('ё'));
    }

    public char getSimbol() {
        return simbol;
    }

    public void setSimbol(char simbol) {
        this.simbol = simbol;
    }

    private Simbol(char simbol) {
        this.simbol = simbol;
    }
}
