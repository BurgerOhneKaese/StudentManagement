package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.Admin;
import com.example.studentmanagement.Entity.Student;
import com.example.studentmanagement.Exception.ApiRequestException;
import com.example.studentmanagement.Service.AdminService;
import com.example.studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/workbench")
public class StudentController {
    @Autowired
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudents(Model model){

            model.addAttribute("student", studentService.getAllStudents());

        return "student_workbench";
    }

    @GetMapping("/new")
    public String getNewStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }
    @PostMapping()
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/workbench";
    }

    @GetMapping("/edit/{id}")
    public String getEditStdID(@PathVariable Integer id, Model model){
        model.addAttribute("student", studentService.getStudentByID(id));
        return "edit_student";
    }

    @PostMapping("/{id}")
    public String saveEditStudent(@PathVariable Integer id,
                                   @ModelAttribute ("student") Student student){
        Student stdID = studentService.getStudentByID(id);
        stdID.setFirstName(student.getFirstName());
        stdID.setLastName(student.getLastName());
        stdID.setEmail(student.getEmail());
        studentService.saveStudent(stdID);
        return "redirect:/workbench";
    }
    @GetMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "redirect:/workbench";
    }


}


