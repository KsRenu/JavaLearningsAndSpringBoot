package org.example.Structure;

import com.google.gson.Gson;
import org.example.Structure.Employee;
import org.example.Structure.Intern;
import org.example.Structure.Manager;
import org.example.Structure.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.json.Json;
import javax.json.JsonReader;
import java.util.ArrayList;
import java.util.Iterator;

public class EncodingJSON {
    public static ArrayList<Person> details(){
        ArrayList<Person>  persons = new ArrayList<>();

        Intern i1 = new Intern("intern",2,"internfname","internlname",10,199.098,"01/01/01","01/01/01");
        Employee e1 = new Employee("employee",1,"employeefname","employeelname",10,199.098,"marketing","add and mark");
        Manager m1 = new Manager("manager",3,"managerfname","managerlname",10,199.098,new String[]{"name1","name2"},"sales");
        for (int i = 0; i < 10; i++) {
            persons.add(i1);
            persons.add(e1);
            persons.add(m1);
        }
        return persons;
    }
    public static void main(String[] args) throws ParseException {
        ArrayList<JSONObject> interns = new ArrayList<>();
        ArrayList<JSONObject> employees = new ArrayList<>();
        ArrayList<JSONObject> managers = new ArrayList<>();

/**
        int internCount=0,employeeCount=0, managerCount=0;
        ArrayList<Person> persons = details();

        for (Person person:persons) {
            //System.out.println(person.getType());
            if(person.getType()== "employee"){
                employeeCount+=1;
            } else if (person.getType()=="intern") {
                internCount+=1;
            }
            else{
                managerCount+=1;
            }
        }
        //System.out.println("Total count of persons category wise: \n Interns: "+internCount+" Employees: "+employeeCount+" Managers: "+managerCount);
**/
        int intCount=0, empCount=0, manCount =0;
        ArrayList<Person> personDetails = details();


        System.out.print("The JSON representation of persons is: ");
        System.out.println(new Gson().toJson(personDetails));
        String x = new Gson().toJson(personDetails);
        //System.out.println("x: "+x.getClass().getName());
        JSONParser parser = new JSONParser();
        Object jsonObj = parser.parse(x);
        JSONArray jsonObject = (JSONArray) jsonObj;
        //System.out.println(jsonObject.getClass().getName());
        //System.out.println("Print");
        for (Object i:jsonObject) {
            //System.out.println(i);
            JSONObject object = (JSONObject) i;
            //System.out.println(object.get("type"));
            //String type = (String) object.get("type");
            //System.out.println(type);
            if(object.get("type").equals("intern")){
                intCount+=1;
                interns.add(object);
            } else if (object.get("type").equals("employee")) {
                empCount+=1;
                employees.add(object);
            } else if (object.get("type").equals("manager")) {
                manCount+=1;
                managers.add(object);
            }
            else{
                System.out.println("Invalid");
            }
        }
        System.out.println();

        System.out.println("Total count of persons category wise: Interns: "+intCount+" Employees: "+empCount+" Managers: "+manCount);
        System.out.println("The "+intCount+" interns details are: "+interns);
        System.out.println("The "+empCount+" employee details are: "+employees);
        System.out.println("The "+manCount+" managers details are: "+managers);
        System.out.println();
        System.out.println("Name list category wise: ");
        System.out.println("The "+ intCount+ " interns are: ");
        for (JSONObject intern: interns) {
            //System.out.println(intern.getClass().getName());
            String fname = (String) intern.get("fname");
            String lname = (String) intern.get("lname");
            System.out.println(fname+" "+lname);
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("The "+ empCount+ " employees are: ");
        for (JSONObject employee: employees) {
            //System.out.println(intern.getClass().getName());
            String fname = (String) employee.get("fname");
            String lname = (String) employee.get("lname");
            System.out.println(fname+" "+lname);
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("The "+ manCount+ " managers are: ");
        for (JSONObject manager: managers) {
            //System.out.println(intern.getClass().getName());
            String fname = (String) manager.get("fname");
            String lname = (String) manager.get("lname");
            System.out.println(fname+" "+lname);
        }




        //System.out.println(jsonObject.getClass().getName());
        /**String[] arr = x.split("}");
        for (String s:arr             ) {
            if(s.contains("intern")){

            } else if (s.contains("employee")) {
                empCount+=1;
            }
            else if (s.contains("manager")){
                //System.out.println(s);
                manCount+=1;
            }
            else{
                //System.out.println(s);
                //System.out.println("Invalid");
            }
        }
        System.out.println("Total count of persons category wise: \n Interns: "+intCount+" Employees: "+empCount+" Managers: "+manCount);
**/


















        // String type = (String) jsonObject.get("fname");
        //JSONArray fnames = (JSONArray)jsonObject.get(0);
        //Iterator<String> namesIterator = jsonObject.iterator();
        //System.out.println("Hey: "+ jsonObject.get(0));
        //String jsonText = JSONValue.toJSONString(jsonObject);

        //System.out.println("\nEncode a JSON Array - Using List");
        //System.out.print(jsonText.contains("intern"));
       // System.out.println();
        //while(namesIterator.hasNext()){
          //  Object i = namesIterator.next();
            //for(int j=0;j<i.s)
        //}
        //if(i.getClass()=="Intern"){
          //  System.out.println(" ");
        //}
        //System.out.println(jsonObject.getClass().getName());
        //System.out.println(jsonObject[5]);
        //for (Object json:jsonObject             ) {
          //  System.out.println(jsonObject.get("fname"));
        //}


    }


    }


