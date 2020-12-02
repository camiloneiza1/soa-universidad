package co.edu.ucentral.app.servicio.curso.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.common.curso.model.Curso;

public interface CursoRepository extends PagingAndSortingRepository<Curso, Long> {

}
