package com.mycompany;

import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeAppJpaSpringApplication {

	@Autowired
	@Qualifier(value = "userService1")
	private UserServiceInter userService;

	public static void main(String[] args) {
		SpringApplication.run(ResumeAppJpaSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<User> users = userService.getAll();
				for (User user : users) {
					System.out.println(user.getName() + " " + user.getSurname());
				}
				User u = users.get(0);
				u.setName(u.getName().toLowerCase());
				userService.updateUser(u);
			}
		};
	}

}
