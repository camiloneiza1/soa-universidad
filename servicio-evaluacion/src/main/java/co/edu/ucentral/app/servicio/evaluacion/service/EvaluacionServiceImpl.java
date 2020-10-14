package co.edu.ucentral.app.servicio.evaluacion.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.evaluacion.repository.EvaluacionRepository;
import co.edu.ucentral.common.evaluacion.model.Evaluacion;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class EvaluacionServiceImpl extends CommonServiceImpl<Evaluacion, EvaluacionRepository> implements EvaluacionService {

}
