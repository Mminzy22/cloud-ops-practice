package org.example.basic.parkminji.unitthirteen;

public class NullPointerExample {
    public static void main(String[] args) {
        String name = null;
        printNameLength(name); // NPE 발생
    }

    private static void printNameLength(String name) {
        System.out.println("이름 길이: " + name.length());
    }
}
