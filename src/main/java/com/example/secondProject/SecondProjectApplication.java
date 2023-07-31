package com.example.secondProject;

import com.example.secondProject.repository.StudentRepository;
import com.example.secondProject.service.Mailer;
import com.example.secondProject.service.MailerServiceMailchimp;
import com.example.secondProject.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondProjectApplication.class, args);
	}

}
