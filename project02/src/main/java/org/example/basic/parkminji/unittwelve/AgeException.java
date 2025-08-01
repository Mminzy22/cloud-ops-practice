package org.example.basic.parkminji.unittwelve;

public class AgeException extends Exception {
    private final int age;

    public AgeException(int age) {
        super("접근 불가: 19세 미만입니다. 입력 나이: " + age);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
