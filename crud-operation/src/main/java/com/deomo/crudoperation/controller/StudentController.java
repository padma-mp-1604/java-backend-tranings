package com.deomo.crudoperation.controller;

import com.deomo.crudoperation.domain.Student;
import com.deomo.crudoperation.dto.AppResponse;
import com.deomo.crudoperation.dto.StudentDto;
import com.deomo.crudoperation.execption.InvalidIdException;
import com.deomo.crudoperation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping(value = "/create")
    public ResponseEntity<AppResponse<Integer>> createStudentDetails(@Valid @RequestBody Student std) {

        service.createStudent(std);

        var response = new AppResponse<Integer>();
        response.setMsg("Student created successfully");
        response.setSts("success");
        response.setBody(0);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<AppResponse<StudentDto>> updateStudentInfo(@Valid @RequestBody StudentDto dtos) throws InvalidIdException {
        try {
            var student = service.updateStudent(dtos);
            var response = new AppResponse<StudentDto>();
            response.setSts("success");
            response.setMsg("student information updated");
            response.setBody(student);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidIdException e) {
            var response = new AppResponse<StudentDto>();
            response.setSts("fail");
            response.setMsg(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppResponse<StudentDto>> deleteStudent(@PathVariable("id") int id) {  // we need to take the id from the path of the url so

        service.deleteStudent(id);
        var response = new AppResponse<StudentDto>();
        response.setSts("success");
        response.setMsg("student deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<AppResponse<List<Student>>> findAll() {
        var response = new AppResponse<List<Student>>();
        response.setMsg("Student list");
        response.setSts("success");
        response.setBody(service.findAllStudent());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getStudentById/{id}")
    public Optional<Student> findStudentById(@PathVariable int id){
        return service.findStudentById(id);
    }

    @GetMapping("/getStudentByName/{name}")
    public List<Student> findStudentByName(@PathVariable String name) {
        return service.findStudentByName(name);
    }

//    @GetMapping("/getStudentByName/{name}")
//    public ResponseEntity<AppResponse<StudentDto>> findStudentByName(@PathVariable String name) {  // we need to take the id from the path of the url so
//
//        service.findStudentByName(name);
//        var response = new AppResponse<StudentDto>();
//        response.setSts("success");
//        response.setMsg("find student successfully");
//
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/getStudentByNameOrMob/{name}/{mob}")
    public List<Student> findStudentByNameOrMob(@PathVariable String name, @PathVariable Long mob) {
        return  service.findStudentByNameOrMob(name, mob);
    }

}

