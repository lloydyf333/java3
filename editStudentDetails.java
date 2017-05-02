
import java.io.*;
import java.nio.file.*;
import java.util.*;

class editStudentDetails {

    public static boolean isName(String inputName){

        return inputName.matches("[a-zA-Z\\s]++");
    }

    public static boolean isStudentNo(String inputStudentNo){

        return inputStudentNo.matches("[C]\\d{6}");
    }

    public static boolean isCourseID(String inputCourseID){

        return inputCourseID.matches("[A-Z]{2}\\d{4}");
    }

    public static boolean isHouseNo(String inputHouseNo){

        return inputHouseNo.matches("\\d[a-zA-Z]?");
    }
    public static boolean isPostcode(String inputPostcode){

        return inputPostcode.matches("^(GIR ?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]([0-9ABEHMNPRV-Y])?)|[0-9][A-HJKPS-UW]) ?[0-9][ABD-HJLNP-UW-Z]{2})");
    }

    // add student details
    public static ArrayList<String> addStudent(ArrayList<String> studentList){

        ArrayList<String> newStudent = new ArrayList<String>(); 
        
        Scanner input = new Scanner(System.in);

        boolean accept = false;

        while(!accept){
            System.out.println("Enter name:");
            String name = input.nextLine();
            if(isName(name)){
                newStudent.add(name);
                accept = true;
            }
            else{
                System.out.println("\n\'" + name + "\' is not a valid input. Name field must be at least 1 character.\n");
            }
        }
        accept = false;
        while(!accept){
            System.out.println("\nEnter student number:");
            String studentNo = input.nextLine();
            if(isStudentNo(studentNo)){
                newStudent.add(studentNo);
                accept = true;
            }
            else{
                System.out.println("\n\'" + studentNo + "\' is not a valid input. Student Number field must be an upper case C followed by 6 digits.\n");
            }
        }
        accept = false;
        while(!accept){
            System.out.println("\nEnter Course Name:");
            String course = input.nextLine();
            if(isName(course)){
                newStudent.add(course);
                accept = true;
            }
            else{
                System.out.println("\n\'" + course + "\' is not a valid input. Course Name field must be at least 1 character.\n");
            }
        }
        accept = false;
        while(!accept){
            System.out.println("\nEnter Course ID:");
            String courseID = input.nextLine();
            if(isCourseID(courseID)){
                newStudent.add(courseID);
                accept = true;
            }
            else{
                System.out.println("\n\'" + courseID + "\' is not a valid input. Course ID field must be 2 upper case letters followed by 4 digits.\n");
            }
        }
        accept = false;
        while(!accept){
            System.out.println("\nEnter House Number:");
            String houseNo = input.nextLine();
            if(isHouseNo(houseNo)){
                newStudent.add(houseNo);
                accept = true;
            }
            else{
                System.out.println("\n\'" + houseNo + "\' is not a valid input. House Number field must be 1 or more digit followed by no more than 1 leter.\n");
            }
        }
        accept = false;
        while(!accept){
            System.out.println("\nEnter Street Name:");
            String streetName = input.nextLine();
            if(isName(streetName)){
                newStudent.add(streetName);
                accept = true;
            }
            else{
                System.out.println("\n\'" + streetName + "\' is not a valid input. Street Name field must be at least 1 character.\n");
            }
        }
        accept = false;
        while(!accept){
            System.out.println("\nEnter Town/City:");
            String town = input.nextLine();
            if(isName(town)){
                newStudent.add(town);
                accept = true;
            }
            else{
                System.out.println("\n\'" + town + "\' is not a valid input. Town/City field must be at least 1 character.\n");
            }
        }
        accept = false;
        while(!accept){
            System.out.println("\nEnter Postcode:");
            String postcode = input.nextLine();
            if(isPostcode(postcode)){
                newStudent.add(postcode);
                accept = true;
            }
            else{
                System.out.println("\n\'" + postcode + "\' is not a vaild input. Postcode field must be 2 upper case letters, 1 digit and another 2 upper case letters with no spaces.\n");
            }
        }
        String studentDataLine = "";

        for(String data: newStudent){
            studentDataLine += data + ",";
        }

        studentDataLine = studentDataLine.substring(0,(studentDataLine.length() - 1));
        
        studentList.add(studentDataLine);

        System.out.println("\n" + newStudent.get(0) + " Added!");

        return studentList;

    }
}
