package com.mycompany;

import com.mycompany.dao.impl.UserRepository;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeAppJpaSpringApplication {

	@Autowired
	@Qualifier(value = "userService1")
	private UserServiceInter userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CountryDaoInter usDao;

	public static void main(String[] args) {
		SpringApplication.run(ResumeAppJpaSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println(usDao.getCountryByName("Azerbaijan"));
			}
		};
	}

}
