package com.example.mybatis_json_demo.controller;

import com.example.mybatis_json_demo.mapper.PersonDetailsMapper;
import com.example.mybatis_json_demo.model.PersonData;
import com.example.mybatis_json_demo.model.PersonDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/persons")
public class PersonController {


    private final PersonDetailsMapper personDetailsMapper;
    private final ObjectMapper objectMapper;


    @GetMapping("/{personId}")
    public PersonDetails getPersonDetailsyId(@PathVariable int personId){
        return personDetailsMapper.getPersonDetailsById(personId);
    }

    @GetMapping
    public List<PersonData> getPersons(){
        return personDetailsMapper.getPersonDataById()
                .stream().map(json ->{
                    try{
                        return objectMapper.readValue(json, PersonData.class);
                    }catch (Exception e){
                        throw new RuntimeException();
                    }
                }).toList();
    }


}
