package co.edu.ucentral.app.servicio.grupo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.grupo.repository.GrupoRepository;
import co.edu.ucentral.common.grupo.model.Grupo;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class GrupoServiceImpl extends CommonServiceImpl<Grupo, GrupoRepository> implements GrupoService {

	@Override
	public Optional<Object[]> buscarEstadisticaGrupo(Long id) {
		return repository.buscarEstadisticaGrupo(id);
	}

	

}
