package com.deomo.crudoperation.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(unique = false, nullable = false)          // REST API Request Validation
    private String name;

    @NotNull
    @Column(unique = true, nullable = true)
    private String emailId;

    @NotNull
    @Column(unique = true, nullable =false)
    private Long mob;


}
