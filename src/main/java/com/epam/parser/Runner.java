package com.epam.parser;

import com.epam.parser.entity.PartText;
import com.epam.parser.entity.Sentence;
import com.epam.parser.entity.Text;
import com.epam.parser.logic.TextProcessor;
import com.epam.parser.logic.Util;
import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    public static void main(String[] args) {
        Text text = new Text(Util.getTextFromFile("text1.txt"));
        TextProcessor textProcessor = new TextProcessor(text);
        textProcessor.parse();
        List<PartText> sentences = textProcessor.getAllSentences();
        Collections.sort(sentences);
        for (PartText sentence: sentences){
            System.out.println(sentence.getText());
        }
        for (Map.Entry<String,Integer> pair: textProcessor.wordOccurrence().entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }





    }
}
