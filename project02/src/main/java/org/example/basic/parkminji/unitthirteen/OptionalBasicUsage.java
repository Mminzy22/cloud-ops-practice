package org.example.basic.parkminji.unitthirteen;

import java.util.Optional;

public class OptionalBasicUsage {
    public static void main(String[] args) {
        printOptionalInfo(Optional.of("Carrot"));
    }

    private static void printOptionalInfo(Optional<String> optionalName) {
        System.out.println("값 존재 여부: " + optionalName.isPresent());
        optionalName.ifPresent(name -> System.out.println("값: " + name));
        System.out.println("기본값 또는 실제 값: " + optionalName.orElse("Default"));
    }
}
