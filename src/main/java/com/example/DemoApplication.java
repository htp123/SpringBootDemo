package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@RestController*/
/*@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)*/
@SpringBootApplication()
@MapperScan(value = "com.example.mapper")

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

/*	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
		//修改Banner的模式为OFF
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}*/
/*
	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
	String index(){
		return "Hello Spring Boot!";
	}*/
}
