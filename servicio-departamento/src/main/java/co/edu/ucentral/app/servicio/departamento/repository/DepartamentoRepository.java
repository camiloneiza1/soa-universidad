package co.edu.ucentral.app.servicio.departamento.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.common.departamento.model.Departamento;

public interface DepartamentoRepository extends PagingAndSortingRepository<Departamento, Long> {

}
