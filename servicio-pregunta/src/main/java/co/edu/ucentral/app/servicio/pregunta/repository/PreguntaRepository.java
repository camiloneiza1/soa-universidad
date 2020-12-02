package co.edu.ucentral.app.servicio.pregunta.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.common.pregunta.model.Pregunta;

public interface PreguntaRepository extends PagingAndSortingRepository<Pregunta, Long> {

}
