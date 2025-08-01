package org.example.basic.parkminji.unittwelve;

import java.util.Scanner;

public class AgeCheckApp {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int age = readAge(scanner);
            AgeChecker.validate(age);
            System.out.println("접근 허용");
        } catch (AgeException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("오류: 유효한 숫자를 입력해주세요.");
        }
    }

    private static int readAge(Scanner scanner) {
        System.out.print("나이를 입력하세요: ");
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }
}
