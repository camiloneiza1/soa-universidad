package co.edu.ucentral.app.servicio.periodoAcademico.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.common.periodoAcademico.model.PeriodoAcademico;

public interface PeriodoAcademicoRepository extends PagingAndSortingRepository<PeriodoAcademico, Long> {

}
