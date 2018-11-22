package com.epam.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Parsable{
    private String text;
    private List<Sentence> sentences = new ArrayList<>();

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Parsable parse() {
        return null;
    }
}
