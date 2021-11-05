package com.epam;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.epam.constants.CommonConstants;
import com.epam.security.config.SecurityConfig;
import com.epam.security.models.AppUser;
import com.epam.security.models.Role;
import com.epam.security.services.AppUserService;

@SpringBootApplication( exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class} )
@Import(SecurityConfig.class)
public class MessengerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MessengerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(AppUserService appUserService) {
		return args -> {
			appUserService.saveRole(new Role(null, CommonConstants.ROLE_ADMIN));
			appUserService.saveRole(new Role(null, CommonConstants.ROLE_USER));
			
			appUserService.saveUser(new AppUser(null, "Chandan Kumar", "chandan", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Venu Vaka", "venu", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Swapnil Tajve", "swapnil", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Abhinav Bajaj", "abhinav", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Pranjal Soni", "pranjal", "1234", new ArrayList<>()));
			
			appUserService.addRoleToUser("chandan", CommonConstants.ROLE_USER);
			appUserService.addRoleToUser("chandan", CommonConstants.ROLE_ADMIN);
			appUserService.addRoleToUser("venu", CommonConstants.ROLE_USER);
			appUserService.addRoleToUser("swapnil", CommonConstants.ROLE_USER);
			appUserService.addRoleToUser("abhinav", CommonConstants.ROLE_USER);
			appUserService.addRoleToUser("pranjal", CommonConstants.ROLE_USER);
		};	
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
