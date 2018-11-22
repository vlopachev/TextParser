package com.epam.parser.entity;

import com.epam.parser.logic.PropertyManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Text{
    private PropertyManager propertyManager;
    private String text;
    private List<Paragraph> paragraphs = new ArrayList<>();

    public Text() {
    }

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setPropertyManager(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
    }

    public List<Paragraph> parse() {
        String pattern = propertyManager.getProperty("paragraph.parse.regex");
        String [] pars = Pattern.compile(pattern, Pattern.MULTILINE).split(text);
        for (String par: pars){
            paragraphs.add(new Paragraph(par));
        }
        return paragraphs;
    }
}
