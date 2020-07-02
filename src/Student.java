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

    public Student(String name,int age,double gpa, int studentGraduationDate,boolean perfectRecord,int numberOfExcusedAbscesses,int numberOfUnexcusedAbscesses)
    {
        this.name = name;
        this.age = age;
        this.GPA = gpa;
        this.numberOfExcusedAbscesses = numberOfExcusedAbscesses;
        this.numberOfUnexcusedAbscesses = numberOfUnexcusedAbscesses;
        this.studentGraduationDate = studentGraduationDate;
        this.perfectRecord = perfectRecord;
    }



}
