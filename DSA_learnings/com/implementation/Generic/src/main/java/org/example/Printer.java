package org.example;

//public class Printer<T> {
public class Printer<T extends Animal> {
    T thingToPrint;
    public Printer(T thingToPrint){
        this.thingToPrint=thingToPrint;
    }
    public void print(){
        thingToPrint.sound();
        System.out.println(thingToPrint);
    }

    @Override
    public String toString() {
        return "Printer{" +
                "thingToPrint=" + thingToPrint +
                '}';
    }
}
