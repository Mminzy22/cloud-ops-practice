package org.example.basic.parkminji.unitsix;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaEx05 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three");

        Function<String, Integer> lengthFunction = s -> s.length();

        list.stream()
                .map(lengthFunction)
                .forEach(System.out::println); // 결과: 3, 3, 5
    }
}
