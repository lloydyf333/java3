import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class readStudentDetails {

    public static void displayAll(ArrayList<String> studentList){

        if (studentList.size() == 0) {
            
            System.out.println("\nThere is no student enteries to display.");
            return;
        }

        else{

            for (int i = 0; i < studentList.size(); i++ ) {
                
                String[] data = studentList.get(i).split(",");

                System.out.println("Student Name: " + data[0]);
                System.out.println("Student Number: " + data[1]);
                System.out.println("Subject: " + data[2]);
                System.out.println("Course ID: " + data[3]);
                System.out.println("Address: " + data[4] + " " + data[5]);
                System.out.println("Town/City: " + data[6]);
                System.out.println("Postal Code: " + data[7] + "\n");
            }
        }
    }



}