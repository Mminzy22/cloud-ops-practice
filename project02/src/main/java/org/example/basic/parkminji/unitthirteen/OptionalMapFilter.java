package org.example.basic.parkminji.unitthirteen;

import java.util.Optional;

public class OptionalMapFilter {
    public static void main(String[] args) {
        transformAndPrintName("carrot");
    }

    private static void transformAndPrintName(String input) {
        Optional.ofNullable(input)
                .filter(name -> name.startsWith("c"))
                .map(String::toUpperCase)
                .ifPresent(transformed -> System.out.println("변환된 이름: " + transformed));
    }
}
