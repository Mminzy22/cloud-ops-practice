package org.example.advaned.parkminji.unitone;

public class Main {
    public static void main(String[] args) {
        Report report = new Report("보고서", "보고서 내용~");

        ReportPrinter printer = new ReportPrinter();
        printer.print(report);

        ReportSaver saver = new ReportSaver();
        saver.saveToFile(report, "report.txt");
    }
}
