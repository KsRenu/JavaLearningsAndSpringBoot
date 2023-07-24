package org.example;

import java.util.ArrayList;

public class implementationOfGenericClass {
    public static void main(String[] args) {
//        Printer<Integer> printer1 =new Printer<>(10);
//        printer1.print();
//
//        Printer<String> printer2 = new Printer<>("Hello");
//        printer2.print();
//
//        Printer<Double> printer3 = new Printer<>(108.98);
//        printer3.print();
//
//        Printer<Cat> cat = new Printer<>(new Cat());
//        cat.print();
//
//        ArrayList<Cat> cat1 = new ArrayList<>();
//        cat1.add(new Cat());

        Printer<Cat> c = new Printer<>(new Cat());
        c.print();

    }


}
