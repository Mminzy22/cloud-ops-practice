package org.example.basic.parkminji.unittwelve;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numerator = readInt(scanner, "첫 번째 숫자: ");
            int denominator = readInt(scanner, "두 번째 숫자: ");
            int result = divide(numerator, denominator);
            System.out.println("결과: " + result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력해주세요.");
        } catch (InputMismatchException e) {
            System.out.println("숫자 형식이 잘못되었습니다.");
        } finally {
            System.out.println("프로그램 종료");
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return Integer.parseInt(input.trim());
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}
