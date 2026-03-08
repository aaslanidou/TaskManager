package com.example.TaskManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//prwta ftiaxnw db
//kanw connect thn db me springboot
//ftiaxnw entities
//ftiaxnw repositories gia kathe entity
//ftiaxnw ta servicies (egkefalos) gia kathe entity kai tis methodous pou tha exei ( delete,get,update,create)
//gtiaxnw to api gia kathe methodo me swsto path prosoxh se oneToMany klp
//ftiaxnw dto gia na ksexwrisw ta db columns apo to api(an allaksw columnName na mhn xalasei kai to Api mou(path{}))
//validation px jakarta.validation annotations 
// @NotBlank, @Size,  @Email sta DTOs kai vale @Valid annotation sto controller
//Unit Tests
//API Documentation (Swagger/OpenAPI)


@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

}
