package test;

import java.io.Serializable;

public class Person implements Serializable {

    int age;

    public void print() {
//        int age;
        System.out.println(age);
    }

    public static void main(String[] args) {
     new Person().print();
    }
}
