package com.epam.parser.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class Util {
    public static String getTextFromFile(String file) {
        StringBuilder text = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while((line = reader.readLine()) != null) {
                text.append(line);
                text.append(ls);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
    private Util() {
    }
}
