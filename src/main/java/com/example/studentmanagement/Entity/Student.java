package com.example.studentmanagement.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "student_id_number")
    private Integer studentIdNumber;

    public Student(){}

    public Student( String firstName, String lastName, String email, Integer studentIdNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentIdNumber = studentIdNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStudentIdNumber() {
        return studentIdNumber;
    }

    public void setStudentIdNumber(Integer studentIdNumber) {
        this.studentIdNumber = studentIdNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentIdNumber=" + studentIdNumber +
                '}';
    }
}
