package org.example.oneParameter;

interface Check3{
    public String sayHey(String name);
}
public class LambdaExample3 {
    public static void main(String[] args) {
        Check3 c3 = (name)->{ return "Hey "+ name;};
        System.out.println(c3.sayHey("you!!!"));
    }



}
