package org.example.Trials;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

public class two {

    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("org\\example\\Action\\data.json");

        Object jsonObj = parser.parse(reader);

        JSONObject jsonObject = (JSONObject) jsonObj;

        String name = (String) jsonObject.get("name");
        System.out.println("Name = " + name);

        long age = (Long) jsonObject.get("age");
        System.out.println("Age = " + age);


        reader.close();
    }

}