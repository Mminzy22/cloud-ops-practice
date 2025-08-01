package org.example.basic.parkminji.unittwo;


public class Employee {
    // private 필드
    private String name;
    private double salary;
    private String department;

    // 생성자
    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 부서 변경
    public void changeDepartment(String newDepartment) {
        this.department = newDepartment;
        System.out.println(newDepartment + " 부서로 변경됨");
    }

    // 정보
    public void printEmployeeInfo() {
        System.out.println("이름: " + name);
        System.out.println("연봉: " + salary + "원");
        System.out.println("부서: " + department);
    }
}
