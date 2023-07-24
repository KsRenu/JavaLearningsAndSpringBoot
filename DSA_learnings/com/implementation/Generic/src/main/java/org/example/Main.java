package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            shout("Hello",11);

            List<Integer> intList = new ArrayList<>();
            intList.add(3);
            printList(intList);

            List<Cat> catList = new ArrayList<>();
            catList.add(new Cat());
            printList(catList);
        }
    private static <T,V> void shout(T thingToShout,V otherThingToPrint){
            System.out.println(thingToShout+"!!!!");
            System.out.println(otherThingToPrint+"!!!");
    }

    private static void printList(List<?> myList){
        System.out.println(myList);
    }
}