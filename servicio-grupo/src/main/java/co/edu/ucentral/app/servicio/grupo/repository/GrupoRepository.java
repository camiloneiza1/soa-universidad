package co.edu.ucentral.app.servicio.grupo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.ucentral.common.grupo.model.Grupo;

public interface GrupoRepository extends CrudRepository<Grupo, Long> {
	@Query(value = "SELECT AVG(ei.calificacion) as prom, COUNT(ei.id) cant, MAX(ei.calificacion) maxima, MIN(ei.calificacion) minima FROM evaluaciones_intentos ei join estudiantes_grupos eg on ei.estudiante_id = eg.estudiante_id join grupos g on g.id = eg.grupo_id WHERE eg.grupo_id = ?1", nativeQuery = true)
	public Optional<Object[]> buscarEstadisticaGrupo(Long id);
}
