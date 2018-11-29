package com.epam.parser.logic;

import com.epam.parser.entity.PartText;
import com.epam.parser.entity.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextProcessor {
    private Text text;

    public TextProcessor() {
    }

    public TextProcessor(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public List<String> getAllParagraph(){
        List<String> paragraphs = text.getListPartsText().stream().map(PartText::getText).collect(Collectors.toList());
        return paragraphs;
    }

    public List<String> getAllSentences(){
        List<String> sentences = new ArrayList<>();
        for (PartText partText: text.getListPartsText()){
            sentences.addAll(partText.getListPartsText().stream().map(PartText::getText).collect(Collectors.toList()));
        }
        return sentences;
    }

    public List<String> getAllWords(){
        List<String> words = new ArrayList<>();
        for (PartText partText: text.getListPartsText()){
            for (PartText partText1: partText.getListPartsText()){
                words.addAll(partText1.getListPartsText().stream().filter(partText2 -> partText2.getText().length() > 1).map(PartText::getText).collect(Collectors.toList()));
            }
        }
        return words;
    }
}
