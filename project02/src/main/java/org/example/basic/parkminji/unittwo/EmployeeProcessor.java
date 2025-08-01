package org.example.basic.parkminji.unittwo;

import java.util.Scanner;


public class EmployeeProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 직원 정보 입력
        System.out.print("이름 입력: ");
        String name = sc.nextLine();

        System.out.print("연봉 입력: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("부서 입력: ");
        String department = sc.nextLine();

        // Employee 객체 생성
        Employee emp = new Employee(name, salary, department);
        System.out.println("\n직원 추가 완료");
        emp.printEmployeeInfo();

        // 부서 변경
        while (true) {
            System.out.println("\n[메뉴]");
            System.out.println("1. 부서 변경");
            System.out.println("2. 직원 정보 보기");
            System.out.println("3. 종료");
            System.out.print("선택 >> ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("변경할 부서 입력: ");
                    String newDept = sc.nextLine();
                    emp.changeDepartment(newDept);
                    break;
                case 2:
                    emp.printEmployeeInfo();
                    break;
                case 3:
                    System.out.println("프로그램 종료");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 선택으로 다시 선택 필요함");
            }
        }
    }
}
