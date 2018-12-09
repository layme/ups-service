package com.ziroom.ups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class UpsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpsServiceApplication.class, args);
	}
}
