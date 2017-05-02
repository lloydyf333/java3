import java.io.*;
import java.nio.file.*;
import java.util.*;

class searchRecords{

	public static ArrayList<String> searchAddress(ArrayList<String> studentList, String search2, String info2){
		
		ArrayList<String> matches = new ArrayList<String>();
		int count = 0;

		//System.out.println(studentList);

		for(String student: studentList){

			String[] data = student.split(",");

			String address = data[4] + " " + data[5];

		 	if(search2.equals("Address")){

		 		if(address.toLowerCase().contains(info2.toLowerCase())){

					matches.add(student);
					count += 1;
				}
			}
		}
		if(count == 0){
			System.out.println("\nNo students found matching " + "\'" + info2 + "\'");
		}
		else{
			System.out.println("\n" + count + " Students found matching " + "\'" + info2 + "\':\n");
		}

		return matches;
	}

	public static ArrayList<String> searchCourse(ArrayList<String> studentList, String search, String info){

		ArrayList<String> matches= new ArrayList<String>();
		int count = 0;

		for(String student: studentList){

			String[] data = student.split(",");



		 	if(search.equals("Course ID")){

		 		if(data[3].toLowerCase().contains(info.toLowerCase())){

					matches.add(student);
					count += 1;
				}
			}
		}
		if(count == 0){
			System.out.println("\nNo students found matching course " + "\'" + info + "\'");
		}
		else{
			System.out.println("\n" + count + " Students found matching course " + "\'" + info + "\':\n");
		}

		return matches;
	}

	public static ArrayList<String> searchSubset(ArrayList<String> studentList, int min, int max){

		ArrayList<String> subset = new ArrayList<String>();



		for(int i = (min -1); i < (max); i++){
			subset.add(studentList.get(i));
		}

		return subset;
	}

}