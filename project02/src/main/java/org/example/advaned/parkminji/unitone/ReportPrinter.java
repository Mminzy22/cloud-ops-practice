package org.example.advaned.parkminji.unitone;

public class ReportPrinter {
    public void print(Report report) {
        System.out.println("Title: " + report.getTitle());
        System.out.println("Content: " + report.getContent());
    }
}
