package org.example;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
//Creating JSONArrayToArrayList class
public class JSONArrayToArrayList {
    public static ArrayList<Object> data()
        {
        //Creating string of JSON data
        /*String jsonData = "{\"languages\" : [{\"name\": \"Java\", \"description\":"
                + " \" Java is a class-based high-level programming language that"
                + " follows the OOPs concepts.\"},{\"name\": \"Javascript\","
                + "\"description\": \"JavaScript is also a high-level, often "
                + "just-in-time compiled, and multi-paradigm programming language."
                + "\"},{\"name\": \"Python\",\"description\": \"Python is another "
                + "high-level, interpreted and general-purpose programming language."
                + "\"}]}";

*/
        String jsonData = "{\"users\":[{\"id\":\"1\",\"name\":\"name1\",\"mail\":\"mail1@gmail.com\",\"website\":\"website1.com\",\"status\":\"1\"},{\"id\":\"2\",\"name\":\"name2\",\"mail\":\"mail2@gmail.com\",\"website\":\"website2.com\",\"status\":\"2\"},{\"id\":\"3\",\"name\":\"name3\",\"mail\":\"mail3@gmail.com\",\"website\":\"website3.com\",\"status\":\"3\"},{\"id\":\"4\",\"name\":\"name4\",\"mail\":\"mail4@gmail.com\",\"website\":\"website4.com\",\"status\":\"4\"},{\"id\":\"5\",\"name\":\"name5\",\"mail\":\"mail5@gmail.com\",\"website\":\"website5.com\",\"status\":\"5\"}," +
                "{\"id\":\"11\",\"name\":\"name11\",\"mail\":\"mail11@gmail.com\",\"website\":\"website11.com\",\"status\":\"1\"},{\"id\":\"12\",\"name\":\"name12\",\"mail\":\"mail12@gmail.com\",\"website\":\"website12.com\",\"status\":\"2\"},{\"id\":\"13\",\"name\":\"name13\",\"mail\":\"mail13@gmail.com\",\"website\":\"website13.com\",\"status\":\"3\"},{\"id\":\"14\",\"name\":\"name14\",\"mail\":\"mail14@gmail.com\",\"website\":\"website14.com\",\"status\":\"4\"},{\"id\":\"15\",\"name\":\"name15\",\"mail\":\"mail15@gmail.com\",\"website\":\"website15.com\",\"status\":\"5\"}," +
                "{\"id\":\"21\",\"name\":\"name21\",\"mail\":\"mail21@gmail.com\",\"website\":\"website21.com\",\"status\":\"1\"},{\"id\":\"22\",\"name\":\"name22\",\"mail\":\"mail22@gmail.com\",\"website\":\"website22.com\",\"status\":\"2\"},{\"id\":\"23\",\"name\":\"name23\",\"mail\":\"mail23@gmail.com\",\"website\":\"website23.com\",\"status\":\"3\"},{\"id\":\"24\",\"name\":\"name24\",\"mail\":\"mail24@gmail.com\",\"website\":\"website24.com\",\"status\":\"4\"},{\"id\":\"25\",\"name\":\"name25\",\"mail\":\"mail25@gmail.com\",\"website\":\"website25.com\",\"status\":\"5\"}]}";
        //Converting jsonData string into JSON object
        JSONObject jsnobject = new JSONObject(jsonData);
        //Printing JSON object
        System.out.println("JSON Object");
        System.out.println(jsnobject);
        //Getting languages JSON array from the JSON object
        JSONArray jsonArray = jsnobject.getJSONArray("users");
        //Printing JSON array
        System.out.println("JSON Array");
        System.out.println(jsonArray);
        //Creating an empty ArrayList of type Object
        ArrayList<Object> listdata = new ArrayList<Object>();

        //Checking whether the JSON array has some value or not
        if (jsonArray != null) {

            //Iterating JSON array
            for (int i=0;i<jsonArray.length();i++){

                //Adding each element of JSON array into ArrayList
                listdata.add(jsonArray.get(i));
            }
        }
        //Iterating ArrayList to print each element

        System.out.println("Each element of ArrayList");
        for(int i=0; i<listdata.size(); i++) {
            //Printing each element of ArrayList
            System.out.println(listdata.get(i));
        }
        return listdata;
    }

    public static void main(String[] args) {
        JSONArrayToArrayList.data();
    }

}
