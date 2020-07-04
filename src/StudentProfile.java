/*
    * StudentProfile.java
    * Created on Jun 30th 2020
    * @author: Hozaifa Owaisi <ggk4b00m@gmail.com>
*/

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentProfile {
    boolean exit;
    int indexPointer = 0;
    int numberOfOptions = 3;
    static School school = new School();
    protected static List<Student> students =new ArrayList<>();


    public static void main(String[] args) {
        StudentProfile profile = new StudentProfile();
        ObjectMapper mapper = new ObjectMapper();
        School readSchool;
        try {
            readSchool = mapper.readValue(Paths.get("school.json").toFile(), School.class);
            students = readSchool.getStudents();
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
            case 2 -> printStudentInfo(searchForStudent(school, askForStudentId()));
            case 3 -> numberOfStudentProfile();
            default -> System.out.println("An unknown error has occurred.");
        }
    }

    public int askForStudentId() {
        int id = -1;
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the Student ID: ");
            id = input.nextInt();
        } catch (NoSuchElementException | IllegalStateException e){System.out.println("\nPlease put in numbers"); e.printStackTrace();}
        return  id;
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

    public void numberOfStudentProfile() {

        System.out.println("There are a total of "+students.size()+" students in this school.");
    }

    public void printStudentInfo(Student student){
        if (student != null){
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("|Name: " + student.getName());
            System.out.println("|Age: " + student.getAge());
            System.out.println("|GPA: " + student.getGPA());
            System.out.println("|Graduation Year: " + student.getStudentGraduationDate());
            System.out.println("|Perfect Record: " + student.getPerfectRecord());
            System.out.println("|Excused Abscesses: " + student.getPerfectRecord());
            System.out.println("|Unexcused Abscesses: "+student.getNumberOfUnexcusedAbscesses());
            System.out.println("+--------------------------------------------------------------+");
        } else {
            System.out.print("\n No Student with that ID ");
        }

    }

    public Student searchForStudent(School school, int studentId){
        Student student = null;
        for(int i=0; i < school.getStudents().size();i++){

            if (studentId == school.getStudents().get(i).studentId) {
                student = school.getStudents().get(i);

            }
        }
        return student;
    }

    public void convortToJson(School school) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("school.json"), school);

    }

    public static School getSchool() {
        return school;
    }

    public static void setSchool(School school) {
        StudentProfile.school = school;
    }

}

