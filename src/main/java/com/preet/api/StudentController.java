package com.preet.api;

import com.preet.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    private Environment environment;

    @GetMapping(value = "/student/info")
    public ResponseEntity<?> getServerPort(){
        String s = "working on port " + environment.getProperty("local.server.port");
        return ResponseEntity.ok().body(s);
    }


    @GetMapping(value = "/student")
    public ResponseEntity<?> getStudents(){
        List<Student> studentList=getAllStudents();
        return ResponseEntity.ok().body(studentList);
    }

    @GetMapping(value = "/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id){
        List<Student> studentList=getAllStudents();
        studentList = studentList.stream()
                .filter(student -> student.getId() == Long.parseLong(id))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(studentList);
    }

    private List<Student> getAllStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"test1","demo1",101));
        studentList.add(new Student(2,"test2","demo2",101));
        studentList.add(new Student(3,"test3","demo3",101));
        studentList.add(new Student(4,"test4","demo4",101));
        studentList.add(new Student(5,"test5","demo5",101));
        studentList.add(new Student(6,"test6","demo6",101));
        studentList.add(new Student(7,"test7","demo7",101));
        return studentList;
    }

}
