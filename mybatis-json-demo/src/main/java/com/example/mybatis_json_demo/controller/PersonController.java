package com.example.mybatis_json_demo.controller;

import com.example.mybatis_json_demo.mapper.PersonDetailsMapper;
import com.example.mybatis_json_demo.model.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/persons")
public class PersonController {


    private final PersonDetailsMapper personDetailsMapper;


    @GetMapping("/{personId}")
    public PersonDetails getPersonDataById(@PathVariable int personId){
        return personDetailsMapper.getPersonDataById(personId);
    }


}
