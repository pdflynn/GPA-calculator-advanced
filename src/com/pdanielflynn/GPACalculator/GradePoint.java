package com.pdanielflynn.GPACalculator;
import java.util.*;
import java.io.*;
public class GradePoint {
	//Fields
	private File file;
	private Scanner scn;
	private HashMap<String, String> gpas = new HashMap<String, String>();
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
		/*
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
}
