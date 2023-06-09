package com.example.mvc.crud;

import com.example.mvc.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    // 복수의 studentDto 담는 변수
    private final List<StudentDto> studentList = new ArrayList<>();
    private Long nextId = 1L;
    // 새로운 StudentDto 생성하는 메서드
    public StudentDto createStudent(String name, String email) {
        StudentDto newStudent = new StudentDto(
                nextId, name, email
        );
        nextId++;
        studentList.add(newStudent);
        return newStudent;
    }

    public List<StudentDto> readStudentAll() {
        return studentList;
    }

    public StudentDto readStudent(Long id) {
        for (StudentDto studentDto: studentList) {
            if (studentDto.getId().equals(id))
                return studentDto;
        }
        return null;
//                .stream()
//                .filter(studentDto -> studentDto.getId().equals(id))
//                .findFirst()
//                .orElse(null);
    }
}
