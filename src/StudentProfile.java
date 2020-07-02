/*
    * StudentProfile.java
    * Created on Jun 30th 2020
    * @author: Hozaifa Owaisi <ggk4b00m@gmail.com>
*/

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class StudentProfile {
    boolean exit;
    int numberOfOptions = 3;
    protected List<Student> students = new ArrayList<Student>();
    School school = new School();
    public static void main(String[] args) {
        StudentProfile profile = new StudentProfile();
        profile.runMenu();
    }

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAaction(choice);
        }
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

    public void performAaction(int choice) {
        switch (choice) {
            case 0 -> {
                exit = true;
                System.out.println("Thank You for using this Application.");
            }
            case 1 -> printStudentInfo(createStudentProfile());
            case 2 -> searchForStudent();
            case 3 -> numberOfStudentProfile();
            default -> System.out.println("An unknown error has occurred.");
        }
    }

    public Student createStudentProfile(){
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
        saveStudentData(students);
        return student;
    }

    public void numberOfStudentProfile() {

        System.out.println("There are a total of "+school.numberOfStudentsInSchool()+" students in this school.");
    }

    public void printStudentInfo(Student student){
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|Name: " + student.name);
        System.out.println("|Age: " + student.age);
        System.out.println("|GPA: " +student.GPA);
        System.out.println("|Graduation Year: " + student.studentGraduationDate);
        System.out.println("|Perfect Record: " + student.perfectRecord);
        System.out.println("|Excused Abscesses: " + student.numberOfExcusedAbscesses);
        System.out.println("|Unexcused Abscesses: "+student.numberOfUnexcusedAbscesses);
        System.out.println("+--------------------------------------------------------------+");
    }

    public void saveStudentData(List<Student> students) {
        school.setStudents(students);

    }
    public void searchForStudent(){

    }



}

