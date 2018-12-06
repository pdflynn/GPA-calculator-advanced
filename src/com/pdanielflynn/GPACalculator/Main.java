package com.pdanielflynn.GPACalculator;

public class Main {

	public static void main(String[] args) {
		Display display = new Display();
		GradePoint gpa = new GradePoint(display.getFile());
		display.printResult("GPA: " + gpa.calculateGPA());
	}

}
