package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoprojectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(DemoprojectApplication.class, args);
		PersonRepository personRepository = configurableApplicationContext.getBean(PersonRepository.class);

		Person myPerson = new Person("John", "Doe");
		personRepository.save(myPerson);

	}


}
