package org.example;

public class Car {
    private String brand;
    private String model;
    private int year;

    public void move() {
        System.out.println("자동차가 움직입니다.");
    }

    public void stop() {
        System.out.println("자동차가 멈춥니다.");
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public static void main(String[] args){
        Car myCar = new Car();
        myCar.setBrand("KIA");
        myCar.setModel("K5");
        myCar.setYear(3);

        System.out.println("브랜드: " + myCar.getBrand());
        System.out.println("모델명: " + myCar.getModel());
        System.out.println("연식: " + myCar.getYear());

        myCar.move();
        myCar.stop();

    }
}
