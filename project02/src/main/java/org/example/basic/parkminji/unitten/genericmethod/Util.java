package org.example.basic.parkminji.unitten.genericmethod;

public class Util {
    public static <T> void printAll(T[] arr) {
        for (T element : arr) {
            System.out.println(element);
        }
    }
}
