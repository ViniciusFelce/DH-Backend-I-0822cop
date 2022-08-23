package br.com.dh.backend.t01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class T01Application {

	public static void main(String[] args) {
		SpringApplication.run(T01Application.class, args);
	}

	@GetMapping
	public String Hello(){
		return "Hello";
	}

}
