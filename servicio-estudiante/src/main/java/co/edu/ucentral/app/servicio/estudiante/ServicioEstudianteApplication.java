package co.edu.ucentral.app.servicio.estudiante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"co.edu.ucentral.common.estudiante.model"})
public class ServicioEstudianteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioEstudianteApplication.class, args);
	}

}
