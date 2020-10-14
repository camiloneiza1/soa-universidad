package co.edu.ucentral.app.servicio.periodoAcademico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"co.edu.ucentral.common.periodoAcademico.model"})
public class ServicioPeriodoAcademicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioPeriodoAcademicoApplication.class, args);
	}

}
