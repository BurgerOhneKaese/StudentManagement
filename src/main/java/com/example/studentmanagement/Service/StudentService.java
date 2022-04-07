package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.Student;
import com.example.studentmanagement.Exception.ApiRequestException;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService{
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
       return studentRepository.save(student);
    }

    public Student getStudentByID(@PathVariable Integer id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            return student.get();
        }
        throw new ApiRequestException("Student nicht vorhanden");
    }
    
    public void deleteStudent(Integer id){
         studentRepository.deleteById(id);
    }

    public List<Student> findStudent(String name){
        if(studentRepository.findByFirstName(name) != null) {
            return studentRepository.findByFirstName(name);
        }
       throw new ApiRequestException("Student nicht vorhanden");
    }


}
