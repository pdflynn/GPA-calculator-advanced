package com.pdanielflynn.GPACalculator;
import java.util.*;
import java.io.*;
public class GradePoint {
	//Fields
	private File file;
	private Scanner scn;
	private HashMap<String, String> gpas = new HashMap<String, String>();
	private String[] classes;
	//Constructors
	/**
	 * Creates a new GradePoint object
	 * @param inputFile The file to get grade data from
	 */
	public GradePoint(String inputFile) 
	{
		this.file = new File(inputFile);
	}
	/**
	 * Creates a new GradePoint object from file instead
	 * of file name
	 */
	public GradePoint(File file)
	{
		this.file = file;
	}
	/**
	 * Calculates the GPA of the given file
	 * @return The GPA from the given text file
	 */
	public float calculateGPA() 
	{
		/**
		 * Ensure that a text file is available
		 */
		try 
		{
			scn = new Scanner(file);
			while (scn.hasNext()) 
			{
				gpas.put(scn.next(), scn.next());
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("File not found.");
		}
		
		//create a list of class names
		classes = gpas.keySet().toArray(new String[gpas.size()]);
		
		/*
		 * Create lists to calculate GPA
		 */
		ArrayList<String> creditsGrades = new ArrayList<String>(gpas.values());
		ArrayList<Float> credits = new ArrayList<Float>();
		ArrayList<Float> grades = new ArrayList<Float>();
		ArrayList<Float> qualityCredits = new ArrayList<Float>();
		/*
		 * Populate lists
		 */
		for (int i = 0; i < creditsGrades.size(); i++)
		{
			credits.add(Float.parseFloat(creditsGrades.get(i).substring(0, 1)));
			grades.add(Float.parseFloat(creditsGrades.get(i).substring(2, creditsGrades.get(i).length())));
			qualityCredits.add(credits.get(i)*grades.get(i));
		}
		/*
		 * Calculate credit-hour based GPA
		 */
		float sum = 0;
		float totalCredits = 0;
		for (int i = 0 ; i < qualityCredits.size(); i++)
		{
			sum += qualityCredits.get(i);
			totalCredits += credits.get(i);
		}
		
		return sum/totalCredits;
	}
	/**
	 * Get a string representation for this class's grade
	 */
	public String getGrade(String whichClass)
	{
		float epsilon = (float) 0.001;
		String output = whichClass + ": ";
		float grade = Float.parseFloat(gpas.get(whichClass).substring(gpas.get(whichClass).length() - 3));
		if (Math.abs(grade - 4.0) <= epsilon)
		{
			output += "A";
		}
		else if (Math.abs(grade - 3.7) <= epsilon)
		{
			output += "A-";
		}
		else if (Math.abs(grade - 3.3) <= epsilon)
		{
			output += "B+";
		}
		else if (Math.abs(grade - 3.0) <= epsilon)
		{
			output += "B";
		}
		else if (Math.abs(grade - 2.7) <= epsilon)
		{
			output += "B-";
		}
		else if (Math.abs(grade - 2.3) <= epsilon)
		{
			output += "C+";
		}
		else if (Math.abs(grade - 2.0) <= epsilon)
		{
			output += "C";
		}
		else if (Math.abs(grade - 1.7) <= epsilon)
		{
			output += "C-";
		}
		else if (Math.abs(grade - 1.3) <= epsilon)
		{
			output += "D+";
		}
		else if (Math.abs(grade - 1.0) <= epsilon)
		{
			output += "D";
		}
		else if (Math.abs(grade - 0.7) <= epsilon)
		{
			output += "D-";
		}
		else
		{
			output += "F";
		}
		return output;
	}
	/**
	 * Creates a list of grades for each class and returns it
	 */
	public ArrayList<String> getGradeList()
	{
		ArrayList<String> classGrades = new ArrayList<String>();
		
		for (String className : classes)
		{
			classGrades.add(this.getGrade(className));
		}
		
		return classGrades;
	}
}