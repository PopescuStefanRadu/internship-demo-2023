package com.example.secondProject.controller;

import com.example.secondProject.service.CarService;
import com.example.secondProject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CarService carService;

    @GetMapping("/all/{university}")
    public String getAllStudents(Model model, @PathVariable String university) {
//        model.addAttribute("studentsNames", studentService.getStudentsNamesByUniversity(university));
//        model.addAttribute("studentsAtUniversity", studentService.getByUniversity(university));
        model.addAttribute("special", studentService.getSomethingSpecial("blue", "dark"));
        return "studentsView";
    }
    @GetMapping("/info")
    public String getInfo(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("cars", carService.getCarsByColor("red"));
        return "infoView";
    }
}
