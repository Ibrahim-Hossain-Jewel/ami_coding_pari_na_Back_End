package com.ami_coding_pari_na.ami_coding_pari_na;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AmiCodingPariNaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmiCodingPariNaApplication.class, args);
		System.out.println("Project is running!");
	}

}
