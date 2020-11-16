package co.edu.ucentral.app.servicio.intentoEvaluacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.ucentral.common.intentoEvaluacion.model.EvaluacionIntento;

public interface EvaluacionIntentoRepository extends CrudRepository<EvaluacionIntento, Long> {

	@Query(value = "select ei.* FROM evaluaciones_intentos ei join estudiantes_grupos eg on ei.estudiante_id = eg.estudiante_id WHERE eg.grupo_id = ?1", nativeQuery = true)
	public List<EvaluacionIntento> buscarEvaluacionGrupo(Long Id);
	
	@Query("select ei from EvaluacionIntento ei join fetch ei.estudiante e where e.id= ?1")
	public List<EvaluacionIntento> buscarEvaluacionEstudiante(Long Id);
}
