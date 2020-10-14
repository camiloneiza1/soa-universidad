package co.edu.ucentral.app.servicio.profesor.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.ucentral.common.profesor.model.Profesor;

public interface ProfesorRepository extends CrudRepository<Profesor, Long> {

}
