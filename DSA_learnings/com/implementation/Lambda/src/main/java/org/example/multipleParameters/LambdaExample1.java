package org.example.multipleParameters;

interface Check1{
    public String sentence(String var1,String var2);
}
public class LambdaExample1 {
    public static void main(String[] args) {
        Check1 c1 = (var1, var2) -> { return "The two variables are "+ var1+" " + var2;};
        System.out.println(c1.sentence("var1","var2"));

    }

}
