package com.mycompany;

import com.mycompany.dao.impl.UserRepository;
import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableCaching
public class ResumeAppJpaSpringApplication {

//	@Autowired
//	@Qualifier("userDao1")
//	private UserRepositoryCustom userRepo;

	public static void main(String[] args) {
		SpringApplication.run(ResumeAppJpaSpringApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run() {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//
//				userRepo.addUser(new User(null, "vusal@gmail.com", "12345"));
//			}
//		};
//	}

}
