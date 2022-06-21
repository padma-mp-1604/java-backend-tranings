package com.deomo.crudoperation.dto;

import com.sun.istack.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private int id;

    @NotNull
    private String name;

    private String emailId;

    @NotNull
    private Long mob;
}
