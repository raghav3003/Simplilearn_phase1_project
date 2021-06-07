package phase1.project;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

class InvalidOptionException extends Exception {
	
	public InvalidOptionException (String s) {
		super(s);
	}
	
}

public class Project {
	
	public static boolean validateRootDir(String root_dir) {
		return Files.isDirectory(Paths.get(root_dir));
	}
	
	public static void displayOptions() {
		
		System.out.println("1. Print all files in the directory in ascending order");
		System.out.println("2. Create, delete or search a file");
		System.out.println("3. Close the application");
		System.out.println();
		
//		System.out.println("\tOption 2.1: Add a file to the existing directory");
//		System.out.println("\tOption 2.2: Delete a file");
//		System.out.println("\tOption 2.3: Search a file");
//		System.out.println("\tOption 2.4: Navigate back to the main menu");
		
	}
	
	static void validateOption(int option) throws InvalidOptionException {
		if (option < 0) {
			throw new InvalidOptionException("Cannot enter negative option");
		} else if (option == 0) {
			throw new InvalidOptionException("Cannot enter 0 as an option");
		} else if (option > 3) {
			throw new InvalidOptionException("Enter valid option");
		}
	}
	
	public static void option1(String root_dir) {
		File directory = new File(root_dir);
		File[] filesArray = directory.listFiles();
		
		System.out.println("\nPrinting all files in the root directory: ");
		System.out.println("------------------------------------------------");
		
		Arrays.sort(filesArray);
		int counter = 1;
		for (File file : filesArray) {
			if (file.isFile()) {
				System.out.println("File " + counter + ": " + file.getName());
				counter += 1;
			}
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("\n");
	}
	
	public static void option2() {
		System.out.println("Entered option 2: TODO\n");
	}
	
	public static void option3() {
		System.out.println("Thank you for using the application. Exiting");
		System.exit(0);
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("----------------------------LockedMe.com----------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n");
		
		System.out.println("Developer - Raghav Gupta, Full stack developer");
		System.out.println("\n");
		

		int option_num = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the root directory for all future operations: ");
		String root_dir = sc.nextLine();
		
		while (!validateRootDir(root_dir)) {
			System.out.println("[ERROR] Directory does not exist, enter another directory\n");
			System.out.print("Enter the root directory for all future operations: ");
			root_dir = sc.nextLine();
		}
		
		System.out.println();
		
		while (true) {
			
			displayOptions();
			System.out.print("Enter your choice: ");
			
			try {
				option_num = Integer.valueOf(sc.next());
			} catch (Exception e) {
				System.out.println("[Error] Exception occured: Enter an integer\n");
				continue;
			}
			
			try {
				validateOption(option_num);
			} catch (Exception e) {
				System.out.println("[Error] Exception occured: " + e.getMessage() + "\n");
				continue;
			}
			
			if (option_num == 1) {
				option1(root_dir);
			}
			
			if (option_num == 2) {
				option2();
			}
			
			if (option_num == 3) {
				option3();
			}
			
		}
	}

}









