package org.example.Trials;

import org.example.Structure.Employee;
import org.example.Structure.Intern;
import org.example.Structure.Manager;
import org.example.Structure.Person;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

// Program for print data in JSON format.
public class one {
    public static ArrayList<Person> details(){
        ArrayList<Person>  persons = new ArrayList<>();

        Intern i1 = new Intern("intern",2,"fname","lname",10,199.098,"01/01/01","01/01/01");
        Employee e1 = new Employee("employee",1,"fname","lname",10,199.098,"marketing","add and mark");
        Manager m1 = new Manager("manager",3,"fname","lname",10,199.098,new String[]{"name1","name2"},"sales");
        for (int i = 0; i < 10; i++) {
            persons.add(i1);
            persons.add(e1);
            persons.add(m1);
        }
        return persons;
    }
    public static void main(String args[]) throws ParseException {
        ArrayList<Person> persons = details();
        JSONParser parser = new JSONParser();
        String arr = persons.toArray().toString();
        Object jsonObj = parser.parse(arr);
        JSONObject jsonObject = (JSONObject) jsonObj;
        String name = (String) jsonObject.get("name");
        System.out.println("Name = " + name);

    }
}
