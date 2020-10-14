package co.edu.ucentral.app.servicio.pregunta.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.ucentral.common.pregunta.model.Pregunta;

public interface PreguntaRepository extends CrudRepository<Pregunta, Long> {

}
