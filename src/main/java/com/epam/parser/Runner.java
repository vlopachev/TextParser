package com.epam.parser;

import com.epam.parser.entity.PartText;
import com.epam.parser.entity.Text;
import com.epam.parser.logic.PropertyManager;
import com.epam.parser.logic.Util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        PropertyManager propertyManager = new PropertyManager("parser.properties");
        //Text text = new Text();
        String text = Util.getTextFromFile("text1.txt");


        Pattern pattern = Pattern.compile("[^.!?]*[.!?]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group().trim());
        }



//        text.parse();
//        List<PartText> paragraphs = text.getListPartsText();
//        for (PartText paragraph: paragraphs){
//            System.out.println(paragraph.getId());
//            System.out.println(paragraph.getText());
//            for (PartText sentence: paragraph.getListPartsText()){
//                System.out.println(sentence.getId());
//                System.out.println(sentence.getText());
//            }
//        }
    }
}
