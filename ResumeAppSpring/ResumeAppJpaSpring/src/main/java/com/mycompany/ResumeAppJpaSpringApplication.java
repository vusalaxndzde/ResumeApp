package com.mycompany;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
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
	@Qualifier(value = "userDao1")
	private UserDaoInter userDao;

	public static void main(String[] args) {
		SpringApplication.run(ResumeAppJpaSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<User> users = userDao.getAll();
				for (User user : users) {
					System.out.println(user.getName() + " " + user.getSurname());
				}
			}
		};
	}

}
