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

    // 기본 생성자
    public Car(){
        System.out.println("자동차 객체가 생성되었습니다.");
    }

    // 사용자 정의 생성자
    public Car(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public static void main(String[] args){
        Car myCar = new Car();
        Car myCar1 = new Car("기아", "K9", 2020);
        myCar.setBrand("KIA");
        myCar.setModel("K5");
        myCar.setYear(2023);

        System.out.println("브랜드: " + myCar.getBrand());
        System.out.println("모델명: " + myCar.getModel());
        System.out.println("연식: " + myCar.getYear());
        System.out.println();

        System.out.println("브랜드: " + myCar1.getBrand());
        System.out.println("모델명: " + myCar1.getModel());
        System.out.println("연식: " + myCar1.getYear());
        System.out.println();

        myCar.move();
        myCar.stop();

    }
}
