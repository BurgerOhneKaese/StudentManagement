package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    StudentService studentService;

    public SearchController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String searchStudent(Model model, @Param("firstName") String firstName){
        model.addAttribute("search", studentService.findStudent(firstName));
        System.out.println(studentService.findStudent(firstName));
        return "search_student";
    }
}
