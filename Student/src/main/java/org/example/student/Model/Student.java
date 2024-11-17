package org.example.student.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private String  ID;
    private String name;
    private int age;
    private double degree;
    private double GPA ;

    public Student(double GPA) {
        // Round GPA to two decimal places
        this.GPA = Math.round(GPA * 100.0) / 100.0;
    }


}
