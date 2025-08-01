package org.example.basic.parkminji.unitthirteen;

public class SafeNullHandler {
    private static final String DEFAULT_NAME_MESSAGE = "이름이 null입니다.";

    public static void main(String[] args) {
        String name = null;
        printNameLengthSafely(name);
    }

    private static void printNameLengthSafely(String name) {
        if (name != null) {
            System.out.println("이름 길이: " + name.length());
        } else {
            System.out.println(DEFAULT_NAME_MESSAGE);
        }
    }
}
