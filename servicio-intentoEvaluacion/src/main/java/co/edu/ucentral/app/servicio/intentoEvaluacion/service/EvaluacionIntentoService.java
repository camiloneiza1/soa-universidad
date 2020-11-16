package co.edu.ucentral.app.servicio.intentoEvaluacion.service;

import java.util.List;

import co.edu.ucentral.common.intentoEvaluacion.model.EvaluacionIntento;
import co.edu.ucentral.servicio.common.service.CommonService;

public interface EvaluacionIntentoService extends CommonService<EvaluacionIntento> {
	public List<EvaluacionIntento> buscarEvaluacionGrupo(Long id);
	
	public List<EvaluacionIntento> buscarEvaluacionEstudiante(Long id);
}
