package org.example.basic.parkminji.unitthirteen;

import java.util.Optional;

public class OptionalNullSafe {
    public static void main(String[] args) {
        String name = null;
        printSafeName(name);
    }

    private static void printSafeName(String name) {
        Optional<String> optionalName = Optional.ofNullable(name);
        String result = optionalName.orElse("기본이름");
        System.out.println("이름 출력: " + result);
    }
}
