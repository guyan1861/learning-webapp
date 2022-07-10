package com.guyan.think.in;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.guyan.think.in.mybatis.mapper")
public class ThinkingInMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkingInMybatisApplication.class, args);
	}

}
