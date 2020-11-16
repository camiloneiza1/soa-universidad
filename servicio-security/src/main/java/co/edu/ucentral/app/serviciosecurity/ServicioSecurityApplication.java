package co.edu.ucentral.app.serviciosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServicioSecurityApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ServicioSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password="12345";
		String passwordEncod= passwordEncoder.encode(password);
		System.out.println(passwordEncod);
		password="abcde";
		passwordEncod= passwordEncoder.encode(password);
		System.out.println(passwordEncod);
		
	}

}
