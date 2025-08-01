package org.example.basic.parkminji.unittwelve;

public class StringToIntegerApp {

    public static void main(String[] args) {
        String input = "abc123";
        convertAndPrint(input);
    }

    private static void convertAndPrint(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            System.out.println("변환된 숫자: " + number);
        } catch (NumberFormatException e) {
            System.out.printf("숫자로 변환할 수 없는 입력입니다: %s", input);
        }
    }
}
