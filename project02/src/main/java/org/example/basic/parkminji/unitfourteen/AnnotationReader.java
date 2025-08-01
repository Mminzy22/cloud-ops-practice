package org.example.basic.parkminji.unitfourteen;

import java.lang.reflect.Method;


public class AnnotationReader {

    public static void main(String[] args) {
        printTestInfo(AnnotatedClass.class, "runTest");
    }

    private static void printTestInfo(Class<?> clazz, String methodName) {
        try {
            Method method = clazz.getMethod(methodName);

            if (method.isAnnotationPresent(TestInfo.class)) {
                TestInfo info = method.getAnnotation(TestInfo.class);
                System.out.println("Author: " + info.author());
                System.out.println("Date: " + info.date());
            } else {
                System.out.println("No @TestInfo annotation present.");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found: " + methodName);
        } catch (SecurityException e) {
            System.out.println("Access to method denied.");
        }
    }
}
