package com.deomo.crudoperation.service;

import com.deomo.crudoperation.domain.Student;
import com.deomo.crudoperation.dto.StudentDto;
import com.deomo.crudoperation.execption.InvalidIdException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void createStudent(Student std);

    List<Student> findAllStudent();

    StudentDto updateStudent(StudentDto std) throws InvalidIdException;

    void deleteStudent(int id);

    Optional<Student> findStudentById(int id);

    List<Student> findStudentByName(String name);

    List<Student> findStudentByNameOrMob(String name, Long mob);



}
