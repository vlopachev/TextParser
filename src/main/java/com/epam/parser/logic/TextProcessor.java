package com.epam.parser.logic;

import com.epam.parser.entity.PartText;
import com.epam.parser.entity.Text;

import java.util.*;
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

    public List<String> getAllParagraph() {
        List<String> paragraphs = text.getListPartsText().stream().map(PartText::getText).collect(Collectors.toList());
        return paragraphs;
    }

    public List<PartText> getAllSentences() {
        return getPartText(text.getListPartsText());
    }

    public List<PartText> getAllWords() {
        List<PartText> words = new ArrayList<>();
        for (PartText word : getPartText(getAllSentences())) {
            if (word.getText().length() > 2) {
                words.add(word);
            }
        }
        return words;
    }

    public Map<String, Integer> wordOccurrence() {
        Map<String, Integer> wordsOccurrence = new TreeMap<>();
        for (PartText word : getAllWords()) {
            String key = word.getText();
            if (wordsOccurrence.containsKey(key)) {
                wordsOccurrence.put(key, wordsOccurrence.get(key) + 1);
            } else {
                wordsOccurrence.put(key, 1);
            }
        }
        return wordsOccurrence;
    }

    public void parse() {
        text.parse();
    }

    private List<PartText> getPartText(List<PartText> partTextList) {
        List<PartText> partTexts = new ArrayList<>();
        for (PartText partText : partTextList) {
            partTexts.addAll(partText.getListPartsText());
        }
        return partTexts;
    }
}
