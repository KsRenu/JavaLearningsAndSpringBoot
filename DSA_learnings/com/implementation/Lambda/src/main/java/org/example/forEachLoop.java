package org.example;

import java.util.ArrayList;

public class forEachLoop {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);

        a1.forEach(
                (n)-> System.out.println(n)
                //System.out::println
        );

    }

}
