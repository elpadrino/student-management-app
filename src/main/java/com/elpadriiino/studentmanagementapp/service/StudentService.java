package com.elpadriiino.studentmanagementapp.service;

import com.elpadriiino.studentmanagementapp.model.Student;
import com.elpadriiino.studentmanagementapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final  StudentRepository studentRepository;

    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    public Student saveStudent(Student student){
        LOG.info("Student details Saved.");
        return studentRepository.save(student);

    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();

    }

    public Optional<Student> findStudentById(Long id){
        LOG.info("Getting Student with given ID: " + id);
        return studentRepository.findById(id);
    }

    public Student updateStudent(Student studentToUpdate, Long id){
        Optional<Student> studentFound = studentRepository.findById(id);
        try{
              Student studentFoundAndGot = studentFound.get();

              studentFoundAndGot.setFirstName(studentToUpdate.getFirstName());
              studentFoundAndGot.setLastName(studentToUpdate.getLastName());
              studentFoundAndGot.setAge(studentToUpdate.getAge());
              studentFoundAndGot.setDob(studentToUpdate.getDob());
              studentFoundAndGot.setAddress(studentToUpdate.getAddress());
              studentFoundAndGot.setEmail(studentToUpdate.getEmail());

              return studentRepository.save(studentFoundAndGot);

        }
        catch(Exception e){
            LOG.error("Error Updating Student " +e.getMessage());
        }

        return studentToUpdate;
    }

    public void deleteStudent(Long id){
        try{
              studentRepository.deleteById(id);
        }
        catch(Exception e){
            LOG.error("Error Deleting Student with ID: " + id + e.getMessage());
        }
    }



}
