package org.example.basic.parkminji.uniteleven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAnalyzer {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 3, 8, 2, 9, 1, 6, 7, 4, 0);

        printMaxAndMin(numbers);
        printSortedNumbers(numbers);
    }

    private static void printMaxAndMin(List<Integer> list) {
        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println("최대값: " + max + ", 최소값: " + min);
    }

    private static void printSortedNumbers(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list); // 원본 유지
        Collections.sort(sortedList);
        System.out.println("정렬된 리스트: " + sortedList);
    }
}
