package co.edu.ucentral.app.servicio.departamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"co.edu.ucentral.common.departamento.model",
			 "co.edu.ucentral.common.facultad.model"})
public class ServicioDepartamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioDepartamentoApplication.class, args);
	}

}
