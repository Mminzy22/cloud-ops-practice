package org.example;

public class Calculate {

    // 덧셈
    public int add(int a, int b){
        return a + b;
    }

    // 뺼셈
    public int subtract(int a, int b){
        return a - b;
    }

    // 곱셈
    public int multiply(int a, int b){
        return a * b;
    }

    // 나눗셈
    public int divide(int a, int b){
        if (b == 0) {
            System.out.println("0으로 나누기 불가");
            return -1;
        }
        return a / b;
    }


    public static void main(String[] args) {
        Calculate calc = new Calculate();

        int a = 10;
        int b = 5;

        System.out.println("덧셈: " + calc.add(a, b));
        System.out.println("뺄셈: " + calc.subtract(a, b));
        System.out.println("곱셈: " + calc.multiply(a, b));
        System.out.println("나눗셈: " + calc.divide(a, b));
    }
}
