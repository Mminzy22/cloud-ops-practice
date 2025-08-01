package org.example.basic.parkminji.unitsix;

public class LambdaEx01 {
    public static void main(String[] args) {
        // 기존 방식
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Thread 1 실행");
            }
        };

        // Lambda 방식
        Runnable r2 = () -> System.out.println("Thread 2 실행");

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
