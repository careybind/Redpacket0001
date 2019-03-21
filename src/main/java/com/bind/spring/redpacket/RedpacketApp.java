package com.bind.spring.redpacket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bind.spring.redpacket.dao")
public class RedpacketApp {
	public static void main(String[] args) {
		SpringApplication.run(RedpacketApp.class, args);
	}

}
