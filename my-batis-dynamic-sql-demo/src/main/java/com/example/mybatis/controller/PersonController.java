package com.example.mybatis.controller;

import com.example.mybatis.mapper.PersonMapper;
import com.example.mybatis.model.PersonRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {


    @Autowired
    private PersonMapper personMapper;


    @PostMapping("/lastNames")
    public List<PersonRecord> getPersonByLastName(@RequestBody Set<String> lastNames){
        return personMapper.findPersonsByLastNames(lastNames);
    }


}
