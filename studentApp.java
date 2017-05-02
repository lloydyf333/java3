import java.util.*;
import java.io.*;
import java.nio.*;
import java.io.IOException;

public class studentApp{
	
	public static ArrayList<String> studentList = new ArrayList<String>();

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		// Print start menu and input filename
        System.out.println("============================================");
		System.out.println("|        Welcome to my application         |");
		System.out.println("============================================");
        System.out.println("\nPlease enter name of existing file, or name of the new file you want to create\n");
        System.out.println("Enter File Name:\n");
        // name of file taken from scanner entry 
        String fileInput = input.nextLine();
        File fileName = new File(fileInput);
        // check to see if file entry exists 
        if (fileName.exists()) {
        	
        	System.out.println("\nFile identified, reading data...");
        	// if file matches txt file
        	if (fileInput.matches(".*\\.txt$")) {
        		// read txt file
        		try{

        			String line;

        			BufferedReader rdr = new BufferedReader(new FileReader(fileName));

					while((line = rdr.readLine()) != null){
						studentList.add(line);
        		}

        		System.out.println("\nFile loaded, now using file : " + fileName);
				
        	}
        	// catch error for file not being found
        	catch (FileNotFoundException e) {
        		System.out.println("ERROR: " + e);
        		System.exit(0);
        	}
        	// catch error for IOException
        	catch(IOException e){

				System.out.println("ERROR: " + e);
				System.exit(0);

        }
    	}
    	// read binary file
        else {
        	int length = (int) fileName.length();

				byte[] data = new byte[length];
				try{
					FileInputStream fis = new FileInputStream(fileName);
					fis.read(data, 0, data.length);
					fis.close();

					String allStudents = new String(data);

					String[] students = allStudents.split(";");

					for(int i = 0; i < students.length; i++){
						studentList.add(students[i]);
					}

					System.out.println("\nFile loaded, now using file : " + fileName);

        }
        // catch error exception
        catch (Exception e) {

        	System.out.println("ERROR: " + e);

        }
	}
	}
	// if file does not exist...
	else {
        // create new file
		try{

			fileName.createNewFile();

			System.out.println("File not found, creating new file...");
            System.out.println("Created" + fileName);
		}
		// catch error exception
        catch (Exception e) {

        	System.out.println("\nERROR: Could not create file" + e);
        }

	}
	// integer choice for cases in menu
	int choice = -1;
	// Main menu
	do{
		System.out.println("\n------ Main Menu ------\n");
        System.out.println("1: Display Student Details");
        System.out.println("2: Add Student Details");
        System.out.println("3: Delete Student Details");
        System.out.println("4: Search Coursename");
        System.out.println("5: Search Address");
        System.out.println("6: Search Subset");
        System.out.println("0: Exit\n");

        System.out.println("\nEnter a number to select an option: ");
        // choice is set as the input from the scanner module 
        try{
        	choice = input.nextInt();
        }
        // catch error exception
        catch (Exception e) {
        	System.out.println("ERROR: Entry not valid");
        }

        switch(choice){
        	//default msg
        	default:
        		System.out.println("ERROR: Invalid input");
        	break;
        	//Exit case	
        	case 0:
				if(fileInput.matches(".*\\.txt$")){
					saveStudentDetails.writeToTxt(studentList, fileInput);
				}
				else{
					saveStudentDetails.writeToBinary(studentList);
				}
				System.out.println("\nChanges to students saved.");
				System.out.println("Exiting Program.");
				break;
			// cases for other options in main menu	
			case 1:
				System.out.println("\nAll student details:\n");
				readStudentDetails.displayAll(studentList);		
				break;
			case 2:
				System.out.println("\nAdd new student details:\n");
				studentList = editStudentDetails.addStudent(studentList);
				break;
			case 3:
				System.out.println("\nDelete student details\n");
				studentList = deleteStudentDetails.deleteStudent(studentList);
				break;	
			case 4:
				Scanner input2 = new Scanner(System.in);
				System.out.println("\nEnter Course ID to search for: ");
				String info = input2.nextLine();
				readStudentDetails.displayAll(searchRecords.searchCourse(studentList, "Course ID", info));
				break;
			case 5: 
				Scanner in = new Scanner(System.in);
				System.out.println("\nEnter address to search for: ");
				String info2 = in.nextLine();
				readStudentDetails.displayAll(searchRecords.searchAddress(studentList, "Address", info2));
				break;	
			case 6:
				Scanner in2 = new Scanner(System.in);
				System.out.println("\nShow students in range\nSystem contains " + studentList.size() + " students.");	
				try{	
					System.out.println("Please enter lower bound of subset:");
					int min = in2.nextInt();
					System.out.println("\nPlease enter upper bound of subset:");
					int max = in2.nextInt();
					if(min > max){
						System.out.println("\nERROR: Please make sure upper bound is greater than or equal to lower bound.");
					}
					else{
						System.out.println("\nShowing students " + min + "-" + max + ":\n");
						readStudentDetails.displayAll(searchRecords.searchSubset(studentList, min, max));
					}
				}
				// error Execptions
				catch(InputMismatchException e){
					System.out.println("\nERROR: " + e + " Incorrect input type. Please enter an integer.");
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("\nError: " + e + " Input out of range, please enter a number between 1 and " + studentList.size());
				}
				break;
        }
	}while (choice != 7 && choice != 0); // while loop for choices

}
}




