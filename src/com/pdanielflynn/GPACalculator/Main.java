package com.pdanielflynn.GPACalculator;

public class Main {

	public static void main(String[] args) {
		Display display = new Display();
		GradePoint gpa = new GradePoint(display.getFile());
		display.printResult("GPA: " + gpa.calculateGPA());
		
		
		for (int i = 0; i < gpa.getGradeList().size(); i++)
		{
			System.out.println(gpa.getGradeList().get(i));
			display.displayGrade(gpa.getGradeList().get(i));
		}
	}

}
