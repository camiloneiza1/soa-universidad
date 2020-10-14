package co.edu.ucentral.app.servicio.profesor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"co.edu.ucentral.common.profesor.model"})
public class ServicioProfesorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioProfesorApplication.class, args);
	}

}
