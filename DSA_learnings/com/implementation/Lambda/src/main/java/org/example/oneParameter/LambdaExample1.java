package org.example.oneParameter;

interface Check{
    public String getName(String name);
}
public class LambdaExample1 {
    public static void main(String[] args) {
        Check c1 = (name)->{ return "Hello "+ name;};
        System.out.println(c1.getName("Name "));
    }
}
