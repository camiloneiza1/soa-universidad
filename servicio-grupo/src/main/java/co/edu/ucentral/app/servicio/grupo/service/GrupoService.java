package co.edu.ucentral.app.servicio.grupo.service;

import java.util.Optional;

import co.edu.ucentral.common.grupo.model.Grupo;
import co.edu.ucentral.servicio.common.service.CommonService;

public interface GrupoService extends CommonService<Grupo> {
	public Optional<Object[]> buscarEstadisticaGrupo(Long id);
}
