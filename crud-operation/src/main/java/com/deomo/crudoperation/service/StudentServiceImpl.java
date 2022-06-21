package com.deomo.crudoperation.service;

import com.deomo.crudoperation.domain.Student;
import com.deomo.crudoperation.dto.StudentDto;
import com.deomo.crudoperation.execption.InvalidIdException;
import com.deomo.crudoperation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository repository;

    @Override
    public void createStudent(Student std) {
        repository.save(std);
    }

    @Override
    public StudentDto updateStudent(StudentDto dto) throws InvalidIdException {

        Student student = repository.findById(dto.getId())
                .orElseThrow(
                () -> new InvalidIdException("Enter a valid id number")
        );

        var student1 = new Student();
        student1.setId(dto.getId());
        student1.setName(dto.getName());
        student1.setEmailId(dto.getEmailId());
        student1.setMob(dto.getMob());
        repository.save(student1);
        return dto;

    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Student> findAllStudent() {

        List<Student> list = repository.findAll();
        return list;
    }


    @Override
    public Optional<Student> findStudentById(int id) {
        Optional<Student> list1 = repository.findById(id);
        return list1;

    }

    @Override
    public List<Student> findStudentByName(String name) {
        return repository.findStudentByName(name);
    }

    @Override
    public List<Student> findStudentByNameOrMob(String name, Long mob) {
        return repository.findByNameOrMob(name, mob);
    }


}
