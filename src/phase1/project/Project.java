package phase1.project;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
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

class InvalidFilePathException extends Exception {
	
	public InvalidFilePathException (String s) {
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
		System.out.println("-------------------------------------------------------------");
		System.out.println();
		
//		System.out.println("\tOption 2.1: Add a file to the existing directory");
//		System.out.println("\tOption 2.2: Delete a file");
//		System.out.println("\tOption 2.3: Search a file");
//		System.out.println("\tOption 2.4: Navigate back to the main menu");
		
	}
	
	static void validateOption(int option, int max_val) throws InvalidOptionException {
		if (option < 0) {
			throw new InvalidOptionException("Cannot enter negative option");
		} else if (option == 0) {
			throw new InvalidOptionException("Cannot enter 0 as an option");
		} else if (option > max_val) {
			throw new InvalidOptionException("Enter valid option");
		}
	}
	
	public static void validateDeleteFile(String file_name, String root_dir) throws InvalidFilePathException {
		boolean check = searchFile(file_name, root_dir);
		if (!check) {
			throw new InvalidFilePathException("File not found");
		}
	}
	
	public static void option1(String root_dir) {
		File directory = new File(root_dir);
		File[] filesArray = directory.listFiles();
		
		System.out.println("\nPrinting all files in the root directory: ");
		System.out.println("------------------------------------------------");

		if (filesArray == null || filesArray.length == 0) {
			System.out.println("No files in the directory");
		} else {
			Arrays.sort(filesArray);
			int counter = 1;
			for (File file : filesArray) {
				if (file.isFile()) {
					System.out.println("File " + counter + ": " + file.getName());
					counter += 1;
				}
			}
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("\n");
	}
	
	public static boolean searchFile(String file_name, String root_dir) {
		File directory = new File(root_dir);
		File[] filesArray = directory.listFiles();

		if (filesArray == null) {
			return false;
		} else {
			Arrays.sort(filesArray);

			for (File file : filesArray) {
				if (file.isFile()) {
					if (file.getName().equals(file_name)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void displayOption2() {
		System.out.println("\nSelect one of the options below: ");
		System.out.println("------------------------------------------------");
		System.out.println("1. Add a file");
		System.out.println("2. Delete a file");
		System.out.println("3. Search for a file");
		System.out.println("4. Go back to main menu");
		System.out.print("");
	}
	
	public static void option2(Scanner sc, String root_dir) {
		int option_num = 0;
		
		while(true) {
			displayOption2();
			System.out.print("\nEnter your choice: ");
			
			try {
				option_num = Integer.valueOf(sc.next());
			} catch (Exception e) {
				System.out.println("[Error] Exception occured: Enter an integer\n");
				continue;
			}
			
			try {
				validateOption(option_num, 4);
			} catch (Exception e) {
				System.out.println("[Error] Exception occured: " + e.getMessage() + "\n");
				continue;
			}
			
			if (option_num == 4) {
				System.out.println();
				break;		
			}
			
			System.out.print("Enter the file name for the operation: ");
			sc.nextLine();
			String file_name = sc.nextLine();
			
			if (option_num == 1) {
				
				Path filePath = Paths.get(root_dir, file_name);
				File file = new File(filePath.toString());
				
				try {
					boolean result = file.createNewFile();
					
					if (result) {
						System.out.println("Successfully created the file: " + file.getCanonicalPath() + "\n");
					} else {
						System.out.println("Unable to create the file, it already exist\n");
					}
					
				} catch (Exception e) {
					System.out.println("[ERROR] Exception occured: " + e.getMessage() + "\n");
				}
			}
			
			if (option_num == 2) {
				try {
					validateDeleteFile(file_name, root_dir);
					File file = new File(Paths.get(root_dir, file_name).toString());
					
					if (file.delete()) {
						System.out.println("[SUCCESS] File deleted successfully\n");
					} else {
						System.out.println("[FAIL] Unable to delete file\n");
					}
				} catch (Exception e) {
					System.out.println("[ERROR] Exception occured: " + e.getMessage() + "\n");
				}
			}
			
			if (option_num == 3) {
				boolean check = searchFile(file_name, root_dir);
				if (check) {
					System.out.println("[SUCCESS] The file " + file_name + " exists\n");
				} else {
					System.out.println("[FAIL] The file " + file_name + " does not exist\n");
				}
				System.out.println();
			}
		}
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
				validateOption(option_num, 3);
			} catch (Exception e) {
				System.out.println("[Error] Exception occured: " + e.getMessage() + "\n");
				continue;
			}
			
			if (option_num == 1) {
				option1(root_dir);
			}
			
			if (option_num == 2) {
				option2(sc, root_dir);
			}
			
			if (option_num == 3) {
				option3();
			}
			
		}
	}

}









