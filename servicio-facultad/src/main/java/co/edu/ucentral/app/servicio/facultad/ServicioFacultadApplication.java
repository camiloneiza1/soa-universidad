package co.edu.ucentral.app.servicio.facultad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"co.edu.ucentral.common.facultad.model"})
public class ServicioFacultadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioFacultadApplication.class, args);
	}

}
