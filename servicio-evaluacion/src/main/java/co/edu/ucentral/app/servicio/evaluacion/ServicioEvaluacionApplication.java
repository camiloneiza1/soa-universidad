package co.edu.ucentral.app.servicio.evaluacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"co.edu.ucentral.common.evaluacion.model",
			 "co.edu.ucentral.common.grupo.model",
			 "co.edu.ucentral.common.profesor.model",
			 "co.edu.ucentral.common.curso.model",
			 "co.edu.ucentral.common.periodoAcademico.model",
			 "co.edu.ucentral.common.departamento.model",
			 "co.edu.ucentral.common.facultad.model",
			 "co.edu.ucentral.common.estudiante.model",
			 "co.edu.ucentral.common.pregunta.model"})
public class ServicioEvaluacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioEvaluacionApplication.class, args);
	}

}
