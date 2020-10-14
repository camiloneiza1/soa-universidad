package co.edu.ucentral.app.servicio.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"co.edu.ucentral.common.curso.model",
			 "co.edu.ucentral.common.periodoAcademico.model",
			 "co.edu.ucentral.common.facultad.model",
			 "co.edu.ucentral.common.departamento.model",})
public class ServicioCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioCursoApplication.class, args);
	}

}
