package co.edu.ucentral.app.servicio.estudiante.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.common.estudiante.model.Estudiante;

public interface EstudianteRepository extends PagingAndSortingRepository<Estudiante, Long> {
	
}
