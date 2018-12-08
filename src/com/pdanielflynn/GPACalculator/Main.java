package com.pdanielflynn.GPACalculator;

public class Main {

	public static void main(String[] args) {
		Display display = new Display();
		GradePoint gpa = new GradePoint(display.getFile());
		display.printResult("GPA: " + gpa.calculateGPA());
		
		System.out.println(gpa.getGrade("CHEM1035"));
		System.out.println(gpa.getGrade("CHEM1045"));
		System.out.println(gpa.getGrade("CS1114"));
		System.out.println(gpa.getGrade("ENGE1215"));
		System.out.println(gpa.getGrade("HIST1024"));
		System.out.println(gpa.getGrade("MATH2204"));
		System.out.println(gpa.getGrade("MUS3314"));
	}

}
