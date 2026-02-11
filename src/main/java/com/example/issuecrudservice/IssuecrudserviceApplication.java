package com.example.issuecrudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class IssuecrudserviceApplication {

	public IssuecrudserviceApplication(final DataSource dataSource) {
	}

	public static void main(String[] args) {
		SpringApplication.run(IssuecrudserviceApplication.class, args);
	}
}
