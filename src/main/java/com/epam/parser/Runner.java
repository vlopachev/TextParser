package com.epam.parser;

import com.epam.parser.entity.PartText;
import com.epam.parser.entity.Text;
import com.epam.parser.logic.Util;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Text text = new Text(Util.getTextFromFile("text1.txt"));
        text.parse();
        List<PartText> parts = text.getListPartsText().get(0).getListPartsText().get(0).getListPartsText();
        for (PartText part:parts){
            System.out.println(part.getText());
        }
    }
}
