import java.util.*;
import java.io.*;

class saveStudentDetails{
	// save the edited information to the txt file
	public static void writeToTxt(ArrayList<String> studentList, String fileName){
		
		try{
			FileWriter saveStudents = new FileWriter(fileName);
			PrintWriter out = new PrintWriter(saveStudents);

			for(String line: studentList){
				out.println(line);
			}
			out.close();
		}
		catch(Exception e){
			System.out.print("Error: " + e);
		}
	}

	public static void writeToBinary(ArrayList<String> studentList){
		
		String totalLines = "";

		for(String line: studentList){
			totalLines += line + ";";
		}

		byte[] binaryLine = totalLines.getBytes();


		try{
			FileOutputStream saveStudents = new FileOutputStream("student.dat");
			saveStudents.write(binaryLine, 0, binaryLine.length);
			saveStudents.flush();
			saveStudents.close();
		}
		catch(Exception e){
			System.out.print("Error: " + e);
		}
	}
}