package com.epam.parser;

import com.epam.parser.entity.Text;
import com.epam.parser.logic.TextProcessor;
import com.epam.parser.logic.Util;

import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Text text = new Text(Util.getTextFromFile("text1.txt"));
        TextProcessor textProcessor = new TextProcessor(text);
        List<String> sentences = textProcessor.getAllSentences();
        Collections.sort(sentences);
        for (String word: sentences){
            System.out.println(word);
        }
    }
}
