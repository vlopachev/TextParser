package com.epam.parser.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence extends PartText implements Comparable {

    private static final String REGEX_SPLIT_SENTENCE_TO_WORD = "\\s+";
    private static final String REGEX_MATCH_WORD_WITH_PUNCTUATION = "([^,.!?]*)([,.!?])";

    public Sentence(String text) {
        super(text);
    }

    @Override
    public void parse() {
        String[] words = Pattern.compile(REGEX_SPLIT_SENTENCE_TO_WORD).split(getText());
        for (String word : words) {
            if (word.contains(",") || word.contains(".") || word.contains("!")
                    || word.contains("?")) {
                String[] arrayWordWithPunctuation = splitPunctuationFromWord(word);
                getListPartsText().add(new Word(arrayWordWithPunctuation[0]));
                getListPartsText().add(Simbol.getInstance(arrayWordWithPunctuation[1].charAt(0)));
            } else {
                getListPartsText().add(new Word(word));
            }
        }
        for (PartText partText: getListPartsText()){
            partText.parse();
        }
    }

    @Override
    public int compareTo(Object o) {
        Sentence other = (Sentence) o;
        return getCountWords() - other.getCountWords();
    }

    private String[] splitPunctuationFromWord(String wordWithPunctuation) {
        String[] arrayWordWithPunctuation = new String[2];
        Matcher matcher =
                Pattern.compile(REGEX_MATCH_WORD_WITH_PUNCTUATION).matcher(wordWithPunctuation);
        matcher.find();
        arrayWordWithPunctuation[0] = matcher.group(1);
        arrayWordWithPunctuation[1] = matcher.group(2);
        return arrayWordWithPunctuation;
    }

    private int getCountWords() {
        int count = 0;
        for (PartText partText : getListPartsText()) {
            if (partText.getText().length() > 2) {
                count++;
            }
        }
        return count;
    }
}
