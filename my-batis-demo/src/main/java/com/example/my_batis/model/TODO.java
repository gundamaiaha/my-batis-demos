package com.example.my_batis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TODO {
    private Long id;
    private String title;
    private String body;
}
