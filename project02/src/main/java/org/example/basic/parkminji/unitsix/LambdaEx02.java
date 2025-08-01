package org.example.basic.parkminji.unitsix;

import java.util.Arrays;
import java.util.List;

public class LambdaEx02 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kim", "Lee", "Park", "Choi");

        // Lambda를 이용한 문자열 길이 기준 정렬
        names.sort((a, b) -> a.length() - b.length());

        names.forEach(System.out::println);  // 메서드 참조 방식
    }
}
