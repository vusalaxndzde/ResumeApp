package com.mycompany;

import com.mycompany.dao.impl.UserRepository;
import com.mycompany.dao.inter.CountryDaoInter;
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

	public static void main(String[] args) {
		SpringApplication.run(ResumeAppJpaSpringApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run() {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println(usDao.getCountryByName("Azerbaijan"));
//			}
//		};
//	}

}
