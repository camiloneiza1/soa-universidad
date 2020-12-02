package co.edu.ucentral.app.servicio.facultad.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.edu.ucentral.common.facultad.model.Facultad;

public interface FacultadRepository extends PagingAndSortingRepository<Facultad, Long> {

}
