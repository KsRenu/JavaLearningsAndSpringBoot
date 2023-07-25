package org.example.oneParameter;

interface Check2{
    public String statement(String sentence);
}
public class LambdaExpression2 {
    public static void main(String[] args) {
        Check2 c2 = (sentence)->{ return "The statement is: \n\t"+ sentence;};
        System.out.println(c2.statement("you're so beautiful"));
    }


}
