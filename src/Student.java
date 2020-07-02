/*
    * StudentProfile.java
    * Created on Jun 30th 2020
    * @author: Hozaifa Owaisi <ggk4b00m@gmail.com>
 */

public class Student {
    String name;
    int age;
    double GPA;
    int numberOfUnexcusedAbscesses;
    int studentGraduationDate;
    boolean perfectRecord;
    int numberOfExcusedAbscesses;
    int studentId;

    public Student(String name,int age,double gpa, int studentGraduationDate,boolean perfectRecord,int numberOfExcusedAbscesses,int numberOfUnexcusedAbscesses, int studentId)
    {
        this.name = name;
        this.age = age;
        this.GPA = gpa;
        this.numberOfExcusedAbscesses = numberOfExcusedAbscesses;
        this.numberOfUnexcusedAbscesses = numberOfUnexcusedAbscesses;
        this.studentGraduationDate = studentGraduationDate;
        this.perfectRecord = perfectRecord;
        this.studentId = studentId;
    }



}
