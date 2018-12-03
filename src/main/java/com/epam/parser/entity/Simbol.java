package com.epam.parser.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simbol extends PartText {

    private static final int LATIN_ALPHABET_NUMBER_START = 32;
    private static final int LATIN_ALPHABET_NUMBER_END = 126;
    private static final int CYRILLIC_ALPHABET_NUMBER_START = 1040;
    private static final int CYRILLIC_ALPHABET_NUMBER_END = 1103;
    private static final Map<Character,Simbol> POOL_CHAR = new HashMap<>();

    private char simbol;

    static {
        for (int i = LATIN_ALPHABET_NUMBER_START; i <= LATIN_ALPHABET_NUMBER_END; i++) {
            char simb = (char)i;
            POOL_CHAR.put(simb, new Simbol(String.valueOf(simb)));
        }
        for (int i = CYRILLIC_ALPHABET_NUMBER_START; i <= CYRILLIC_ALPHABET_NUMBER_END; i++) {
            char simb = (char)i;
            POOL_CHAR.put(simb, new Simbol(String.valueOf(simb)));
        }
        POOL_CHAR.put('Ё', new Simbol("Ё"));
        POOL_CHAR.put('ё', new Simbol("ё"));
    }

    public static Simbol getInstance(Character key){
        return POOL_CHAR.get(key);
    }

    @Override
    public void parse() {
        getListPartsText().add(this);
    }

    public char getSimbol() {
        return simbol;
    }

    public void setSimbol(char simbol) {
        this.simbol = simbol;
    }

    private Simbol(String text) {
        super(text);
    }
}
