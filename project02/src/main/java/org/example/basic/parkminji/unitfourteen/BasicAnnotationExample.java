package org.example.basic.parkminji.unitfourteen;


public class BasicAnnotationExample {

    @Deprecated
    public void oldMethod() {
        System.out.println("This method is deprecated.");
    }

    @Override
    public String toString() {
        return "BasicAnnotationExample";
    }

    public static void main(String[] args) {
        BasicAnnotationExample example = new BasicAnnotationExample();
        example.oldMethod();
        System.out.println(example);
    }
}
