package com.deomo.crudoperation.repository;

import com.deomo.crudoperation.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {         // <entity class we want to manage, primary key entity class>

    // How to Write Custom Finder Method Of Spring Data JPA Repository | Derived Query Method : Spring Boot

    public List<Student> findStudentByName(String name);

    public List<Student> findByNameOrMob(String name, Long mob);

}
