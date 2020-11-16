package co.edu.ucentral.app.servicio.intentoEvaluacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.intentoEvaluacion.repository.EvaluacionIntentoRepository;
import co.edu.ucentral.common.intentoEvaluacion.model.EvaluacionIntento;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class EvaluacionIntentoServiceImpl extends CommonServiceImpl<EvaluacionIntento, EvaluacionIntentoRepository> implements EvaluacionIntentoService {

	@Override
	public List<EvaluacionIntento> buscarEvaluacionGrupo(Long id) {
		return repository.buscarEvaluacionGrupo(id);
	}

	@Override
	public List<EvaluacionIntento> buscarEvaluacionEstudiante(Long id) {
		return repository.buscarEvaluacionEstudiante(id);
	}

}
