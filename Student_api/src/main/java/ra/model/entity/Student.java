package ra.model.entity;

import javax.persistence.*;

@Entity

@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentID")
    private int studentID;
    @Column(name = "studentName")
    private String studentName;
    @Column(name = "age")
    private int age;
    @Column(name = "studentStatus")
    private boolean studentStatus;

    public Student(int studentID, String studentName, int age, boolean studentStatus) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.age = age;
        this.studentStatus = studentStatus;
    }

    public Student() {

    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }
}
