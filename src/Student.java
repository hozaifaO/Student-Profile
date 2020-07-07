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
    public Student(){}
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

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfUnexcusedAbscesses() {
        return numberOfUnexcusedAbscesses;
    }

    public int getStudentGraduationDate() {
        return studentGraduationDate;
    }

    public int getNumberOfExcusedAbscesses() {
        return numberOfExcusedAbscesses;

    }

    public boolean getPerfectRecord(){
        return perfectRecord;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfUnexcusedAbscesses(int numberOfUnexcusedAbscesses) {
        this.numberOfUnexcusedAbscesses = numberOfUnexcusedAbscesses;
    }

    public void setStudentGraduationDate(int studentGraduationDate) {
        this.studentGraduationDate = studentGraduationDate;
    }

    public void setNumberOfExcusedAbscesses(int numberOfExcusedAbscesses) {
        this.numberOfExcusedAbscesses = numberOfExcusedAbscesses;
    }

    public void setPerfectRecord(boolean perfectRecord) {
        this.perfectRecord = perfectRecord;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }




}
