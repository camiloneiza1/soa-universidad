package co.edu.ucentral.app.servicio.evaluacion.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.common.evaluacion.model.Evaluacion;

public interface EvaluacionRepository extends PagingAndSortingRepository<Evaluacion, Long> {

}
