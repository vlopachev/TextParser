package com.epam.parser.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph extends PartText{
    private static final String REGEX_SENTENCE = "[^.!?]*[.!?]";

    public Paragraph(String text) {
        super(text);
    }

    @Override
    public void parse() {
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        Matcher matcher = pattern.matcher(getText());
        while (matcher.find()){
            getListPartsText().add(new Sentence(matcher.group().trim()));
        }
        for (PartText partText: getListPartsText()){
            partText.parse();
        }
    }

    @Override
    public int compareTo(Object o) {
        Paragraph other = (Paragraph) o;
        return this.getListPartsText().size() - other.getListPartsText().size();
    }
}
