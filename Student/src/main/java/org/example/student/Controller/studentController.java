package org.example.student.Controller;

import org.example.student.ApiResponse.ApiResponse;
import org.example.student.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/students-system")
public class studentController {


    ArrayList<Student> students = new ArrayList<>();


    @PostMapping(path = "/add")
    public ApiResponse addStudent(@RequestBody Student student) {

        students.add(student);
        return new ApiResponse("Successfully added student");
    }


    @GetMapping(path = "/get")
    public ArrayList<Student> displayStudents() {

        return students;
    }


    @PutMapping(path = "/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {

        students.set(index, student);
        return new ApiResponse("Successfully updated student");
    }


    @DeleteMapping(path = "/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);

        return new ApiResponse("Successfully deleted student");
    }

    //End CRUD endpoints

    @GetMapping(path = "/getHonors/{index}")
    public ApiResponse honorsDegree(@PathVariable int index) {

        if(index < 0 || index >= students.size()) {
            return new ApiResponse("Student not found"); //Incorrect index
        }

        for (Student student : students) {
            if (student.getGPA() >= 4.70)
                return new ApiResponse("This student has First Honor Degree");

            else if (student.getGPA() >= 4.50 && student.getGPA() < 4.70)
                return new ApiResponse("This student has Second Honor Degree");

            else {
                return new ApiResponse("This student doesn't have Honor Degree");
            }
        }//End for

        return new ApiResponse("Student not found");
    }


    @GetMapping(path = "/displayBasedGPA")
    public ArrayList<Student> displayBasedAvgGPA() {

        double sumGPA = 0.0;

        for (Student student : students) {
            sumGPA += student.getGPA();      //First, compute the avg
        }
        double avgGPA = sumGPA / students.size();

        ArrayList<Student> studentsBasedOnGPA = new ArrayList<>(); //new arr to store these students

        for (Student student : students) {
            if (student.getGPA() >= avgGPA)
                studentsBasedOnGPA.add(student);
        }

        return studentsBasedOnGPA;

    }


//• Display a group of students whose GPA is greater than the average
//    GPA.


}  //End controller
