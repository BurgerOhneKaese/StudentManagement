package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.Admin;
import com.example.studentmanagement.Service.AdminService;
import com.example.studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;

    public IndexController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String getIndex(Model model) {
        model.addAttribute("student", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationFormular(Model model) {
        model.addAttribute("user", new Admin());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(Admin user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        adminService.saveAdmin(user);
        return "register_success";
    }
}
