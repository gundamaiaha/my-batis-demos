package com.example.my_batis.controller;

import com.example.my_batis.mapper.ToDoMapper;
import com.example.my_batis.model.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
public class TODOController {


    private final ToDoMapper toDoMapper;

    @GetMapping
    public List<TODO> getAll(){
        return toDoMapper.findAll();
    }

    @PostMapping
    public TODO addTODO(@RequestBody TODO todo){
          toDoMapper.createNew(todo);
          return todo;
    }


}
