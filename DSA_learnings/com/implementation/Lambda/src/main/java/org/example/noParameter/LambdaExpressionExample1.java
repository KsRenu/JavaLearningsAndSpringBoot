package org.example.noParameter;

@FunctionalInterface
interface Inter{
    void inter();
}
public class LambdaExpressionExample1 {
    public static void main(String[] args) {
        Inter i1 = ()->{
            System.out.println("Inside inter");
        };
        i1.inter();
    }
}
