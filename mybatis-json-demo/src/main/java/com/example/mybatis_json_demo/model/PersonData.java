package com.example.mybatis_json_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonData {
    private String name;
    private int age;
    private String email;
}
