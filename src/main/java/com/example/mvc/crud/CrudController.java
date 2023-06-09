package com.example.mvc.crud;

import com.example.mvc.model.StudentDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrudController {
    private final StudentService studentService;

    public CrudController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/create-view")
    public String createView() {
        return "crud/create";
    }

    @PostMapping("/create")
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("email")
            String email
    ) {
        System.out.println(name);
        System.out.println(email);
        StudentDto studentDto
                = studentService.createStudent(name, email);
        System.out.println(studentDto.toString());
        return "redirect:/crudhome";
    }

    @GetMapping("/crudhome")
    public String home(Model model) {
        model.addAttribute(
                "studentDTO",
                studentService.readStudentAll()
        );
        return "crud/crudhome";
    }

    @GetMapping("/{id}") // {} <- 특정 아이디를 가져오게끔 설정
    public String read(@PathVariable("id") Long id, Model model) {
        // @PathVariable - URL 경로에 변수를 넣어준다.
        model.addAttribute(
                "student",
                studentService.readStudent(id)
        );
        return "crud/read";
    }
}
