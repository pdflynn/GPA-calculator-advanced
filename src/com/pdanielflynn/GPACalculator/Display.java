package com.pdanielflynn.GPACalculator;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.*;

public class Display {
	
	public static final int DEFAULT_FONT_SIZE = 60;
	private JFileChooser finder;
	private GridLayout layout;
	
	private JFrame frame;
	/**
	 * Creates a new Display object (default constructor)
	 */
	public Display()
	{
		this("GPA Calculator", 600, 900);
	}
	/**
	 * Creates a new Display object specified for the
	 * GPA calculator in the center of the screen
	 * @param title The title of this window
	 * @param width The width of this window
	 * @param height The height of this window
	 */
	public Display(String title, int width, int height)
	{
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		
		layout = new GridLayout(12, 1, 5, 5);
		frame.setLayout(layout);
		
		this.addUI();
		this.addFileFinder();
		
		frame.setVisible(true);
	}
	/**
	 * Adds the necessary prompt text to the screen in
	 * order for a GPA to be calculated.
	 */
	public void addUI()
	{
		JLabel promptLabel = new JLabel("Selected File:", SwingConstants.CENTER);
		promptLabel.setFont(new Font("Arial", Font.BOLD, DEFAULT_FONT_SIZE));
		promptLabel.setForeground(Color.WHITE);
		frame.add(promptLabel);
	}
	/**
	 * Print a new label in the GPA results section
	 */
	public void printResult(String text)
	{
		JLabel resultLabel = new JLabel(text, SwingConstants.CENTER);
		resultLabel.setFont(new Font("Arial", Font.BOLD, DEFAULT_FONT_SIZE));
		resultLabel.setForeground(Color.WHITE);
		frame.add(resultLabel);
		frame.revalidate();
		frame.repaint();
	}
	/**
	 * Adds the find File component
	 */
	public void addFileFinder()
	{
		JButton open = new JButton();
		finder = new JFileChooser();
		finder.setCurrentDirectory(new java.io.File("C/Users"));
		finder.setDialogTitle("Select a file.");
		finder.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (finder.showOpenDialog(open) == JFileChooser.APPROVE_OPTION)
		{
			JLabel directoryLabel = new JLabel(
					finder.getSelectedFile().getName(), SwingConstants.CENTER);
			directoryLabel.setFont(new Font("Ariel", Font.PLAIN, DEFAULT_FONT_SIZE));
			directoryLabel.setForeground(Color.LIGHT_GRAY);
			frame.add(directoryLabel);
		}
		frame.revalidate();
		frame.repaint();
	}
	/**
	 * Returns the file found by the FileFinder
	 */
	public File getFile()
	{
		File file = finder.getSelectedFile();
		if (file != null)
		{
			return file;
		}
		return null;
	}
	/**
	 * Add the classes and the reported grades in each class
	 * to the screen
	 */
	public void displayGrade(String whatToAdd) {
		JLabel classGrade = new JLabel(whatToAdd, SwingConstants.LEFT);
		classGrade.setFont(new Font("Arial", Font.BOLD, DEFAULT_FONT_SIZE / 2));
		classGrade.setForeground(Color.WHITE);
		frame.add(classGrade);
		frame.revalidate();
		frame.repaint();
	}
}
