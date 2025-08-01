package org.example.basic.parkminji.uniteight.abstractclass;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Rectangle(4, 5);
        Shape s2 = new Circle(3);

        System.out.println("사각형의 면적: " + s1.area());
        System.out.println("원의 면적: " + s2.area());
    }
}
