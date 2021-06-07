package phase1.project;

import java.util.Scanner;

class InvalidOptionException extends Exception {
	
	public InvalidOptionException (String s) {
		super(s);
	}
	
}

public class Project {
	
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
	
	public static void option1() {
		System.out.println("Entered option 1: TODO\n");
	}
	
	public static void option2() {
		System.out.println("Entered option 2: TODO\n");
	}
	
	public static void option3() {
		System.out.println("Entered option 3: TODO\n");
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("----------------------------LockedMe.com----------------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n");
		
		System.out.println("Developer - Raghav Gupta, Full stack developer");
		System.out.println("\n\n");
		
		
		int option_num = 0;
		Scanner sc = new Scanner(System.in);
		
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
				option1();
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









