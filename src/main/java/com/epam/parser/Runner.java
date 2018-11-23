package com.epam.parser;

import com.epam.parser.entity.Paragraph;
import com.epam.parser.entity.Text;
import com.epam.parser.logic.PropertyManager;
import com.epam.parser.logic.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class Runner {
    private static Logger logger = LogManager.getLogger(Runner.class);
    public static void main(String[] args) {
        Text text = new Text();
        text.setText(Util.getTextFromFile("text1.txt"));
        PropertyManager propertyManager = new PropertyManager("parser.properties");
        text.setPropertyManager(propertyManager);
        text.parse();
        List<Paragraph> paragraphs = text.getParagraphs();
//        for (Paragraph paragraph: paragraphs){
//            System.out.println("Paragraph1:");
//            System.out.println(paragraph.getText());
//        }
        logger.info("это логгер");
    }
}
