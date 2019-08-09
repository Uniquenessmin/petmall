package com.newer.petmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.newer.petmall.mapper")
@SpringBootApplication
public class PetmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetmallApplication.class, args);
	}

}
