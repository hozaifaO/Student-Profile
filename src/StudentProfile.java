/*
    * StudentProfile.java
    * Created on Jun 30th 2020
    * @author: Hozaifa Owaisi <ggk4b00m@gmail.com>
*/

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentProfile {
    boolean exit;
    int indexPointer = 0;
    int numberOfOptions = 3;
    static School school= new School();
    protected List<Student> students =new ArrayList<>();


    public static void main(String[] args) {
        StudentProfile profile = new StudentProfile();
        try {
            profile.runMenu(school);
            profile.convortToJson(school);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public School runMenu(School school) {
        printHeader();
        //school= new School();
        while (!exit) {
            indexPointer= indexPointer +1;
            printMenu();
            int choice = getInput();
            performAaction(choice, school);
        }
        return school;
    }

    public void printHeader() {
        System.out.println("+----------------------------------------+");
        System.out.println("|        Welcome to Student Profile      |");
        System.out.println("|           by Hozaifa Owaisi            |");
        System.out.println("+----------------------------------------+");
    }

    public void printMenu() {
        System.out.println("\nPlease Make a Selection: ");
        System.out.println("1) Create a Student Profile");
        System.out.println("2) Check an Existing Profile");
        System.out.println("3) Number of Students in this school");
        System.out.println("0) Exit");
    }

   public int getInput() {
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > numberOfOptions) {
            try {
                System.out.print("\nEnter Your Choice: ");
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Selection please try again.");
            }
        }
        return choice;
    }

    public void performAaction(int choice, School school) {
        switch (choice) {
            case 0 -> {
                exit = true;
                System.out.println("Thank You for using this Application.");
            }
            case 1 -> createStudentProfile(school);
            case 2 -> searchForStudent();
            case 3 -> numberOfStudentProfile(school);
            default -> System.out.println("An unknown error has occurred.");
        }
    }

    public void createStudentProfile(School school){
        String name = "";
        int age = 0;
        double gpa = 0.0;
        boolean record = true;
        int excusedAbsc = 0;
        int unExcusedAbsc = 0;
        int date = 2024;
        int studentId = 0;
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Student Name: ");
            name = input.nextLine();

        } catch (NoSuchElementException | IllegalStateException e){System.out.println("Error");}
        try {
            System.out.print("Student Age: ");
            age = input.nextInt();

        } catch(NoSuchElementException | IllegalStateException e){ System.out.println("Invalid Input"); }
        try {
            System.out.print("Student GPA: ");
            gpa = input.nextDouble();

        } catch(NoSuchElementException | IllegalStateException e){ System.out.println("Invalid Input"); }
        try {
            System.out.print("Student Has a perfect record (true, false): ");
            record = input.nextBoolean();

        } catch(NoSuchElementException | IllegalStateException e){ System.out.println("Invalid Input"); }
        try {
            System.out.print("Number of Excused Abscesses: ");
            excusedAbsc = input.nextInt();

        } catch(NoSuchElementException | IllegalStateException e){ System.out.println("Invalid Input"); }
        try {
            System.out.print("Number of Unexcused Abscesses: ");
            unExcusedAbsc = input.nextInt();

        } catch(NoSuchElementException | IllegalStateException e){ System.out.println("Invalid Input"); }
        try {
            System.out.print("Student Graduation Year: ");
            date = input.nextInt();

        } catch(NoSuchElementException | IllegalStateException e){ System.out.println("Invalid Input"); }
        try {
            System.out.print("Student ID: ");
            studentId = input.nextInt();
        } catch(NoSuchElementException | IllegalStateException e){ System.out.println("Invalid Input"); }

        Student student = new Student(name,age,gpa, date,record,excusedAbsc,unExcusedAbsc,studentId);
        students.add(student);
        school.setStudents(students);
        //saveStudentData(students);
    }

    public void numberOfStudentProfile(School school) {

        System.out.println("There are a total of "+school.numberOfStudentsInSchool()+" students in this school.");
    }

    public void printStudentInfo(School school , int index){
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|Name: " + school.getStudents().get(index).getName());
        System.out.println("|Age: " + school.getStudents().get(index).getAge());
        System.out.println("|GPA: " + school.getStudents().get(index).getGPA());
        System.out.println("|Graduation Year: " + school.getStudents().get(index).getStudentGraduationDate());
        System.out.println("|Perfect Record: " + school.getStudents().get(index).getPerfectRecord());
        System.out.println("|Excused Abscesses: " + school.getStudents().get(index).getPerfectRecord());
        System.out.println("|Unexcused Abscesses: "+school.getStudents().get(index).getNumberOfUnexcusedAbscesses());
        System.out.println("+--------------------------------------------------------------+");
    }
    public void searchForStudent(){

    }

    public void convortToJson(School school) throws JsonGenerationException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        //String jsonStr = mapper.writeValueAsString(school);
        mapper.writeValue(new File("school.json"), school);

    }

}

