package org.example.multipleParameters;

interface Check2{
    public int add(int n1, int n2);
}
public class LambdaExample2 {
    public static void main(String[] args) {
        Check2 c2 = (n1,n2)->{return n1+n2; };

        System.out.println(c2.add(2,3));
    }


}
