package com.todo.taskrepositoryavla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan("com.todo.taskrepositoryavla")
@EnableJpaRepositories("com.todo.taskrepositoryavla.repository")
@EntityScan("com.todo.taskrepositoryavla.entity")
@SpringBootApplication
public class TaskRepositoryAvlaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskRepositoryAvlaApplication.class, args);
	}

}
