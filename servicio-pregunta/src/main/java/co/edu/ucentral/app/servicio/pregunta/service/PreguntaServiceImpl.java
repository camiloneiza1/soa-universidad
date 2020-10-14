package co.edu.ucentral.app.servicio.pregunta.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.app.servicio.pregunta.repository.PreguntaRepository;
import co.edu.ucentral.common.pregunta.model.Pregunta;
import co.edu.ucentral.servicio.common.service.CommonServiceImpl;

@Service
public class PreguntaServiceImpl extends CommonServiceImpl<Pregunta, PreguntaRepository> implements PreguntaService {

}
