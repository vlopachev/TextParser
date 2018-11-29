package com.epam.parser.entity;

public class Word  extends PartText{
    public Word(String word) {
        super(word);
        parse();
    }

    @Override
    protected void parse() {
        char [] simbols = getText().toCharArray();
        for (char simbol: simbols){
            getListPartsText().add(Simbol.getInstance(simbol));
        }
    }
}
