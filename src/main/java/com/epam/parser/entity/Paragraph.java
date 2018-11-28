package com.epam.parser.entity;


import java.util.regex.Pattern;

public class Paragraph extends PartText{
    private static final String REGEX_SPLIT_TEXT_TO_SENTENCE = "[\\w,:;\\-/)(]*[.?!]";


    public Paragraph(String text) {
        super(text);
    }

    @Override
    protected void parse() {
        String [] pars = Pattern.compile(REGEX_SPLIT_TEXT_TO_SENTENCE, Pattern.MULTILINE).split(getText());
        for (String par: pars){
            getListPartsText().add(new Sentence(par));
        }

    }

}
