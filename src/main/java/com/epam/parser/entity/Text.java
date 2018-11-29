package com.epam.parser.entity;

import java.util.regex.Pattern;

public class Text extends PartText{
    private static final String REGEX_PARAGRAPH = "(?<=(\r\n|\r|\n))([ \t]*$)+";

    public Text(String text) {
        super(text);
        parse();
    }

    @Override
    protected void parse() {
        String [] pars = Pattern.compile(REGEX_PARAGRAPH, Pattern.MULTILINE).split(getText());
        for (String par: pars){
            getListPartsText().add(new Paragraph(par));
        }
    }
}
