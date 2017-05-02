import java.io.*;
import java.nio.file.*;
import java.util.*;

class deleteStudentDetails {
	public static ArrayList<String> deleteStudent(ArrayList<String> studentList){

		Scanner deleteStudent = new Scanner(System.in);
		System.out.println("");

		for(int i = 0; i < (studentList.size()); i++){
			String[] data = studentList.get(i).split(",");
			System.out.println((i + 1) + ": " + data[0] + ", " + data[1]); 
		}
		System.out.println("\nSelect a student to delete or enter 0 to return to main menu:");

		try{
			int toDelete = deleteStudent.nextInt();
			if(toDelete == 0){
				return studentList;
			}
			else{
				toDelete -= 1;
				String[] deletedStudent = studentList.get(toDelete).split(",");
				
				System.out.println("\nAre you sure you want to delete \'" + deletedStudent[0] + "\'?");
				System.out.println("1: Yes");
				System.out.println("2: No");
				System.out.println("0: Exit to main menu\n");

				int selection = deleteStudent.nextInt();
				
				switch(selection){
					case 1: 
					studentList.remove(toDelete);
					System.out.println("\nStudent \'" + deletedStudent[0] + "\' has been deleted.");
					return studentList;

					case 2:
					deleteStudent(studentList);
					break;
				}
			}
		}
		catch(InputMismatchException error1){
			System.out.println("\nERROR: Invalid input\n");
			deleteStudent(studentList);
		}
		catch(IndexOutOfBoundsException error2){
			System.out.println("\nError: Student selection was out of range, returning to main menu.");
		}

		return studentList;
	}

}