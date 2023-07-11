package org.example.Structure;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.ArrayList;

public class Write {
    public static ArrayList<Person> createPerson(){
        ArrayList<Person>  persons = new ArrayList<>();
        persons.add(new Intern("intern",2,"fname","lname",10,199.098,"01/01/01","01/01/01"));
        persons.add(new Employee("employee",1,"fname","lname",10,199.098,"marketing","add and mark"));
        persons.add(new Manager("manager",3,"fname","lname",10,199.098,new String[]{"name1","name2"},"sales"));

        Intern i1 = new Intern("intern",2,"fname","lname",10,199.098,"01/01/01","01/01/01");
        Employee e1 = new Employee("employee",1,"fname","lname",10,199.098,"marketing","add and mark");
        Manager m1 = new Manager("manager",3,"fname","lname",10,199.098,new String[]{"name1","name2"},"sales");

        return persons;
    }

    public static Employee createEmployee(){
        Employee e1 = new Employee("employee",1,"fname","lname",10,199.098,"marketing","add and mark");
        e1.setId(1);
        e1.setFname("fname");
        e1.setLname("lname");
        e1.setAge(10);
        e1.setAmount(1000.98);
        e1.setType("Employee");
        e1.setRole("marketting");
        e1.setDept("Sales and Advertising");
        return e1;
    }
    public static Intern createIntern(){
        Intern i1 = new Intern("intern",2,"fname","lname",10,199.098,"01/01/01","01/01/01");
        return i1;
    }
    public static Manager createManager(){
        Manager m1 = new Manager("manager",3,"fname","lname",10,199.098,new String[]{"name1","name2"},"sales");
        return m1;
    }
    public static void main(String[] args) {

        //System.out.println(persons);

        JsonObjectBuilder internBuilder = Json.createObjectBuilder();
        JsonObjectBuilder empBuilder = Json.createObjectBuilder();
        JsonObjectBuilder managerBuilder = Json.createObjectBuilder();

        Intern intern = createIntern();
        Employee emp = createEmployee();
        Manager man = createManager();


        empBuilder.add("id", emp.getId())
                .add("Fname", emp.getFname())
                .add("Lname", emp.getLname())
                .add("Age", emp.getAge())
                .add("Salary",emp.getAmount())
                .add("Type",emp.getType()).add("Role",emp.getRole())
                .add("Dept",emp.getDept());
        internBuilder.add("id", intern.getId())
                .add("Fname", intern.getFname())
                .add("Lname", intern.getLname())
                .add("Age", intern.getAge())
                .add("Salary",intern.getAmount())
                .add("Type",intern.getType())
                .add("StartDate",intern.getStartDate())
                .add("EndDate",intern.getEndDate());

        managerBuilder.add("id", man.getId())
                .add("Fname", man.getFname())
                .add("Lname", man.getLname())
                .add("Age", man.getAge())
                .add("Salary",man.getAmount())
                .add("Type",man.getType())
                .add("ReportingTeam",man.getReportingTeam())
                .add("Dept",man.getDept());

        JsonObject empJsonObject = empBuilder.build();
        JsonObject internJsonObject = internBuilder.build();
        JsonObject managerJsonObject = managerBuilder.build();

        System.out.println("Employee JSON String\n"+empJsonObject);
        System.out.println("Intern JSON String\n"+internJsonObject);
        System.out.println("Manager JSON String\n"+managerJsonObject);

    }
}
