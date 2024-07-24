package com.example.my_batis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.my_batis.mapper")
public class MyBatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisDemoApplication.class, args);
	}

}
