package org.example;

public class Cat extends Animal{

    String meow;

    @Override
    public String toString() {
        return "Cat{" +
                "meow='" + meow + '\'' +
                ", animal='" + animal + '\'' +
                '}';
    }
}
