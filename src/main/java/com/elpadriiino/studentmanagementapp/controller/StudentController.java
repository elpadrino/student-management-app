package com.elpadriiino.studentmanagementapp.controller;

import com.elpadriiino.studentmanagementapp.model.Student;

import com.elpadriiino.studentmanagementapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students/")
public class StudentController {

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    private StudentService studentService;



    @GetMapping("{id}")
    public Optional<Student> getStudent(@PathVariable(name = "id")Long id){
        return studentService.findStudentById(id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student studentToSave){
        return studentService.saveStudent(studentToSave);
    }

    @PutMapping("{id}")
    public Student updateStudent(@RequestBody Student studentToUpdate,@PathVariable(name="id")Long id){
        return studentService.updateStudent(studentToUpdate,id);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable(name = "id")Long id){
        studentService.deleteStudent(id);
    }
}
