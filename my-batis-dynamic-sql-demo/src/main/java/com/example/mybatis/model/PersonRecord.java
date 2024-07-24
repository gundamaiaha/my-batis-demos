package com.example.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRecord {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Boolean employed;
    private String occupation;
    private Integer addressId;
}
