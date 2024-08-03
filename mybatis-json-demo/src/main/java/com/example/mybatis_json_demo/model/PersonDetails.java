package com.example.mybatis_json_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetails {
    private int personId;
    private PersonData personData;
}
