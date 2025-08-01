package org.example.basic.parkminji.unittwelve;

public class AgeChecker {
    public static void validate(int age) throws AgeException {
        if (age < 19) {
            throw new AgeException(age);
        }
    }
}
