package com.epam.parser.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class Text extends PartText{
    private static final String REGEX_SPLIT_TEXT_TO_PARAGRAPH = "(?<=(\r\n|\r|\n))([ \t]*$)+";


    @Override
    public void parse() {
        String [] pars = Pattern.compile(REGEX_SPLIT_TEXT_TO_PARAGRAPH, Pattern.MULTILINE).split(getText());
        for (String par: pars){
            getListPartsText().add(new Paragraph(par));
        }
        for (PartText partText: getListPartsText()){
            partText.parse();
        }
    }
}
